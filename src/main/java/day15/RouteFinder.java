package day15;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class RouteFinder {
    private final Cave cave;

    private long startTime = System.currentTimeMillis();
    private int lowestRiskRoute = Integer.MAX_VALUE;
    private long routeCounter;

    public void find() {
        Position start = cave.get(0, 0);
        List<Position> positions = new ArrayList<>();
        positions.add(start);
        Route route = new Route(positions);
        checkOptions(route);
    }

    private void checkOptions(Route route) {
        if (++routeCounter % 100_000_000 == 0) {
            log.info("Routes checked: {}", routeCounter);
            log.info("Runtime: {} seconds", (System.currentTimeMillis() - startTime) / 1000);
        }
        int total = route.getTotalRisk();
        if (total < lowestRiskRoute) {
            if (isComplete(route)) {
                lowestRiskRoute = total;
                log.info("New lowest: {}", lowestRiskRoute);
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
