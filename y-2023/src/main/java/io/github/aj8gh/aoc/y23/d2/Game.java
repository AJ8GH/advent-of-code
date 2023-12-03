package io.github.aj8gh.aoc.y23.d2;

import lombok.Builder;

@Builder
public record Game(
    int id,
    int maxRed,
    int maxGreen,
    int maxBlue) {

  public int power() {
    return maxRed * maxGreen * maxBlue;
  }
}
