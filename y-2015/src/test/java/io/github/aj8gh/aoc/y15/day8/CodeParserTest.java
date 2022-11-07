package io.github.aj8gh.aoc.y15.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.ReaderProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodeParserTest extends ReaderProvider {
  private static final int DAY_8 = 8;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void parsePart1(List<String> input, int expected) {
    var codeParser = new CodeParser();
    assertEquals(expected, codeParser.parse(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asStringList(), 12),
        Arguments.of(reader().getInput(DAY_8).asStringList(), 0)
    );
  }
}
