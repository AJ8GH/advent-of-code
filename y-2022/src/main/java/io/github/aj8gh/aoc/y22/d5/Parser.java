package io.github.aj8gh.aoc.y22.d5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Parser {
  private static final Pattern NUMBER_ROW_PATTERN = Pattern.compile("^(\\s+|\\d+)(.*)(\\s+|\\d+)$");
  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
  private static final int COL_WIDTH = 4;

  public List<ArrayDeque<Character>> buildStacks(List<String> input) {
    int numCols = input.stream()
        .filter(line -> NUMBER_ROW_PATTERN.matcher(line).find())
        .map(line -> toIntList(line).size())
        .findFirst().orElse(-1);

    var lines = input.stream().filter(line -> line.contains("[")).toList();

    var stacks = new ArrayList<ArrayDeque<Character>>();
    for (int i = 0; i < numCols; i++) {
      var stack = new ArrayDeque<Character>();
      for (var line : lines) {
        var j = 1 + i * COL_WIDTH;
        if (j >= line.length()) {
          continue;
        }
        var c = line.charAt(1 + i * COL_WIDTH);
        if (c != ' ') {
          stack.add(c);
        }
      }
      stacks.add(stack);
    }
    return stacks;
  }

  public List<List<Integer>> getInstructions(List<String> input) {
    return input.stream().filter(line -> line.startsWith("move"))
        .map(this::toIntList)
        .toList();
  }

  private List<Integer> toIntList(String s) {
    return NUMBER_PATTERN.matcher(s)
        .results()
        .map(MatchResult::group)
        .map(Integer::valueOf)
        .toList();
  }
}
