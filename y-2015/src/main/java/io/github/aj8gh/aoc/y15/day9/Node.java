package io.github.aj8gh.aoc.y15.day9;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Data;

@Data
public class Node {
  private final String name;
  private final Set<Map.Entry<Node, Integer>> nodes = new HashSet<>();
  private boolean visited;
  private int distance = Integer.MAX_VALUE;
  private int nodesVisited = 0;

  public void addNode(Node node, int distance) {
    nodes.add(new AbstractMap.SimpleEntry<>(node, distance));
  }
}
