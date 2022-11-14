package io.github.aj8gh.aoc.y21.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FolderTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day13Part1(List<String> input, int expected) {
    var folder = new Folder();
    var actual = folder.getNumDots(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day13Part2(List<String> input, String expected) {
    var folder = new Folder();
    var actual = folder.getCode(input);
    assertTrue(actual.contains(expected));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_13).asStringList(), 17),
        Arguments.of(reader().getInput(DAY_13).asStringList(), 675)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getInput(DAY_13).asStringList(),
            "[#, ., ., #, ., #, #, #, #, ., #, ., ., #, ., #, ., ., #, ., #, #, #, #, ., #, #, #, #, ., ., ., #, #, ., #, #, #, #], [#, ., ., #, ., ., ., ., #, ., #, ., #, ., ., #, ., ., #, ., #, ., ., ., ., #, ., ., ., ., ., ., ., #, ., ., ., ., #], [#, #, #, #, ., ., ., #, ., ., #, #, ., ., ., #, #, #, #, ., #, #, #, ., ., #, #, #, ., ., ., ., ., #, ., ., ., #, .], [#, ., ., #, ., ., #, ., ., ., #, ., #, ., ., #, ., ., #, ., #, ., ., ., ., #, ., ., ., ., ., ., ., #, ., ., #, ., .], [#, ., ., #, ., #, ., ., ., ., #, ., #, ., ., #, ., ., #, ., #, ., ., ., ., #, ., ., ., ., #, ., ., #, ., #, ., ., .], [#, ., ., #, ., #, #, #, #, ., #, ., ., #, ., #, ., ., #, ., #, ., ., ., ., #, #, #, #, ., ., #, #, ., ., #, #, #, #]")
    );
  }
}
