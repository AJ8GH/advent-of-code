package io.github.aj8gh.aoc.y21.d9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RiskLevelAnalyzer {
  public int calculateScore(List<String> input) {
    var heightMap = toHeightMap(input);
    heightMap.findLowPoints();
    return heightMap.getLowPoints().stream()
        .map(Point::getHeight)
        .reduce(heightMap.getLowPoints().size(), Integer::sum);
  }

  public int getLargestBasinsFactor(List<String> input) {
    var heightMap = toHeightMap(input);
    heightMap.findLowPoints();
    heightMap.findBasins();
    List<Basin> basins = heightMap.getBasins();
    basins.sort(Comparator.comparing(Basin::size));
    return basins.subList(basins.size() - 3, basins.size()).stream()
        .map(Basin::size)
        .reduce(1, (s1, s2) -> s1 * s2);
  }

  private HeightMap toHeightMap(List<String> input) {
    return new HeightMap(input.stream()
        .map(line -> Arrays.stream(line.split(""))
            .map(n -> new Point(Integer.parseInt(n)))
            .toList())
        .toList());
  }
}
