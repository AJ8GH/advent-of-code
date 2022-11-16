package io.github.aj8gh.aoc.y15.d9;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Pair<T, U> {
  T first;
  U second;
}
