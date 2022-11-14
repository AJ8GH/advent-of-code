package io.github.aj8gh.aoc.y21.day11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OctopusEnergyTracker {
  private final List<List<DumboOctopus>> octopusGrid;
  private final int rows;
  private final int columns;
  private long flashes;

  public OctopusEnergyTracker(List<String> input) {
    this.octopusGrid = toOctopusGrid(input);
    this.rows = octopusGrid.size();
    this.columns = octopusGrid.get(0).size();
  }

  public long run(int steps) {
    for (int i = 0; i < steps; i++) {
      tickAll();
    }
    return flashes;
  }

  public int getFirstSimultaneousFlash(int steps) {
    for (int i = 0; i < steps; i++) {
      tickAll();
      if (isSimultaneousFlash()) {
        return i + 1;
      }
    }
    return -1;
  }

  private void tickAll() {
    for (int y = 0; y < rows; y++) {
      for (int x = 0; x < columns; x++) {
        tick(get(x, y));
      }
    }
    reset();
  }

  private boolean isSimultaneousFlash() {
    for (List<DumboOctopus> row : octopusGrid) {
      for (DumboOctopus octopus : row) {
        if (octopus.getEnergy() != 0) {
          return false;
        }
      }
    }
    return true;
  }

  private void tick(DumboOctopus octopus) {
    if (octopus.tick()) {
      flashes++;
      getNeighbours(octopus).forEach(this::tick);
    }
  }

  private Set<DumboOctopus> getNeighbours(DumboOctopus octopus) {
    int x = octopus.getPointX();
    int y = octopus.getPointY();
    Set<DumboOctopus> neighbours = new HashSet<>();

    if (x > 0) {
      neighbours.add(get(x - 1, y));
    }
    if (x < columns - 1) {
      neighbours.add(get(x + 1, y));
    }
    if (y > 0) {
      neighbours.add(get(x, y - 1));
    }
    if (y < rows - 1) {
      neighbours.add(get(x, y + 1));
    }
    if (x > 0 && y > 0) {
      neighbours.add(get(x - 1, y - 1));
    }
    if (x < columns - 1 && y < rows - 1) {
      neighbours.add(get(x + 1, y + 1));
    }
    if (x > 0 && y < rows - 1) {
      neighbours.add(get(x - 1, y + 1));
    }
    if (x < columns - 1 && y > 0) {
      neighbours.add(get(x + 1, y - 1));
    }
    return neighbours;
  }

  private DumboOctopus get(int x, int y) {
    DumboOctopus octopus = octopusGrid.get(y).get(x);
    octopus.setPointX(x);
    octopus.setPointY(y);
    return octopus;
  }

  private void reset() {
    octopusGrid.forEach(list -> list.forEach(DumboOctopus::reset));
  }

  private List<List<DumboOctopus>> toOctopusGrid(List<String> input) {
    return input.stream()
        .map(line -> Arrays.stream(line.split(""))
            .map(n -> new DumboOctopus(Integer.parseInt(n)))
            .toList())
        .toList();
  }
}
