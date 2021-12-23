package day15;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Cave {
    private List<List<Position>> grid;

    public int rows() {
        return grid.size();
    }

    public int columns() {
        return grid.get(0).size();
    }

    public Position get(int x, int y) {
        return grid.get(y).get(x);
    }

    public List<Position> getOptions(Position position) {
        int x = position.getX();
        int y = position.getY();
        List<Position> options = new ArrayList<>();
        if (x < columns() - 1) options.add(get(x + 1, y));
        if (y < rows() - 1) options.add(get(x, y + 1));
        return options;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        for (List<Position> row : grid) sb.append(row).append("\n");
        return sb.toString();
    }
}
