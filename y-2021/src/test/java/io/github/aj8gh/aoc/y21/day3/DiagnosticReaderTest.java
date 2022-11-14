package io.github.aj8gh.aoc.y21.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiagnosticReaderTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day3Part1(List<String> input, int expected) {
    var reader = new DiagnosticReader();
    var actual = reader.readPart1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day3Part2(List<String> input, int expected) {
    var reader = new DiagnosticReader();
    var actual = reader.readPart2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_3).asStringList(), 198),
        Arguments.of(reader().getInput(DAY_3).asStringList(), 775304)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_3).asStringList(), 230),
        Arguments.of(reader().getInput(DAY_3).asStringList(), 1370737)
    );
  }
}
