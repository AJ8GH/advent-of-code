package io.github.aj8gh.aoc.y21.d5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HydroVentMapTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day5Part1(List<String> input, long expected) {
    var map = new HydroVentMap(input);
    var actual = map.countPart1();
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day5Part2(List<String> input, long expected) {
    var map = new HydroVentMap(input);
    var actual = map.countPart2();
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_5).asStringList(), 5),
        Arguments.of(reader().getInput(DAY_5).asStringList(), 5690)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_5).asStringList(), 12),
        Arguments.of(reader().getInput(DAY_5).asStringList(), 17741)
    );
  }
}
