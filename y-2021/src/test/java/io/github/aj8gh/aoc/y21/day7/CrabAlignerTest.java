package io.github.aj8gh.aoc.y21.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CrabAlignerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day7part1(List<Integer> input, int expected) {
    var crabAligner = new CrabAligner();
    var actual = crabAligner.getMinDistance(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day7part2(List<Integer> input, int expected) {
    var crabAligner = new CrabAligner();
    var actual = crabAligner.getMinFuelCost(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_7).asIntList(","), 37),
        Arguments.of(reader().getInput(DAY_7).asIntList(","), 343605)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_7).asIntList(","), 168),
        Arguments.of(reader().getInput(DAY_7).asIntList(","), 96744904)
    );
  }
}
