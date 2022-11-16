package io.github.aj8gh.aoc.y15.d9;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RouteFinder {
  private final Map<String, City> cityMap = new HashMap<>();
  private final Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
  private int minDistance;

  public int find(List<List<String>> input) {
    parse(input);
    cityMap.values().forEach(this::explore);
    return minDistance;
  }

  private void explore(City city) {
    city.visited = true;
    queue.addAll(city.connections);
    while (!queue.isEmpty()) {
      explore(city, queue.poll());
    }
  }

  private void explore(City city, Pair<String, Integer> connection) {
    var next = cityMap.get(connection.first);
    if (next.isVisited()) {
      return;
    }
    next.distance = city.distance + connection.second;
    if (cityMap.values().stream().allMatch(City::isVisited)
        && (minDistance == 0 || next.distance < minDistance)) {
      minDistance = next.distance;
      cityMap.values().forEach(c -> {
        c.visited = false;
        c.distance = 0;
      });
    }
    next.connections.forEach(c -> explore(next, c));
  }

  private void parse(List<List<String>> input) {
    for (var line : input) {
      var city1 = cityMap.computeIfAbsent(line.get(0), k -> new City(line.get(0)));
      var city2 = cityMap.computeIfAbsent(line.get(2), k -> new City(line.get(2)));
      city1.addConnection(new Pair<>(city2.name, Integer.parseInt(line.get(4))));
      city2.addConnection(new Pair<>(city1.name, Integer.parseInt(line.get(4))));
    }
  }
}
