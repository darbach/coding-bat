package edu.cnm.deepdive.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Harder array problems -- 2 loops, more complex logic. See the
 * <a href="https://codingbat.com/doc/array.html">Java Arrays and Loops</a> document for
 * help.
 * <p>
 * See <a href="https://codingbat.com/java/Array-3">https://codingbat.com/java/Array-3</a>.
 *
 * @author Daniel Arbach
 */
public abstract class Array3 {

  /**
   * Consider the leftmost and righmost appearances of some value in an array. We'll say that the
   * "span" is the number of elements between the two inclusive. A single value has a span of 1.
   * Returns the largest span found in the given array. (Efficiency is not a priority.)
   * <p>
   * maxSpan([1, 2, 1, 1, 3]) → 4 maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6 maxSpan([1, 4, 2, 1, 4, 4, 4])
   * → 6
   *
   * @param nums A set of numbers to be operated upon.
   * @return The largest span between two of the same values, inclusive.
   */
  public static int maxSpan(int[] nums) {
    int largest = 0;
    Map<Integer, Integer> firstAppearances = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = nums[i];
      firstAppearances.putIfAbsent(key, i);
      int span = i - firstAppearances.get(key) + 1;
      largest = Math.max(largest, span);
    }
    return largest;
  }

  /**
   * Return an array that contains exactly the same numbers as the given array, but rearranged so
   * that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may
   * move. The array contains the same number of 3's and 4's, every 3 has a number after it that is
   * not a 3, and a 3 appears in the array before any 4.
   * <p>
   * fix34([1, 3, 1, 4]) → [1, 3, 4, 1] fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
   * fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
   *
   * @param nums An array of numbers to be operated upon.
   * @return The rearranged array of numbers
   */
  public static int[] fix34(int[] nums) {
    int[] arranged = new int[nums.length];
    Deque<Integer> filler = new LinkedList<>();
    // Fill in the 3s and 4s.
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 3) {
        arranged[i] = 3;
        arranged[i + 1] = 4;
      } else if (nums[i] != 4) { // && nums[i] != 3, so value is a filler number
        filler.add(nums[i]);
      }
    }
    // Fill in the rest.
    for (int i = 0; i < arranged.length; i++) {
      if (arranged[i] != 3 && arranged[i] != 4) {
        arranged[i] = filler.removeFirst();
      }
    }
    return arranged;
  }

  /**
   * (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly
   * the same numbers as the given array, but rearranged so that every 4 is immediately followed by
   * a 5. Do not move the 4's, but every other number may move. The array contains the same number
   * of 4's and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may
   * appear anywhere in the original array.
   *
   * @param nums An array of numbers to be operated upon.
   * @return The rearranged array of numbers
   */
  public static int[] fix45(int[] nums) {
    int[] arranged = new int[nums.length];
    Deque<Integer> filler = new LinkedList<>();
    // Fill in the 4s and 5s.
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 4) {
        arranged[i] = 4;
        arranged[i + 1] = 5;
      } else if (nums[i] != 5) { // && nums[i] != 4, so value is a filler number
        filler.add(nums[i]);
      }
    }
    // Fill in the rest.
    for (int i = 0; i < arranged.length; i++) {
      if (arranged[i] != 4 && arranged[i] != 5) {
        arranged[i] = filler.removeFirst();
      }
    }
    return arranged;
  }

  /**
   * Given a non-empty array, return true if there is a place to split the array so that the sum of
   * the numbers on one side is equal to the sum of the numbers on the other side.
   * <p>
   * canBalance([1, 1, 1, 2, 1]) → true canBalance([2, 1, 1, 2, 1]) → false canBalance([10, 10]) →
   * true
   *
   * @param nums a set of numbers
   * @return whether there is a place to split the array
   */
  public static boolean canBalance(int[] nums) { // O(n) time, 0(1) space
    boolean balanced = false;
    int rightSum = 0;
    for (int value : nums) { //calculate the total sum for a later add/subtract pass
      rightSum += value;
    }
    if (rightSum == 0) { // special case
      balanced = true;
    } else if (rightSum % 2 == 0){ // an odd sum cannot be balanced
      int leftSum = 0;
      for (int value : nums) {
        if ((leftSum += value) == (rightSum -= value)) {
          balanced = true;
          break;
        }
      }
    }
    return balanced;
  }

}

