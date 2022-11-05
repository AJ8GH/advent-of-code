package io.github.aj8gh.aoc.y21.day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class RouteMapper {
    private final List<Route> completedRoutes = new ArrayList<>();
    private boolean doubleVisit = false;

    public void mapRoutes(Collection<Cave> caves) {
        Route route = new Route();
        Cave start = getStart(caves);
        route.add(start);
        List<Route> routes = new ArrayList<>(List.of(route));
        exploreRoutes(routes);
    }

    private void exploreRoutes(List<Route> routes) {
        List<Route> newRoutes = new ArrayList<>(routes);
        for (Route route : routes) {
            Set<Cave> connections = route.getLast().getConnections();
            for (Cave connection : connections) {
                if (connection.isStart()) continue;
                List<Cave> caves = new ArrayList<>(route.getCaves());
                Route newRoute = new Route(caves, doubleVisit);
                newRoutes.remove(route);
                exploreConnection(connection, newRoutes, newRoute);
            }
        }
        if (!newRoutes.isEmpty()) exploreRoutes(newRoutes);
    }

    private void exploreConnection(Cave connection,
                                   List<Route> newRoutes,
                                   Route newRoute) {
        if (newRoute.add(connection)) {
            if (newRoute.isComplete()) {
                log.info("Completed Route: " + newRoute);
                completedRoutes.add(newRoute);
            } else {
                newRoutes.add(newRoute);
            }
        }
    }

    public void clear() {
        completedRoutes.clear();
    }

    private Cave getStart(Collection<Cave> caves) {
        for (Cave cave : caves) {
            if (cave.isStart()) return cave;
        }
        return null;
    }
}
