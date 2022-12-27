package io.github.aj8gh.aoc.y22.d9;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Point {
  long row;
  long col;

  public Point(Point point) {
    this.row = point.row;
    this.col = point.col;
  }
}
