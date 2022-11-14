package io.github.aj8gh.aoc.y21.d12;

import java.util.HashMap;
import java.util.Map;

public class CaveMapper {
  private static final String START = "start";
  private static final String END = "end";
  private final Map<String, Cave> caveMap = new HashMap<>();
  private int routes;

  public int map(String[][] input) {
    parseCaves(input);
    explore(START);
    return routes;
  }

  private void explore(String cave) {
    if (cave.equals(END)) {
      routes++;
    }
  }

  private void parseCaves(String[][] input) {
    for (var line : input) {
      var cave1 = caveMap.computeIfAbsent(line[0], k -> new Cave());
      cave1.addConnection(line[1]);
      var cave2 = caveMap.computeIfAbsent(line[1], k -> new Cave());
      cave2.addConnection(line[0]);
    }
  }
}

/*

CaveA set<String> connections
int visits;

start [A, b]

[

for cave in connections

*/
