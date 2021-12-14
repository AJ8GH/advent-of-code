package day12;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class Main {
    private static final String EXAMPLE_1 = "./src/main/resources/day12/example1.txt";
    private static final String EXAMPLE_2 = "./src/main/resources/day12/example2.txt";
    private static final String EXAMPLE_3 = "./src/main/resources/day12/example3.txt";
    private static final String INPUT = "./src/main/resources/day12/input.txt";

    public static void main(String[] args) {
        RouteMapper routeMapper = new RouteMapper();

        deserialize(EXAMPLE_1);
        int routes = findRoutes(routeMapper);
        log.info("Part 1 - Example 1: {}", routes);
        assert routes == 10;

        deserialize(EXAMPLE_2);
        routes = findRoutes(routeMapper);
        log.info("Part 1 - Example 2: {}", routes);
        assert routes == 19;

        deserialize(EXAMPLE_3);
        routes = findRoutes(routeMapper);
        log.info("Part 1 - Example 3: {}", routes);
        assert routes == 226;

        deserialize(INPUT);
        routes = findRoutes(routeMapper);
        log.info("Part 1 - Solution: {}", routes);
        assert routes == 3761;
    }

    private static int findRoutes(RouteMapper routeMapper) {
        routeMapper.clear();
        routeMapper.mapRoutes(Cave.getCaves());
        return routeMapper.getCompletedRoutes().size();
    }

    private static void deserialize(String filePath) {
        Cave.clear();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split("-");
                Cave cave1 = Cave.create(splitLine[0]);
                Cave cave2 = Cave.create(splitLine[1]);
                cave1.addConnection(cave2);
                cave2.addConnection(cave1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
