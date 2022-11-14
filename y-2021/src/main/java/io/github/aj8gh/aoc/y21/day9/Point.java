package io.github.aj8gh.aoc.y21.day9;

import lombok.Data;

@Data
public class Point {
  private final int height;
  private int pointX;
  private int pointY;

  public Point setPointX(int pointX) {
    this.pointX = pointX;
    return this;
  }

  public Point setPointY(int pointY) {
    this.pointY = pointY;
    return this;
  }
}
