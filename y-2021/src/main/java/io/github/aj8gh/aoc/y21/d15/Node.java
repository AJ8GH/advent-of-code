package io.github.aj8gh.aoc.y21.d15;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Node implements Comparable<Node> {

  final int risk;
  final int pointI;
  final int pointJ;
  int total;

  public Node(int risk, int pointI, int pointJ) {
    this.risk = risk;
    this.pointI = pointI;
    this.pointJ = pointJ;
    this.total = Integer.MAX_VALUE;
  }

  @Override
  public int compareTo(Node node) {
    return Integer.compare(total, node.total);
  }
}
