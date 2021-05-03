package edu.cnm.deepdive.map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Map2Test {

  @ParameterizedTest(name = "[{index}]Asserting word0({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.map.Map2TestSource#word0")
  void word0(String[] input, Map<String, Integer> expected) {
    assertEquals(expected, Map2.word0(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting wordLen({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.map.Map2TestSource#wordLen")
  void wordLen(String[] input, Map<String, Integer> expected) {
    assertEquals(expected, Map2.wordLen(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting pairs({0}) == {1}")
  @MethodSource("edu.cnm.deepdive.map.Map2TestSource#pairs")
  void pairs(String[] input, Map<String, String> expected) {
    assertEquals(expected, Map2.pairs(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting wordCount({0}) == {1}")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#wordCount"})
  void wordCount(String[] input, Map<String, Integer> expected) {
    assertEquals(expected, Map2.wordCount(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting firstChar({0}) == {1}")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#firstChar"})
  void firstChar(String[] input, Map<String, String> expected) {
    assertEquals(expected, Map2.firstChar(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting wordAppend({0}) == \"{1}\"")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#wordAppend"})
  void wordAppend(String[] input, String expected) {
    assertEquals(expected, Map2.wordAppend(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting wordMultiple({0}) == {1}")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#wordMultiple"})
  void wordMultiple(String[] input, Map<String, Boolean> expected) {
    assertEquals(expected, Map2.wordMultiple(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting allSwap({0}) == {1}")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#allSwap"})
  void allSwap(String[] input, String[] expected) {
    assertArrayEquals(expected, Map2.allSwap(input));
  }

  @ParameterizedTest(name = "[{index}]Asserting firstSwap({0}) == {1}")
  @MethodSource({"edu.cnm.deepdive.map.Map2TestSource#firstSwap"})
  void firstSwap(String[] input, String[] expected) {
    assertArrayEquals(expected, Map2.firstSwap(input));
  }

}