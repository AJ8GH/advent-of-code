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
    private final List<List<Point>> map;
    private final List<Point> lowPoints;
    private final List<Basin> basins;

    private final int rows;
    private final int columns;

    public HeightMap(List<List<Point>> map) {
        this.map = map;
        this.lowPoints = new ArrayList<>();
        this.basins = new ArrayList<>();
        this.rows = map.size();
        this.columns = map.get(0).size();
    }

    public void findLowPoints() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++){
                Point point = getPoint(x, y);
                Set<Point> neighbours = getNeighbours(point);
                if (isLowPoint(point, neighbours)) lowPoints.add(point);
            }
        }
    }

    public void findBasins() {
        for (Point point : lowPoints) {
            Basin basin = new Basin();
            exploreBasin(point, basin);
            basins.add(basin);
        }
    }

    private void exploreBasin(Point point, Basin basin) {
        basin.add(point);
        Set<Point> neighbours = getNeighbours(point);
        for (Point neighbour : neighbours) {
            if (neighbour.getHeight() > point.getHeight() && neighbour.getHeight() < 9) {
                exploreBasin(neighbour, basin);
            }
        }
    }

    private Set<Point> getNeighbours(Point p) {
        Set<Point> neighbours = new HashSet<>();
        if (p.getX() < columns - 1) neighbours.add(getPoint(p.getX() + 1, p.getY()));
        if (p.getY() < rows - 1) neighbours.add(getPoint(p.getX(), p.getY() + 1));
        if (p.getX() > 0) neighbours.add(getPoint(p.getX() - 1, p.getY() ));
        if (p.getY() > 0) neighbours.add(getPoint(p.getX(), p.getY() - 1));
        return neighbours;
    }

    private boolean isLowPoint(Point point, Collection<Point> neighbours) {
        return neighbours
                .stream()
                .filter(p -> p.getHeight() <= point.getHeight())
                .collect(Collectors.toSet())
                .isEmpty();
    }

    private Point getPoint(int x, int y) {
        Point point = map.get(y).get(x);
        return point.setX(x).setY(y);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("\n");
        for (List<Point> row : map) sb.append(row).append("\n");
        return sb.toString();
    }
}
