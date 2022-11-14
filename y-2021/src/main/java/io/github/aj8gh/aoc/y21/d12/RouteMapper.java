package io.github.aj8gh.aoc.y21.d12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class RouteMapper {
  private final List<Route> completedRoutes = new ArrayList<>();
  private boolean doubleVisit = false;

  public int findRoutesPart1(List<String> input) {
    clear();
    mapRoutes(createCaves(input));
    return completedRoutes.size();
  }

  public int findRoutesPart2(List<String> input) {
    clear();
    this.doubleVisit = true;
    mapRoutes(createCaves(input));
    return completedRoutes.size();
  }

  private void mapRoutes(Collection<CaveA> caves) {
    Route route = new Route();
    CaveA start = getStart(caves);
    route.add(start);
    List<Route> routes = new ArrayList<>(List.of(route));
    exploreRoutes(routes);
  }

  private void exploreRoutes(List<Route> routes) {
    List<Route> newRoutes = new ArrayList<>(routes);
    for (Route route : routes) {
      Set<CaveA> connections = route.getLast().getConnections();
      for (CaveA connection : connections) {
        if (connection.isStart()) {
          continue;
        }
        List<CaveA> caves = new ArrayList<>(route.getCaves());
        Route newRoute = new Route(caves, doubleVisit);
        newRoutes.remove(route);
        exploreConnection(connection, newRoutes, newRoute);
      }
    }
    if (!newRoutes.isEmpty()) {
      exploreRoutes(newRoutes);
    }
  }

  private void exploreConnection(CaveA connection, List<Route> newRoutes, Route newRoute) {
    if (newRoute.add(connection)) {
      if (newRoute.isComplete()) {
        completedRoutes.add(newRoute);
      } else {
        newRoutes.add(newRoute);
      }
    }
  }

  private void clear() {
    completedRoutes.clear();
  }

  private CaveA getStart(Collection<CaveA> caves) {
    for (CaveA cave : caves) {
      if (cave.isStart()) {
        return cave;
      }
    }
    return null;
  }

  private Set<CaveA> createCaves(List<String> input) {
    CaveA.clear();
    for (var line : input) {
      String[] splitLine = line.split("-");
      CaveA cave1 = CaveA.create(splitLine[0]);
      CaveA cave2 = CaveA.create(splitLine[1]);
      cave1.addConnection(cave2);
      cave2.addConnection(cave1);
    }
    return CaveA.getCaves();
  }
}
