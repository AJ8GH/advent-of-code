package io.github.aj8gh.aoc.y22.d9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day9 {

  private static final String L = "L";
  private static final String R = "R";
  private static final String U = "U";
  private static final String D = "D";
  private final HashSet<Point> points = new HashSet<>();

  public int part1(List<String> input) {
    return process(input, 1);
  }

  public int part2(List<String> input) {
    return process(input, 9);
  }

  private int process(List<String> input, int numPoints) {
    var rope = new ArrayList<Point>();
    for (int i = 0; i < numPoints; i++) {
      rope.add(new Point());
    }
    var tail = new Point();
    points.add(tail);
    rope.add(tail);

    for (var line : input) {
      var split = line.split(" ");
      var dir = split[0];
      var dis = Integer.parseInt(split[1]);
      for (int i = 0; i < dis; i++) {
        handle(dir, rope, tail);
      }
    }

    return points.size();
  }

  private void handle(String dir, List<Point> rope, Point tail) {
    switch (dir) {
      case L -> rope.get(0).col--;
      case R -> rope.get(0).col++;
      case U -> rope.get(0).row--;
      case D -> rope.get(0).row++;
      default -> throw new IllegalArgumentException("Unknown Direction + " + dir);
    }
    updatePoints(rope, tail);
  }

  private void updatePoints(List<Point> rope, Point tail) {
    for (int i = 0; i < rope.size() - 1; i++) {
      update(rope.get(i), rope.get(i + 1));
    }
    points.add(new Point(tail));
  }

  private void update(Point head, Point tail) {
    if (Math.abs(head.row - tail.row) == 2) {
      tail.row += updateField(head.row, tail.row);
      if (tail.col != head.col) {
        tail.col += updateField(head.col, tail.col);
      }
    } else if (Math.abs(head.col - tail.col) == 2) {
      tail.col += updateField(head.col, tail.col);
      if (tail.row != head.row) {
        tail.row += updateField(head.row, tail.row);
      }
    }
  }

  private int updateField(long head, long tail) {
    return head > tail ? 1 : -1;
  }
}
