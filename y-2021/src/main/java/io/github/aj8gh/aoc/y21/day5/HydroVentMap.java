package io.github.aj8gh.aoc.y21.day5;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class HydroVentMap {
  private final List<List<Integer>> coordinates;
  private final List<List<Integer>> collisionMap;

  public HydroVentMap(List<String> input) {
    this.coordinates = buildCoordinates(input);
    this.collisionMap = createCollisionMap();
  }

  public long countPart1() {
    populateCollisionMap();
    return countCollisions();
  }

  public long countPart2() {
    populateCollisionMap();
    populateDiagonals();
    return countCollisions();
  }

  private void populateCollisionMap() {
    for (List<Integer> coords : coordinates) {
      int x1 = Math.min(coords.get(0), coords.get(2));
      int x2 = Math.max(coords.get(0), coords.get(2));
      int y1 = Math.min(coords.get(1), coords.get(3));
      int y2 = Math.max(coords.get(1), coords.get(3));

      if (y1 == y2) {
        List<Integer> row = collisionMap.get(y1);
        for (int x = x1; x <= x2; x++) {
          row.set(x, row.get(x) + 1);
        }
      } else if (x1 == x2) {
        for (int y = y1; y <= y2; y++) {
          List<Integer> row = collisionMap.get(y);
          row.set(x1, row.get(x1) + 1);
        }
      }
    }
  }

  public void populateDiagonals() {
    for (List<Integer> coords : coordinates) {
      int x1 = coords.get(0);
      int x2 = coords.get(2);
      int y1 = coords.get(1);
      int y2 = coords.get(3);

      if (x1 == x2 || y1 == y2) {
        continue;
      }
      while (true) {
        List<Integer> row = collisionMap.get(y1);
        row.set(x1, row.get(x1) + 1);
        if (y1 == y2) {
          break;
        }
        y1 += y1 < y2 ? 1 : -1;
        x1 += x1 < x2 ? 1 : -1;
      }
    }
  }

  private List<List<Integer>> createCollisionMap() {
    int maxX = getMax(0);
    int maxY = getMax(1);

    List<List<Integer>> output   = new ArrayList<>(maxY + 1);
    for (int i = 0; i < maxX + 1; i++) {
      List<Integer> row = new ArrayList<>(maxX + 1);
      for (int j = 0; j < maxX + 1; j++) {
        row.add(0);
      }
      output.add(row);
    }
    return output;
  }

  private int getMax(int index) {
    int max = 0;
    for (List<Integer> coords : coordinates) {
      for (int i = index; i < index + 3; i += 2) {
        if (coords.get(i) > max) {
          max = coords.get(i);
        }
      }
    }
    log.info("Maximum Coordinate: {}", max);
    return max;
  }

  private List<List<Integer>> buildCoordinates(List<String> input) {
    var output = new ArrayList<List<Integer>>();

    for (var line : input) {
      List<Integer> coordGroup = new ArrayList<>();
      String[] halves = line.split(" -> ");
      coordGroup.add(Integer.valueOf(halves[0].split(",")[0]));
      coordGroup.add(Integer.valueOf(halves[0].split(",")[1]));
      coordGroup.add(Integer.valueOf(halves[1].split(",")[0]));
      coordGroup.add(Integer.valueOf(halves[1].split(",")[1]));
      output.add(coordGroup);
    }
    return output;
  }

  private long countCollisions() {
    long count = 0;
    for (List<Integer> row : collisionMap) {
      count += row
          .stream()
          .filter(n -> n > 1)
          .count();
    }
    return count;
  }
}
