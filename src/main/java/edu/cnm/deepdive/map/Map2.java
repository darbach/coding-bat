package edu.cnm.deepdive.map;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://codingbat.com/java/Map-2">Maps</a> with bulk data and loops. See the
 * <a href="https://codingbat.com/doc/java-map-wordcount.html">Java Map WordCount</a> for help.
 *
 * @author Daniel Arbach
 */
public abstract class Map2 {

  /**
   * Given an {@link Array} of {@link String Strings}, return a Map<String, Integer> containing a
   * key for every different string in the array, always with the value 0. For example the string
   * "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this
   * problem the value is simply 0.
   * <p>
   * word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0} word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b":
   * 0, "c": 0} word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
   *
   * @param strings The array to be processed
   * @return A Map containing every "string" as a key and 0 as the values
   */
  public static Map<String, Integer> word0(String[] strings) {
    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : strings) {
      wordMap.put(word, 0);
    }
    return wordMap;
  }

  /**
   * Given an array of strings, return a Map<String, Integer> containing a key for every different
   * string in the array, and the value is that string's length.
   * <p>
   * wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1} wordLen(["this", "and", "that", "and"]) →
   * {"that": 4, "and": 3, "this": 4} wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug":
   * 3}
   *
   * @param strings The array to be processed
   * @return A map containing every string and it's length
   */
  public static Map<String, Integer> wordLen(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : strings) {
      map.put(word, word.length());
    }
    return map;
  }

  /**
   * Given an array of non-empty strings, create and return a Map<String, String> as follows: for
   * each string add its first character as a key with its last character as the value.
   * <p>
   * pairs(["code", "bug"]) → {"b": "g", "c": "e"} pairs(["man", "moon", "main"]) → {"m": "n"}
   * pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
   *
   * @param strings The array to be processed
   * @return A map containing the first letter as key and last letter as value
   */
  public static Map<String, String> pairs(String[] strings) {
    Map<String, String> map = new HashMap<>();
    for (String word : strings) {
      int len = word.length();
      map.put(word.substring(0, 1), word.substring(len - 1, len));
    }
    return map;
  }

  /**
   * The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with
   * a key for each different string, with the value the number of times that string appears in the
   * array.
   * <p>
   * wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1} wordCount(["c", "b", "a"]) →
   * {"a": 1, "b": 1, "c": 1} wordCount(["c", "c", "c", "c"]) → {"c": 4}
   *
   * @param strings The array to be processed
   * @return A map containing the string as key and count as value
   */
  public static Map<String, Integer> wordCount(String[] strings) {
    Map<String, Integer> counts = new HashMap<>();
    for (String key : strings) {
      int count;
      if (!counts.containsKey(key)) {
        count = 1;
      } else {
        count = counts.get(key) + 1;
      }
      counts.put(key, count);
    }
    return counts;
  }

  /**
   * Given an array of non-empty strings, return a Map<String, String> with a key for every
   * different first character seen, with the value of all the strings starting with that character
   * appended together in the order they appear in the array.
   * <p>
   * firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
   * firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d":
   * "d"} firstChar([]) → {}
   *
   * @param strings The array to be processed
   * @return Map with first character as key and all remaining strings with that starting key
   * appended as value
   */
  public static Map<String, String> firstChar(String[] strings) {
    Map<String, String> map = new HashMap<>();
    for (String word : strings) {
      String key = word.substring(0, 1);
      String value = map.containsKey(key)
          ? map.get(key).concat(word)
          : word;
      map.put(key, value);
    }
    return map;
  }

  /**
   * Loop over the given array of strings to build a result string like this: when a string appears
   * the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty
   * string if no string appears a 2nd time.
   * <p>
   * wordAppend(["a", "b", "a"]) → "a" wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
   * wordAppend(["a", "", "a"]) → "a"
   *
   * @param strings The array to be processed
   * @return A string with array elements appended every time they appeared an even number of times
   */
  public static String wordAppend(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    StringBuilder result = new StringBuilder();
    for (String key : strings) {
      int count = map.containsKey(key)
          ? map.get(key) + 1
          : 1;
      map.put(key, count);
      if (count % 2 == 0) {
        result.append(key);
      }
    }
    return result.toString();
  }

  /**
   * Given an array of strings, return a Map<String, Boolean> where each different string is a key
   * and its value is true if that string appears 2 or more times in the array.
   * <p>
   * wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false} wordMultiple(["c",
   * "b", "a"]) → {"a": false, "b": false, "c": false} wordMultiple(["c", "c", "c", "c"]) → {"c":
   * true}
   *
   * @param strings The array to be processed
   * @return A map showing whether the key has appeared 2 or more times
   */
  public static Map<String, Boolean> wordMultiple(String[] strings) {
    Map<String, Boolean> map = new HashMap<>();
    for (String key : strings) {
      if (!map.containsKey(key)) {
        // put it in the first time, not yet >= 2
        map.put(key, false);
      } else {
        map.put(key, true);
      }
    }
    return map;
  }

  /**
   * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop
   * over and then return the given array of non-empty strings as follows: if a string matches an
   * earlier string in the array, swap the 2 strings in the array. When a position in the array has
   * been swapped, it no longer matches anything. Using a map, this can be solved making just one
   * pass over the array. More difficult than it looks.
   * <p>
   * allSwap(["ab", "ac"]) → ["ac", "ab"] allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa",
   * "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"] allSwap(["ax", "bx", "ay", "by",
   * "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
   *
   * @param strings The array to be processed
   * @return Positions swapped when the first letter matches for a pair
   */
  public static String[] allSwap(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      String key = strings[i].substring(0, 1);
      if (map.containsKey(key)) {
        String temp = strings[i];
        int swapIndex = map.get(key);
        strings[i] = strings[swapIndex];
        strings[swapIndex] = temp;
        map.remove(key);
      } else {
        map.put(key, i);
      }
    }
    return strings;
  }

  /**
   * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop
   * over and then return the given array of non-empty strings as follows: if a string matches an
   * earlier string in the array, swap the 2 strings in the array. A particular first char can only
   * cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this
   * can be solved making just one pass over the array. More difficult than it looks.
   * <p>
   * firstSwap(["ab", "ac"]) → ["ac", "ab"] firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa",
   * "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"] firstSwap(["ax", "bx", "ay", "by",
   * "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
   *
   * @param strings The array to be processed
   * @return The array with swapped values
   */
  public static String[] firstSwap(String[] strings) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      String key = strings[i].substring(0, 1);
      if (map.containsKey(key)) {
        if (map.get(key) != -1) {
          String temp = strings[i];
          int swapIndex = map.get(key);
          strings[i] = strings[swapIndex];
          strings[swapIndex] = temp;
          map.put(key, -1); // mark the key as unswappable
        }
      } else {
        map.put(key, i);
      }
    }
    return strings;
  }

}
