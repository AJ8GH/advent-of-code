package io.github.aj8gh.aoc.y21.day1;

import java.util.ArrayList;
import java.util.List;

public class DepthScanAnalyser {

  public int getNumberOfDepthIncreases(List<Integer> input) {
    int numberOfDepthIncreases = 0;
    for (int i = 0; i < input.size(); i++) {
      if (i > 0 && input.get(i) > input.get(i - 1)) {
        numberOfDepthIncreases++;
      }
    }
    return numberOfDepthIncreases;
  }

  public int getThreeDepthWindowIncreases(List<Integer> input) {
    var threeDepthWindows = new ArrayList<Integer>();
    for (int i = 0; i < input.size() - 2; i++) {
      int sum = input.get(i) + input.get(i + 1) + input.get(i + 2);
      threeDepthWindows.add(sum);
    }
    return getNumberOfDepthIncreases(threeDepthWindows);
  }
}
