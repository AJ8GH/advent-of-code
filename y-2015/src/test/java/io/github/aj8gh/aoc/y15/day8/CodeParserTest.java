package io.github.aj8gh.aoc.y15.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CodeParserTest extends InputProvider {
  private static final int DAY_8 = 8;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void parsePart1(List<String> input, int expected) {
    var codeParser = new CodeParser();
    assertEquals(expected, codeParser.parsePart1(input));
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void parsePart2(List<String> input, int expected) {
    var codeParser = new CodeParser();
    assertEquals(expected, codeParser.parsePart2(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asStringList(), 12),
        Arguments.of(reader().getInput(DAY_8).asStringList(), 1333)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asStringList(), 19),
        Arguments.of(reader().getInput(DAY_8).asStringList(), 2046)
    );
  }
}
