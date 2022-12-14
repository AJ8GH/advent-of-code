package io.github.aj8gh.aoc.y22.d8;

public class Day8 {

  public int part1(int[][] input) {
    var trees = 0;
    for (int i = 1; i < input.length - 1; i++) {
      for (int j = 1; j < input[i].length - 1; j++) {
        trees += scan(input, i, j, true) > 0 ? 1 : 0;
      }
    }
    return trees + input.length * 2 + input[0].length * 2 - 4;
  }

  public int part2(int[][] input) {
    var maxScore = 0;
    for (int i = 1; i < input.length - 1; i++) {
      for (int j = 1; j < input[i].length - 1; j++) {
        maxScore = Math.max(maxScore, scan(input, i, j, false));
      }
    }
    return maxScore;
  }

  private int scan(int[][] grid, int i, int j, boolean part1) {
    var left = scanHorizontal(grid, i, j, -1, part1);
    var right = scanHorizontal(grid, i, j, 1, part1);
    var up = scanVertical(grid, i, j, -1, part1);
    var down = scanVertical(grid, i, j, 1, part1);
    return part1 ? up + down + left + right : up * down * left * right;
  }

  public int scanHorizontal(int[][] grid, int i, int j, int increment, boolean part1) {
    var score = 0;
    for (int k = j + increment; k < grid[i].length && k >= 0; k += increment) {
      score++;
      if (grid[i][k] >= grid[i][j]) {
        return part1 ? 0 : score;
      }
    }
    return score;
  }

  public int scanVertical(int[][] grid, int i, int j, int increment, boolean part1) {
    var score = 0;
    for (int k = i + increment; k < grid.length && k >= 0; k += increment) {
      score++;
      if (grid[k][j] >= grid[i][j]) {
        return part1 ? 0 : score;
      }
    }
    return score;
  }
}
