package io.github.aj8gh.aoc.y21.d12;

import java.util.HashSet;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cave {
  private final Set<String> connections = new HashSet<>();
  private int visits;

  void addConnection(String connection) {
    connections.add(connection);
  }
}
