package edu.cnm.deepdive.map;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 * Used for JUnit parameterized MethodSource testing.
 */
public class Map2TestSource {

  public static Stream<Arguments> word0() {
    //^.*word0\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"a", "b", "a", "b"}, Map.of("a", 0, "b", 0)),
        Arguments.of(new String[]{"a", "b", "a", "c", "b"}, Map.of("a", 0, "b", 0, "c", 0)),
        Arguments.of(new String[]{"c", "b", "a"}, Map.of("a", 0, "b", 0, "c", 0)),
        Arguments.of(new String[]{"c", "c", "c", "c"}, Map.of("c", 0)),
        Arguments.of(new String[]{}, Map.of())
    );
  }

  public static Stream<Arguments> wordLen() {
    //^.*wordLen\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"a", "bb", "a", "bb"}, Map.of("bb", 2, "a", 1)),
        Arguments.of(new String[]{"this", "and", "that", "and"}, Map.of("that", 4, "and", 3, "this", 4)),
        Arguments.of(new String[]{"code", "code", "code", "bug"}, Map.of("code", 4, "bug", 3)),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"z"}, Map.of("z", 1))
    );
  }

  public static Stream<Arguments> pairs() {
    //^.*pairs\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"code", "bug"}, Map.of("b", "g", "c", "e")),
        Arguments.of(new String[]{"man", "moon", "main"}, Map.of("m", "n")),
        Arguments.of(new String[]{"man", "moon", "good", "night"}, Map.of("g", "d", "m", "n", "n", "t")),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"a", "b"}, Map.of("a", "a", "b", "b")),
        Arguments.of(new String[]{"are", "codes", "and", "cods"}, Map.of("a", "d", "c", "s")),
        Arguments.of(new String[]{"apple", "banana", "tea", "coffee"}, Map.of("a", "e", "b", "a", "c", "e", "t", "a"))
    );
  }

  static Stream<Arguments> wordCount() {
    return Stream.of(
        Arguments.of(new String[]{"a", "b", "a", "c", "b"}, Map.of("a", 2, "b", 2, "c", 1)),
        Arguments.of(new String[]{"c", "b", "a"}, Map.of("a", 1, "b", 1, "c", 1)),
        Arguments.of(new String[]{"c", "c", "c", "c"}, Map.of("c", 4)),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"this", "and", "this", ""}, Map.of("", 1, "and", 1, "this", 2)),
        Arguments.of(new String[]{"x", "y", "x", "Y", "X"}, Map.of("x", 2, "X", 1, "y", 1, "Y", 1)),
        Arguments.of(new String[]{"123", "0", "123", "1"}, Map.of("0", 1, "1", 1, "123", 2)),
        Arguments.of(new String[]{"d", "a", "e", "d", "a", "d", "b", "b", "z", "a", "a", "b", "z", "x", "b", "f", "x", "two", "b", "one", "two"}, Map.of("a", 4, "b", 5, "d", 3, "e", 1, "f", 1, "one", 1, "x", 2, "z", 2, "two", 2)),
        Arguments.of(new String[]{"apple", "banana", "apple", "apple", "tea", "coffee", "banana"}, Map.of("banana", 2, "apple", 3, "tea", 1, "coffee", 1))
    );
  }

  static Stream<Arguments> firstChar() {
    //^.*firstChar\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"salt", "tea", "soda", "toast"}, Map.of("s", "saltsoda", "t", "teatoast")),
        Arguments.of(new String[]{"aa", "bb", "cc", "aAA", "cCC", "d"}, Map.of("a", "aaaAA", "b", "bb", "c", "cccCC", "d", "d")),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"apple", "bells", "salt", "aardvark", "bells", "sun", "zen", "bells"}, Map.of("a", "appleaardvark", "b", "bellsbellsbells", "s", "saltsun", "z", "zen"))
    );
  }

  static Stream<Arguments> wordAppend() {
    //^.*wordAppend\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"a", "b", "a"}, "a"),
        Arguments.of(new String[]{"a", "b", "a", "c", "a", "d", "a"}, "aa"),
        Arguments.of(new String[]{"a", "", "a"}, "a"),
        Arguments.of(new String[]{}, ""),
        Arguments.of(new String[]{"a", "b", "b", "a", "a"}, "ba"),
        Arguments.of(new String[]{"a", "b", "b", "b", "a", "c", "a", "a"}, "baa"),
        Arguments.of(new String[]{"a", "b", "b", "b", "a", "c", "a", "a", "a", "b", "a"}, "baaba"),
        Arguments.of(new String[]{"not", "and", "or", "and", "this", "and", "or", "that", "not"}, "andornot"),
        Arguments.of(new String[]{"a", "b", "c"}, ""),
        Arguments.of(new String[]{"this", "or", "that", "and", "this", "and", "that"}, "thisandthat"),
        Arguments.of(new String[]{"xx", "xx", "yy", "xx", "zz", "yy", "zz", "xx"}, "xxyyzzxx")
    );
  }

  static Stream<Arguments> wordMultiple() {
    //^.*wordMultiple\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, Map.of($2)),
    return Stream.of(
        Arguments.of(new String[]{"a", "b", "a", "c", "b"}, Map.of("a", true, "b", true, "c", false)),
        Arguments.of(new String[]{"c", "b", "a"}, Map.of("a", false, "b", false, "c", false)),
        Arguments.of(new String[]{"c", "c", "c", "c"}, Map.of("c", true)),
        Arguments.of(new String[]{}, Map.of()),
        Arguments.of(new String[]{"this", "and", "this"}, Map.of("and", false, "this", true)),
        Arguments.of(new String[]{"d", "a", "e", "d", "a", "d", "b", "b", "z", "a", "a", "b", "z", "x"}, Map.of("a", true, "b", true, "d", true, "e", false, "x", false, "z", true))
    );
  }

  static Stream<Arguments> allSwap() {
    //^.*allSwap\(\[(.*)\].*\{(.*)\}\s+\{.*$
    //Arguments.of(new String[]{$1}, new String[]{$2}),
    return Stream.of(
        Arguments.of(new String[]{"ab", "ac"}, new String[]{"ac", "ab"}),
        Arguments.of(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"}, new String[]{"ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"}),
        Arguments.of(new String[]{"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"}, new String[]{"ay", "by", "ax", "bx", "aj", "ai", "by", "bx"}),
        Arguments.of(new String[]{"ax", "bx", "cx", "ay", "cy", "aaa", "abb"}, new String[]{"ay", "bx", "cy", "ax", "cx", "abb", "aaa"}),
        Arguments.of(new String[]{"easy", "does", "it", "every", "ice", "eaten"}, new String[]{"every", "does", "ice", "easy", "it", "eaten"}),
        Arguments.of(new String[]{"list", "of", "words", "swims", "over", "lily", "water", "wait"}, new String[]{"lily", "over", "water", "swims", "of", "list", "words", "wait"}),
        Arguments.of(new String[]{"4", "8", "15", "16", "23", "42"}, new String[]{"42", "8", "16", "15", "23", "4"}),
        Arguments.of(new String[]{"aaa"}, new String[]{"aaa"}),
        Arguments.of(new String[]{}, new String[]{}),
        Arguments.of(new String[]{"a", "b", "c", "xx", "yy", "zz"}, new String[]{"a", "b", "c", "xx", "yy", "zz"})
    );
  }

  static Stream<Arguments> firstSwap() {
    //^.*firstSwap\(\[(.*)\].*\[(.*)\]\s*\[.*$
    //Arguments.of(new String[]{$1}, new String[]{$2}),
    return Stream.of(
        Arguments.of(new String[]{"ab", "ac"}, new String[]{"ac", "ab"}),
        Arguments.of(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"}, new String[]{"ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"}),
        Arguments.of(new String[]{"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"}, new String[]{"ay", "by", "ax", "bx", "ai", "aj", "bx", "by"}),
        Arguments.of(new String[]{"ax", "bx", "cx", "ay", "cy", "aaa", "abb"}, new String[]{"ay", "bx", "cy", "ax", "cx", "aaa", "abb"}),
        Arguments.of(new String[]{"easy", "does", "it", "every", "ice", "eaten"}, new String[]{"every", "does", "ice", "easy", "it", "eaten"}),
        Arguments.of(new String[]{"list", "of", "words", "swims", "over", "lily", "water", "wait"}, new String[]{"lily", "over", "water", "swims", "of", "list", "words", "wait"}),
        Arguments.of(new String[]{"4", "8", "15", "16", "23", "42"}, new String[]{"42", "8", "16", "15", "23", "4"}),
        Arguments.of(new String[]{"aaa"}, new String[]{"aaa"}),
        Arguments.of(new String[]{}, new String[]{}),
        Arguments.of(new String[]{"a", "b", "c", "xx", "yy", "zz"}, new String[]{"a", "b", "c", "xx", "yy", "zz"})
    );
  }

}
