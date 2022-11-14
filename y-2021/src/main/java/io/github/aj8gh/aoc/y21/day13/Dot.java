package io.github.aj8gh.aoc.y21.day13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dot {
  private int pointX;
  private int pointY;

  @Override
  public String toString() {
    return "#";
  }
}
