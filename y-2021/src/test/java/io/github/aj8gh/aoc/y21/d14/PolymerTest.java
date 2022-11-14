package io.github.aj8gh.aoc.y21.d14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PolymerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER)
  void day14(List<String> input, int steps, long expected) {
    var polymer = new Polymer(input);
    var actual = polymer.process(steps);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_14).asStringList(), 10, 1588L),
        Arguments.of(reader().getInput(DAY_14).asStringList(), 10, 2435L),
        Arguments.of(reader().getExample(DAY_14).asStringList(), 40, 2188189693529L),
        Arguments.of(reader().getInput(DAY_14).asStringList(), 40, 2587447599164L)
    );
  }
}
