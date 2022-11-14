package io.github.aj8gh.aoc.y21.d7;

import java.util.ArrayList;
import java.util.List;

public class CrabAligner {

  public int getMinDistance(List<Integer> crabPositions) {
    List<Integer> distances = new ArrayList<>();
    crabPositions.sort(Integer::compareTo);
    for (int i = 0; i < crabPositions.get(crabPositions.size() - 1); i++) {
      int distance = 0;
      for (Integer crab : crabPositions) {
        distance += Math.abs(i - crab);
      }
      distances.add(distance);
    }
    distances.sort(Integer::compareTo);
    return distances.get(0);
  }

  public int getMinFuelCost(List<Integer> crabPositions) {
    List<Integer> fuelCosts = new ArrayList<>();
    crabPositions.sort(Integer::compareTo);

    for (int i = 0; i < crabPositions.get(crabPositions.size() - 1); i++) {
      int fuelCost = 0;
      for (Integer crab : crabPositions) {
        int distance = Math.abs(i - crab);
        for (int j = 1; j <= distance; j++) {
          fuelCost += j;
        }
      }
      fuelCosts.add(fuelCost);
    }
    fuelCosts.sort(Integer::compareTo);
    return fuelCosts.get(0);
  }
}
