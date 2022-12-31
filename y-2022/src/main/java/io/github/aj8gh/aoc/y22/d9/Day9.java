package io.github.aj8gh.aoc.y22.d9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day9 {
  private final HashSet<List<Integer>> visited = new HashSet<>();
  private final Node head = new Node();
  private Node tail;

  public int part1(List<String> input) {
    return process(input, 1);
  }

  public int part2(List<String> input) {
    return process(input, 9);
  }

  private int process(List<String> input, int numNodes) {
    var node = new Node();
    node.head = head;
    var nodes = new ArrayList<>(List.of(node));
    for (int i = 0; i < numNodes - 1; i++) {
      node = new Node();
      node.head = nodes.get(i);
      nodes.add(node);
    }
    tail = nodes.get(nodes.size() - 1);

    for (var line : input) {
      var split = line.split(" ");
      var dir = split[0];
      var dis = Integer.parseInt(split[1]);
      for (int i = 0; i < dis; i++) {
        handle(dir, nodes);
      }
    }
    return this.visited.size();
  }

  private void handle(String dir, List<Node> nodes) {
    head.step(dir);
    nodes.forEach(Node::follow);
    visited.add(List.of(tail.col, tail.row));
  }
}
