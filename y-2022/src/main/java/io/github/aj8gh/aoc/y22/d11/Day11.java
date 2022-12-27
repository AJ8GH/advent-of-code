package io.github.aj8gh.aoc.y22.d11;

import static io.github.aj8gh.aoc.y22.d11.Parser.parse;

import java.util.Comparator;
import java.util.List;

public class Day11 {

  public long part1(List<String> input) {
    return process(input, 20, 3);
  }

  public long part2(List<String> input) {
    return process(input, 10_000, 1);
  }

  private long process(List<String> input, int rounds, int divisor) {
    var monkeys = parse(input);
    for (int i = 0; i < rounds; i++) {
      monkeys.forEach(m -> {
        var items = m.getItems();
        while (!items.isEmpty()) {
          var result = m.test(items.poll(), divisor);
          monkeys.get(result[0].intValue()).add(result[1]);
        }
      });
    }
    return calculate(monkeys);
  }

  private long calculate(List<Monkey> monkeys) {
    return monkeys.stream()
        .map(Monkey::getOperations)
        .sorted(Comparator.reverseOrder()).limit(2)
        .reduce(1L, (a, b) -> a * b);
  }
}
