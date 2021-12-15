package day13;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class PaperGrid {
    private final List<List<Object>> grid;

    public PaperGrid(Set<Dot> dots) {
        this.grid = mapDots(dots);
    }

    public List<List<Object>> mapDots(Set<Dot> dots) {
        List<List<Object>> grid = createEmptyGrid(getMaxX(dots), getMaxY(dots));
        for (Dot dot : dots) {
            grid.get(dot.getY()).set(dot.getX(), dot);
        }
        return grid;
    }

    private List<List<Object>> createEmptyGrid(int maxX, int maxY) {
        List<List<Object>> grid = new ArrayList<>(maxY + 1);
        for (int i = 0; i < maxY + 1; i++) {
            List<Object> row = new ArrayList<>(maxX);
            grid.add(row);
            for (int j = 0; j < maxX + 1; j++) row.add(".");
        }
        return grid;
    }

    private int getMaxX(Set<Dot> dots) {
        return dots.stream().map(Dot::getX).sorted()
                .collect(Collectors.toList()).get(dots.size() - 1);
    }

    private int getMaxY(Set<Dot> dots) {
        return dots.stream().map(Dot::getX).sorted()
                .collect(Collectors.toList()).get(dots.size() - 1);
    }
}
