package day15;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final String INPUT = "./src/main/resources/day15/input.txt";
    private static final String EXAMPLE = "./src/main/resources/day15/example.txt";

    public static void main(String[] args) {
//        // example
//        RouteFinder routeFinder = new RouteFinder(deserialize(EXAMPLE));
//        routeFinder.find();
//        log.info("Example 1: {}", routeFinder.getLowestRiskRoute());
//        assert routeFinder.getLowestRiskRoute() == 40;

        // solution
        var routeFinder = new RouteFinder(deserialize(INPUT));
        routeFinder.find();
        log.info("Solution 1: {}", routeFinder.getLowestRiskRoute());
    }

    private static Cave deserialize(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            List<List<Position>> grid = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                List<Position> row = new ArrayList<>();
                for (String num : line.split("")) {
                    Position position = new Position(Integer.parseInt(num), row.size(), grid.size());
                    row.add(position);
                }
                grid.add(row);
            }
            return new Cave(grid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
