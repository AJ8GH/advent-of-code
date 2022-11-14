package io.github.aj8gh.aoc.y15.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionParserTest extends InputProvider {

  private static final int DAY_1 = 1;

  @ParameterizedTest
  @MethodSource(value = "floorInputProvider")
  void getFloor(String input, int expected) {
    var parser = new DirectionParser();
    assertEquals(expected, parser.getFloor(input));
  }

  @ParameterizedTest
  @MethodSource(value = "positionInputProvider")
  void getNegativePosition(String input, int expected) {
    var parser = new DirectionParser();
    assertEquals(expected, parser.getNegativePosition(input));
  }

  private static Stream<Arguments> floorInputProvider() {
    return Stream.of(
        Arguments.of("(())", 0),
        Arguments.of("()()", 0),
        Arguments.of("(((", 3),
        Arguments.of("(()(()(", 3),
        Arguments.of("))(((((", 3),
        Arguments.of("())", -1),
        Arguments.of("))(", -1),
        Arguments.of(")))", -3),
        Arguments.of(")())())", -3),
        Arguments.of(getInput(), 74)
    );
  }

  private static Stream<Arguments> positionInputProvider() {
    return Stream.of(
        Arguments.of(")", 1),
        Arguments.of("()())", 5),
        Arguments.of(getInput(), 1795)
    );
  }

  private static String getInput() {
    return reader().getInput(DAY_1).asString();
  }
}
