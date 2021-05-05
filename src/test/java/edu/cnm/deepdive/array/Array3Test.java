package edu.cnm.deepdive.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Array3Test {

  @ParameterizedTest(name = "[{index}]Asserting maxSpan({0}) = {1}")
  @MethodSource({"edu.cnm.deepdive.array.Array3TestSource#maxSpan"})
  void maxSpan(int[] input, int expected) {
    assertEquals(expected, Array3.maxSpan(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting fix34({0}) = {1}")
  @MethodSource({"edu.cnm.deepdive.array.Array3TestSource#fix34"})
  void fix34(int[] input, int[] expected) {
    assertArrayEquals(expected, Array3.fix34(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting fix45({0}) = {1}")
  @MethodSource({"edu.cnm.deepdive.array.Array3TestSource#fix45"})
  void fix45(int[] input, int[] expected) {
    assertArrayEquals(expected, Array3.fix45(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting canBalance({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.array.Array3TestSource#canBalance")
  void canBalance(int[] input, boolean expected) {
    assertEquals(expected, Array3.canBalance(input));
  }

}