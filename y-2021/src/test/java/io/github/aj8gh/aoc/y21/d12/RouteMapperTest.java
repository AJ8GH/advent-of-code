package io.github.aj8gh.aoc.y21.d12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RouteMapperTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day12Part1(List<String> input, int expected) {
    var routeMapper = new RouteMapper();
    var actual = routeMapper.findRoutesPart1(input);
    assertEquals(expected, actual);
  }

  @Disabled("Optimize this")
  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day12Part2(List<String> input, int expected) {
    var routeMapper = new RouteMapper();
    var actual = routeMapper.findRoutesPart2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_12).asStringList(), 10),
        Arguments.of(reader().getExample2(DAY_12).asStringList(), 19),
        Arguments.of(reader().getExample3(DAY_12).asStringList(), 226),
        Arguments.of(reader().getInput(DAY_12).asStringList(), 3761)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_12).asStringList(), 36),
        Arguments.of(reader().getExample2(DAY_12).asStringList(), 103),
        Arguments.of(reader().getExample3(DAY_12).asStringList(), 3509),
        Arguments.of(reader().getInput(DAY_12).asStringList(), 99138)
    );
  }
}
