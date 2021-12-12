package day12;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final String EXAMPLE_1 = "./src/main/resources/day12/example1.txt";
    private static final String EXAMPLE_2 = "./src/main/resources/day12/example2.txt";
    private static final String EXAMPLE_3 = "./src/main/resources/day12/example3.txt";
    private static final String INPUT = "./src/main/resources/day12/input.txt";

    public static void main(String[] args) {
        List<String> routes = deserialize(EXAMPLE_1);
        log.info(routes.toString());
    }

    private static List<String> deserialize(String filePath) {
        List<String> routes = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String route;
            while ((route = reader.readLine()) != null) routes.add(route);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routes;
    }
}
