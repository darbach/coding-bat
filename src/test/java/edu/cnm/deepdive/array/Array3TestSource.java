package edu.cnm.deepdive.array;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class Array3TestSource {

  static Stream<Arguments> maxSpan() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 1, 1, 3}, 4),
        Arguments.of(new int[]{1, 4, 2, 1, 4, 1, 4}, 6),
        Arguments.of(new int[]{1, 4, 2, 1, 4, 4, 4}, 6),
        Arguments.of(new int[]{3, 3, 3}, 3),
        Arguments.of(new int[]{3, 9, 3}, 3),
        Arguments.of(new int[]{3, 9, 9}, 2),
        Arguments.of(new int[]{3, 9}, 1),
        Arguments.of(new int[]{3, 3}, 2),
        Arguments.of(new int[]{}, 0),
        Arguments.of(new int[]{1}, 1)
    );
  }

  static Stream<Arguments> fix34() {
    //^.*fix34\(\[(.*)\].*\[(.*)\]\s*\[.*$
    //Arguments.of(new int[]{$1}, new int[]{$2}),
    return Stream.of(
        Arguments.of(new int[]{1, 3, 1, 4}, new int[]{1, 3, 4, 1}),
        Arguments.of(new int[]{1, 3, 1, 4, 4, 3, 1}, new int[]{1, 3, 4, 1, 1, 3, 4}),
        Arguments.of(new int[]{3, 2, 2, 4}, new int[]{3, 4, 2, 2}),
        Arguments.of(new int[]{3, 2, 3, 2, 4, 4}, new int[]{3, 4, 3, 4, 2, 2}),
        Arguments.of(new int[]{2, 3, 2, 3, 2, 4, 4}, new int[]{2, 3, 4, 3, 4, 2, 2}),
        Arguments.of(new int[]{5, 3, 5, 4, 5, 4, 5, 4, 3, 5, 3, 5}, new int[]{5, 3, 4, 5, 5, 5, 5, 5, 3, 4, 3, 4}),
        Arguments.of(new int[]{3, 1, 4}, new int[]{3, 4, 1}),
        Arguments.of(new int[]{3, 4, 1}, new int[]{3, 4, 1}),
        Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
        Arguments.of(new int[]{1}, new int[]{1}),
        Arguments.of(new int[]{}, new int[]{}),
        Arguments.of(new int[]{7, 3, 7, 7, 4}, new int[]{7, 3, 4, 7, 7}),
        Arguments.of(new int[]{3, 1, 4, 3, 1, 4}, new int[]{3, 4, 1, 3, 4, 1}),
        Arguments.of(new int[]{3, 1, 1, 3, 4, 4}, new int[]{3, 4, 1, 3, 4, 1})
    );
  }

  static Stream<Arguments> fix45() {
    //^.*fix45\(\[(.*)\].*\[(.*)\]\s*\[.*$
    //Arguments.of(new int[]{$1}, new int[]{$2}),
    return Stream.of(
        Arguments.of(new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}),
        Arguments.of(new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}),
        Arguments.of(new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}),
        Arguments.of(new int[]{4, 9, 4, 9, 5, 5, 4, 9, 5}, new int[]{4, 5, 4, 5, 9, 9, 4, 5, 9}),
        Arguments.of(new int[]{5, 5, 4, 1, 4, 1}, new int[]{1, 1, 4, 5, 4, 5}),
        Arguments.of(new int[]{4, 2, 2, 5}, new int[]{4, 5, 2, 2}),
        Arguments.of(new int[]{4, 2, 4, 2, 5, 5}, new int[]{4, 5, 4, 5, 2, 2}),
        Arguments.of(new int[]{4, 2, 4, 5, 5}, new int[]{4, 5, 4, 5, 2}),
        Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
        Arguments.of(new int[]{4, 5}, new int[]{4, 5}),
        Arguments.of(new int[]{5, 4, 1}, new int[]{1, 4, 5}),
        Arguments.of(new int[]{}, new int[]{}),
        Arguments.of(new int[]{5, 4, 5, 4, 1}, new int[]{1, 4, 5, 4, 5}),
        Arguments.of(new int[]{4, 5, 4, 1, 5}, new int[]{4, 5, 4, 5, 1}),
        Arguments.of(new int[]{3, 4, 5}, new int[]{3, 4, 5}),
        Arguments.of(new int[]{4, 1, 5}, new int[]{4, 5, 1}),
        Arguments.of(new int[]{5, 4, 1}, new int[]{1, 4, 5}),
        Arguments.of(new int[]{2, 4, 2, 5}, new int[]{2, 4, 5, 2})
    );
  }

  static Stream<Arguments> canBalance() {
    return Stream.of(
        Arguments.of(new int[]{1, 1, 1, 2, 1}, true),
        Arguments.of(new int[]{2, 1, 1, 2, 1}, false),
        Arguments.of(new int[]{10, 10}, true),
        Arguments.of(new int[]{10, 0, 1, -1, 10}, true),
        Arguments.of(new int[]{10, -1, 1, 0, 10}, true),
        Arguments.of(new int[]{1, 1, 1, 1, 4}, true),
        Arguments.of(new int[]{2, 1, 1, 1, 4}, false),
        Arguments.of(new int[]{2, 3, 4, 1, 2}, false),
        Arguments.of(new int[]{1, 2, 3, 1, 0, 2, 3}, true),
        Arguments.of(new int[]{1, 2, 3, 1, 0, 1, 3}, false),
        Arguments.of(new int[]{1}, false),
        Arguments.of(new int[]{1, 1, 1, 2, 1}, true)
    );
  }

}
