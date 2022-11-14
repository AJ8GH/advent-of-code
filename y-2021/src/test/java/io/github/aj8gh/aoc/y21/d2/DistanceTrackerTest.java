package io.github.aj8gh.aoc.y21.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DistanceTrackerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day2Part1(List<String> input, int expected) {
    var distanceTracker = new DistanceTracker();
    var actual = distanceTracker.getDistanceByDepthPart1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day2Part2(List<String> input, int expected) {
    var distanceTracker = new DistanceTracker();
    var actual = distanceTracker.getDistanceByDepthPart2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_2).asStringList(), 150),
        Arguments.of(reader().getInput(DAY_2).asStringList(), 2102357)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_2).asStringList(), 900),
        Arguments.of(reader().getInput(DAY_2).asStringList(), 2101031224)
    );
  }
}
