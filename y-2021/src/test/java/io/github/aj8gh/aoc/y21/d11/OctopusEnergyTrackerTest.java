package io.github.aj8gh.aoc.y21.d11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OctopusEnergyTrackerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day11Part1(List<String> input, int steps, long expected) {
    var octopusEnergyTracker = new OctopusEnergyTracker(input);
    var actual = octopusEnergyTracker.run(steps);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day11Part2(List<String> input, int steps, int expected) {
    var octopusEnergyTracker = new OctopusEnergyTracker(input);
    var actual = octopusEnergyTracker.getFirstSimultaneousFlash(steps);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_11).asStringList(), 100, 1656),
        Arguments.of(reader().getInput(DAY_11).asStringList(), 100, 1732)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_11).asStringList(), 1000, 195),
        Arguments.of(reader().getInput(DAY_11).asStringList(), 1000, 290)
    );
  }
}
