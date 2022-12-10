package io.github.aj8gh.aoc.y22.d6;

import java.util.ArrayDeque;

public class Day6 {

  private static final int UNIQUE_CHARS_PART_1 = 4;
  private static final int UNIQUE_CHARS_PART_2 = 14;

  public int part1(String input) {
    return process(input, UNIQUE_CHARS_PART_1);
  }

  public int part2(String input) {
    return process(input, UNIQUE_CHARS_PART_2);
  }

  private int process(String input, int uniqueChars) {
    var queue = new ArrayDeque<Character>();
    for (int i = 0; i < input.length(); i++) {
      var current = input.charAt(i);
      if (queue.contains(current)) {
        int removed = queue.removeFirst();
        while (removed != current) {
          removed = queue.removeFirst();
        }
      } else if (queue.size() == uniqueChars - 1) {
        return i + 1;
      }
      queue.add(current);
    }
    return -1;
  }
}
