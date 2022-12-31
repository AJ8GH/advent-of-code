package io.github.aj8gh.aoc.y22.d9;

import static java.lang.Math.abs;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Node {
  private static final String L = "L";
  private static final String R = "R";
  private static final String U = "U";
  private static final String D = "D";

  Node head;
  int row;
  int col;

  void step(String dir) {
    switch (dir) {
      case L -> col--;
      case R -> col++;
      case U -> row++;
      case D -> row--;
      default -> throw new IllegalArgumentException(dir);
    }
  }

  void follow() {
    int rowDiff = head.row - row;
    int colDiff = head.col - col;
    if (abs(rowDiff) == 2 && colDiff == 0) {
      row += rowDiff > 0 ? 1 : -1;
    } else if (abs(colDiff) == 2 && rowDiff == 0) {
      col += colDiff > 0 ? 1 : -1;
    } else if (abs(rowDiff) + abs(colDiff) > 2) {
      row += rowDiff > 0 ? 1 : -1;
      col += colDiff > 0 ? 1 : -1;
    }
  }
}
