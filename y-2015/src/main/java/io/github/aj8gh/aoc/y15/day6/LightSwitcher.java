package io.github.aj8gh.aoc.y15.day6;

import static java.lang.Integer.parseInt;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class LightSwitcher {
  private final Pattern pattern = Pattern.compile("toggle|on|off|\\d+");
  private final int[][] lights = new int[1000][1000];

  public int processPart1(List<String> instructions) {
    return process(instructions, this::convertPart1);
  }

  public int processPart2(List<String> instructions) {
    return process(instructions, this::convertPart2);
  }

  private int process(List<String> instructions, BiFunction<String, Integer, Integer> converter) {
    extract(instructions).forEach(row -> update(row, converter));
    return Arrays.stream(lights)
        .map(row -> Arrays.stream(row).reduce(0, Integer::sum))
        .reduce(0, Integer::sum);
  }

  private List<List<String>> extract(List<String> instructions) {
    return instructions.stream()
        .map(line -> pattern.matcher(line)
            .results()
            .map(MatchResult::group)
            .toList())
        .toList();
  }

  private void update(List<String> row, BiFunction<String, Integer, Integer> converter) {
    for (int i = parseInt(row.get(1)); i <= parseInt(row.get(3)); i++) {
      for (int j = parseInt(row.get(2)); j <= parseInt(row.get(4)); j++) {
        lights[i][j] = converter.apply(row.get(0), lights[i][j]);
      }
    }
  }

  private int convertPart1(String element, int val) {
    return switch (element) {
      case "on" -> 1;
      case "off" -> 0;
      default -> val == 1 ? 0 : 1;
    };
  }

  private int convertPart2(String element, int val) {
    return switch (element) {
      case "on" -> val + 1;
      case "off" -> Math.max(0, val - 1);
      default -> val + 2;
    };
  }
}
