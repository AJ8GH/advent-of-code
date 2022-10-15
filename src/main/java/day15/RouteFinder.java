package day15;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class RouteFinder {
    private final Cave cave;
    private int lowestRiskRoute = Integer.MAX_VALUE;

    public void find() {
        Position start = cave.get(0, 0);
        List<Position> positions = new ArrayList<>();
        Route route = new Route(positions);
        checkOptions(route);
    }

    private void checkOptions(Route route) {
        int total = route.getTotalRisk();
        if (total < lowestRiskRoute) {
            if (isComplete(route)) {
                lowestRiskRoute = total;
                log.info("New lowest: {}", total);
            } else {
                List<Position> options = cave.getOptions(route.getLast());
                options.forEach(position -> checkOptions(route.newInstance(position)));
            }
        }
    }

    private boolean isComplete(Route route) {
        Position last = route.getLast();
        return last.getX() == cave.columns() - 1 && last.getY() == cave.rows() - 1;
    }
}
