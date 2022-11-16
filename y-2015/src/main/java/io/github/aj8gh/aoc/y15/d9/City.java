package io.github.aj8gh.aoc.y15.d9;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class City {
  final Set<Pair<String, Integer>> connections = new HashSet<>();
  final String name;
  boolean visited;
  int distance;

  void addConnection(Pair<String, Integer> connection) {
    connections.add(connection);
  }
}
