package io.github.aj8gh.aoc.y22.d12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day12Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(char[][] input, int expected) {
    var day12 = new Day12();
    var actual = day12.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(char[][] input, int expected) {
    var day12 = new Day12();
    var actual = day12.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInput(31, 534);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(29, 525);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_12).asNestedCharArray(), example),
        Arguments.of(reader().getInput(DAY_12).asNestedCharArray(), result)
    );
  }
}
