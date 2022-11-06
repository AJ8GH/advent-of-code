package io.github.aj8gh.aoc.y15.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.ReaderProvider;
import io.github.aj8gh.aoc.y15.day6.LightSwitcher;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SignalProcessorTest extends ReaderProvider {

  private static final int DAY_7 = 7;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void processPart1(List<String> input, String letter, int expected) {
    var processor = new SignalProcessor();
    var result = processor.process(input);
    assertEquals(expected, result.get(letter));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_7).asStringList(), "d", 72),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "e", 507),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "f", 492),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "g", 114),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "h", 65412),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "i", 65079),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "x", 123),
        Arguments.of(reader().getExample(DAY_7).asStringList(), "y", 456),
        Arguments.of(reader().getInput(DAY_7).asStringList(), "a", 0)
    );
  }
}
