package io.github.aj8gh.aoc.y21.day15;

import java.util.PriorityQueue;
import java.util.Queue;

public class RouteFinder {
  private static final InputExtender INPUT_EXTENDER = new InputExtender();
  private final Queue<Node> queue = new PriorityQueue<>();
  private Node[][] nodes;

  public int findPart1(int[][] input) {
    this.nodes = buildGrid(input);

    nodes[0][0].total = 0;
    queue.add(nodes[0][0]);

    while (!queue.isEmpty()) {
      var node = queue.poll();
      explore(node, 0, -1);
      explore(node, -1, 0);
      explore(node, 1, 0);
      explore(node, 0, 1);
    }
    return nodes[nodes.length - 1][nodes[0].length - 1].total;
  }

  public int findPart2(int[][] input) {
    return findPart1(INPUT_EXTENDER.extend(input));
  }

  private void explore(Node prevNode, int difI, int difJ) {
    var newI = prevNode.pointI + difI;
    var newJ = prevNode.pointJ + difJ;
    if (newI >= 0 && newJ >= 0 && newI < nodes.length && newJ < nodes[0].length) {
      var newNode = nodes[newI][newJ];
      if (newNode.total == Integer.MAX_VALUE) {
        newNode.total = Math.min(newNode.total, prevNode.total + newNode.risk);
        queue.add(newNode);
      }
    }
  }

  private Node[][] buildGrid(int[][] input) {
    var output = new Node[input.length][input[0].length];
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        output[i][j] = new Node(input[i][j], i, j);
      }
    }
    return output;
  }
}
