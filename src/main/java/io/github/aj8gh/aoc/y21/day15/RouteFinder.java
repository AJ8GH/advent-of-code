package io.github.aj8gh.aoc.y21.day15;

import java.util.PriorityQueue;
import java.util.Queue;

public class RouteFinder {

  private final Node[][] nodes;
  private final Queue<Node> queue = new PriorityQueue<>();

  public RouteFinder(int[][] grid) {
    this.nodes = new Node[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        nodes[i][j] = new Node(grid[i][j], i, j);
      }
    }
  }

  public int find() {
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

  private void explore(Node prevNode, int iDiff, int jDiff) {
    var newI = prevNode.i + iDiff;
    var newJ = prevNode.j + jDiff;
    if (newI >= 0 && newJ >= 0 && newI < nodes.length && newJ < nodes[0].length) {
      var newNode = nodes[newI][newJ];
      if (newNode.total == Integer.MAX_VALUE) {
        newNode.total = Math.min(newNode.total, prevNode.total + newNode.risk);
        queue.add(newNode);
      }
    }
  }
}
