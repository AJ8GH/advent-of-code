package io.github.aj8gh.aoc.y21.d6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FishSimulatorTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER)
  void day6(List<Integer> input, int days, long expected) {
    var fishSimulator = new FishSimulator(input);
    var actual = fishSimulator.simulate(days);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProvider() {
    var input = reader().getInput(DAY_6).asIntList(",");
    var example = reader().getExample(DAY_6).asIntList(",");

    return Stream.of(
        Arguments.of(example, 80, 5934L),
        Arguments.of(input, 80, 353079L),
        Arguments.of(example, 256, 26984457539L),
        Arguments.of(input, 256, 1605400130036L)
    );
  }
}
