package io.github.aj8gh.aoc.y21.d12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class CaveMapperTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day12Part1(String[][] input, int expected) {
    var caveMapper = new CaveMapper();
    var actual = caveMapper.map(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_12).asNestedStringArray("-"), 10),
        Arguments.of(reader().getExample2(DAY_12).asNestedStringArray("-"), 19),
        Arguments.of(reader().getExample3(DAY_12).asNestedStringArray("-"), 226),
        Arguments.of(reader().getInput(DAY_12).asNestedStringArray("-"), 3761)
    );
  }
}
