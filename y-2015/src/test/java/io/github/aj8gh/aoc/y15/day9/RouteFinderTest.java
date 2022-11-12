package io.github.aj8gh.aoc.y15.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.ReaderProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RouteFinderTest extends ReaderProvider {
  private static final int DAY_9 = 9;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void findPart1(List<String> input, int expected) {
    var routeFinder = new RouteFinder();
    assertEquals(expected, routeFinder.find(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asStringList(), 605),
        Arguments.of(reader().getInput(DAY_9).asStringList(), 0)
    );
  }
}
