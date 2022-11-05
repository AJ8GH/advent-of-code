package io.github.aj8gh.aoc.y15.day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeliveryTracker {

  private final Map<Integer, Set<Integer>> visited = new HashMap<>(Map.of(
      0, new HashSet<>(Set.of(0))
  ));

  private final Map<Character, int[]> decoder = Map.of(
      '<', new int[] {0, -1},
      '>', new int[] {0, 1},
      '^', new int[] {-1, 0},
      'v', new int[] {1, 0}
  );

  public int track(String directions) {
    int houses = 1;
    var santa = new int[] {0, 0};


    for (int i = 0; i < directions.length(); i++) {
      var move = decoder.get(directions.charAt(i));
      santa[0] += move[0];
      santa[1] += move[1];

      if (notVisited(santa)) {
        houses++;
      }
    }
    return houses;
  }

  public int trackRobo(String directions) {
    int houses = 1;
    var santa = new int[] {0, 0};
    var robo = new int[] {0, 0};

    for (int i = 0; i < directions.length(); i++) {
      var move = decoder.get(directions.charAt(i));
      var position = i % 2 == 0 ? santa : robo;
      position[0] += move[0];
      position[1] += move[1];

      if (notVisited(position)) {
        houses++;
      }
    }
    return houses;
  }

  private boolean notVisited(int[] position) {
    var visitedPositions = visited.computeIfAbsent(position[0], x -> new HashSet<>());
    return (visitedPositions.add(position[1]));
  }
}
