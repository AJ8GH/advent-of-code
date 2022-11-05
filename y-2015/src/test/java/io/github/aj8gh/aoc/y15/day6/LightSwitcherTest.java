package io.github.aj8gh.aoc.y15.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.ReaderProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LightSwitcherTest extends ReaderProvider {

  private static final int DAY_6 = 6;

  @ParameterizedTest
  @MethodSource(value = "inputProvider")
  void analyse(List<String> input, long expected) {
    var lightSwitcher = new LightSwitcher();
    assertEquals(expected, lightSwitcher.process(input));
  }

  private static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_6).asStringList(), 998_995),
        Arguments.of(reader().getInput(DAY_6).asStringList(), 0)
    );
  }
}
