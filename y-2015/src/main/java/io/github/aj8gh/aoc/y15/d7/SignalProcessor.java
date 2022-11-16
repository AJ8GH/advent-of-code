package io.github.aj8gh.aoc.y15.d7;

import static java.lang.Integer.parseInt;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.regex.Pattern;

public class SignalProcessor {
  private static final int MAX_UNSIGNED_16_BIT_INT = (Short.MAX_VALUE + 1) * 2;
  private static final Pattern IS_NUMBER = Pattern.compile("^\\d+$");
  private final Map<String, Integer> results = new HashMap<>();
  private final Queue<String[]> queue = new ArrayDeque<>();

  public Map<String, Integer> process(List<String> instructions) {
    instructions.stream()
        .map(row -> row.split(" -> "))
        .forEach(row -> handleResult(toNumber(row[0]), row));
    while (!queue.isEmpty()) {
      var row = queue.poll();
      handleResult(handle(row), row);
    }
    return results;
  }

  public Map<String, Integer> processPart2(List<String> instructions) {
    process(instructions);
    instructions.add(results.get("a") + " -> b");
    results.clear();
    return process(instructions);
  }

  private Optional<Integer> handle(String[] split) {
    var source = split[0].split(" ");
    if (source.length == 1) {
      return toNumber(source[0]);
    } else if (source.length == 2 && results.containsKey(source[1])) {
      return of(~results.get(source[1]) + MAX_UNSIGNED_16_BIT_INT);
    } else if (source.length == 3) {
      return toNumber(source[0]).flatMap(a -> toNumber(source[2])
          .map(b -> apply(a, source[1], b)));
    }
    return Optional.empty();
  }

  private void handleResult(Optional<Integer> result, String[] row) {
    result.ifPresentOrElse(r -> results.put(row[1], r), () -> queue.add(row));
  }

  private int apply(int a, String operator, int b) {
    return switch (operator) {
      case "AND" -> a & b;
      case "OR" -> a | b;
      case "LSHIFT" -> a << b;
      case "RSHIFT" -> a >> b;
      default -> throw new IllegalArgumentException("Unknown operator " + operator);
    };
  }

  private Optional<Integer> toNumber(String s) {
    return IS_NUMBER.matcher(s).find() ? of(parseInt(s)) : ofNullable(results.get(s));
  }
}
