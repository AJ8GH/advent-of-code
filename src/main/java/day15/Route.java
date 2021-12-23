package day15;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Route {
    private final List<Position> positions;

    public boolean add(Position position) {
        return positions.add(position);
    }

    public Position getLast() {
        return positions.get(positions.size() - 1);
    }

    public Route newInstance(Position position) {
        List<Position> newPositions = new ArrayList<>(positions);
        newPositions.add(position);
        return new Route(newPositions);
    }

    public int getTotalRisk() {
        return positions.subList(1, positions.size())
                .stream()
                .map(Position::getRiskLevel)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return positions.toString();
    }
}

//      1, 1, 2, 1, 3, 6, 5, 1, 1, 1, 5, 1, 1, 3, 2, 3, 2, 1, 1
//      1, 1, 2, 1, 3, 6, 5, 1, 1, 1, 5, 1, 1, 3, 2, 3, 2, 1, 1
