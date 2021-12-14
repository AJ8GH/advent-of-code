package day12;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Slf4j
public class RouteMapper {
    private final List<Route> completedRoutes = new ArrayList<>();
    int
            part = 1;

    public void mapRoutes(Collection<Cave> caves) {
        List<Route> routes = new ArrayList<>();
        Route route = new Route();
        Cave start = getStart(caves);
        route.add(start);
        routes.add(route);
        exploreRoutes(routes);
    }

    private void exploreRoutes(List<Route> routes) {
        List<Route> newRoutes = new ArrayList<>(routes);
        for (Route route : routes) {
            Set<Cave> connections = route.getLast().getConnections();
            for (Cave connection : connections) {
                if (connection.isStart()) continue;
                Route newRoute = new Route(new ArrayList<>(route.getCaves()));
                newRoute.setPart(part);
                newRoutes.remove(route);
                if (newRoute.add(connection)) {
                    if (newRoute.isComplete()) {
                        log.info("GOT ONE: " + newRoute);
                        completedRoutes.add(newRoute);
                    } else {
                        newRoutes.add(newRoute);
                    }
                }
            }
        }
        if (!newRoutes.isEmpty()) exploreRoutes(newRoutes);
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
