package io.github.aj8gh.aoc.y21.d9;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
public class Basin {
  private final Set<Point> points = new HashSet<>();

  public boolean add(Point point) {
    return points.add(point);
  }

  public Integer size() {
    return points.size();
  }
}
