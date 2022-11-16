package io.github.aj8gh.aoc.y15.d9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class RouteFinderTest extends InputProvider {
  private static final int DAY_9 = 9;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void findPart1(List<List<String>> input, int expected) {
    var routeFinder = new RouteFinder();
    assertEquals(expected, routeFinder.find(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asNestedStringList(" "), 605),
        Arguments.of(reader().getInput(DAY_9).asNestedStringList(" "), 0)
    );
  }
}
