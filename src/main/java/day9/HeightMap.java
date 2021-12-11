package day9;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class HeightMap {
    private final List<List<Integer>> map;
    private final List<Integer> lowPoints;

    private final int rows;
    private final int columns;

    public HeightMap(List<List<Integer>> map) {
        this.map = map;
        this.lowPoints = new ArrayList<>();
        this.rows = map.size();
        this.columns = map.get(0).size();
    }

    public void findLowPoints() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++){
                int point = getPoint(x, y);
                Set<Integer> neighbours = getNeighbours(x, y);
                boolean isLowest = isLowPoint(point, neighbours);
                if (isLowest) lowPoints.add(point);
            }
        }
    }

    private Set<Integer> getNeighbours(int x, int y) {
        Set<Integer> neighbours = new HashSet<>();
        if (x < columns - 1) neighbours.add(getPoint(x + 1, y));
        if (y < rows - 1) neighbours.add(getPoint(x, y + 1));
        if (x > 0) neighbours.add(getPoint(x - 1, y));
        if (y > 0) neighbours.add(getPoint(x, y - 1));
        return neighbours;
    }

    private boolean isLowPoint(int point, Collection<Integer> neighbours) {
        return neighbours
                .stream()
                .filter(i -> i <= point)
                .collect(Collectors.toSet())
                .isEmpty();
    }

    private int getPoint(int x, int y) {
        return map.get(y).get(x);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("\n");
        for (List<Integer> row : map) {
            sb.append(row).append("\n");
        }
        return sb.toString();
    }
}
