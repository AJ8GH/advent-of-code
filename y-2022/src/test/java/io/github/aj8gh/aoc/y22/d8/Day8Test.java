package io.github.aj8gh.aoc.y22.d8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day8Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(int[][] input, int expected) {
    var day8 = new Day8();
    var actual = day8.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(int[][] input, int expected) {
    var day8 = new Day8();
    var actual = day8.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asNestedIntArray(), 21),
        Arguments.of(reader().getInput(DAY_8).asNestedIntArray(), 1690)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asNestedIntArray(), 8),
        Arguments.of(reader().getInput(DAY_8).asNestedIntArray(), 535680)
    );
  }
}
