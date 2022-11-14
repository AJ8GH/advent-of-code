package io.github.aj8gh.aoc.y21.d15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RouteFinderTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day14part1(int[][] input, int expected) {
    var routeFinder = new RouteFinder();
    var actual = routeFinder.findPart1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day14part2(int[][] input, int expected) {
    var routeFinder = new RouteFinder();
    var actual = routeFinder.findPart2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_15).asNestedIntArray(""), 40),
        Arguments.of(reader().getInput(DAY_15).asNestedIntArray(""), 583)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_15).asNestedIntArray(""), 315),
        Arguments.of(reader().getInput(DAY_15).asNestedIntArray(""), 2927)
    );
  }
}
