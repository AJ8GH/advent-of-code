package io.github.aj8gh.aoc.y21.day11;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class OctopusEnergyTracker {
    private final List<List<DumboOctopus>> octopusGrid;
    private long flashes;
    private int rows;
    private int columns;

    public OctopusEnergyTracker(List<List<DumboOctopus>> octopusGrid) {
        this.octopusGrid = octopusGrid;
        this.rows = octopusGrid.size();
        this.columns = octopusGrid.get(0).size();
    }

    public void tickAll() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                tick(get(x, y));
            }
        }
        reset();
    }

    public boolean isSimultaneousFlash() {
        for (List<DumboOctopus> row : octopusGrid) {
            for (DumboOctopus octopus : row) {
                if (octopus.getEnergy() != 0) return false;
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
        int x = octopus.getX();
        int y = octopus.getY();
        Set<DumboOctopus> neighbours = new HashSet<>();

        if (x > 0) neighbours.add(get(x - 1, y));
        if (x < columns - 1) neighbours.add(get(x + 1, y));
        if (y > 0) neighbours.add(get(x, y - 1));
        if (y < rows - 1) neighbours.add(get(x, y + 1));
        if (x > 0 && y > 0) neighbours.add(get(x - 1, y - 1));
        if (x < columns - 1 && y < rows - 1) neighbours.add(get(x + 1, y + 1));
        if (x > 0 && y < rows - 1) neighbours.add(get(x - 1, y + 1));
        if (x < columns - 1 && y > 0) neighbours.add(get(x + 1, y - 1));

        return neighbours;
    }

    private DumboOctopus get(int x, int y) {
        DumboOctopus octopus = octopusGrid.get(y).get(x);
        octopus.setX(x);
        octopus.setY(y);
        return octopus;
    }

    private void reset() {
        octopusGrid.forEach(list -> list.forEach(DumboOctopus::reset));
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("\n");
        octopusGrid.forEach(row -> sb.append(row.toString()).append("\n"));
        return sb.toString();
    }
}
