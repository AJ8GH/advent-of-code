package io.github.aj8gh.aoc.y22.d3;

import static java.lang.Character.toLowerCase;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
  private static final int LOWER_OFFSET = 96;
  private static final int UPPER_OFFSET = 38;

  public int part1(List<String> input) {
    return input.stream()
        .map(s -> List.of(s.substring(0, s.length() / 2), s.substring(s.length() / 2)))
        .map(this::toPriority)
        .reduce(0, Integer::sum);
  }

  public int part2(List<String> input) {
    return Lists.partition(input, 3).stream()
        .map(this::toPriority)
        .reduce(0, Integer::sum);
  }

  private int toPriority(List<String> lines) {
    var c = new ArrayList<>(Chars.asList(lines.get(0).toCharArray()));
    lines.forEach(l -> c.retainAll(Chars.asList(l.toCharArray())));
    return c.get(0) - (c.get(0) == (toLowerCase(c.get(0))) ? LOWER_OFFSET : UPPER_OFFSET);
  }
}
