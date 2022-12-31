package io.github.aj8gh.aoc.y22.d12;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node {
  final char val;
  int row;
  int col;
  int total;
}
