package io.github.aj8gh.aoc.y22.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day1Test extends InputProvider {
  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<List<Integer>> input, int expected) {
    var calorieCounter = new Day1();
    var actual = calorieCounter.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<List<Integer>> input, int expected) {
    var calorieCounter = new Day1();
    var actual = calorieCounter.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_1).asLineSeparatedIntList(), 24000),
        Arguments.of(reader().getInput(DAY_1).asLineSeparatedIntList(), 67622)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_1).asLineSeparatedIntList(), 45000),
        Arguments.of(reader().getInput(DAY_1).asLineSeparatedIntList(), 201491)
    );
  }
}
