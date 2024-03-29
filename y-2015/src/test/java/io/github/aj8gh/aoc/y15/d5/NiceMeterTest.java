package io.github.aj8gh.aoc.y15.d5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NiceMeterTest extends InputProvider {

  private static final int DAY_5 = 5;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void analyse(List<String> input, long expected) {
    var niceOMeter = new NiceMeter();
    assertEquals(expected, niceOMeter.analysePart1(input));
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void analysePart2(List<String> input, long expected) {
    var niceOMeter = new NiceMeter();
    assertEquals(expected, niceOMeter.analysePart2(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_5).asStringList(), 2L),
        Arguments.of(reader().getInput(DAY_5).asStringList(), 236L)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample2(DAY_5).asStringList(), 2L),
        Arguments.of(reader().getInput(DAY_5).asStringList(), 51)
    );
  }
}
