package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deserializer {
    private static final String INPUT = "./src/main/java/day2/input.txt";
    private static final String DELIMITER = " ";

    public Map<String, Integer> deserializeInputPart1() {
        Map<String, Integer> stepsMap = new HashMap<>();

        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String step;
            while ((step = reader.readLine()) != null) {
                String[] stepSplit = step.trim().split(DELIMITER);
                String direction = stepSplit[0];
                int distance = Integer.parseInt(stepSplit[1]);
                stepsMap.put(direction, stepsMap.getOrDefault(direction, 0) + distance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stepsMap;
    }

    public List<String> deserializeInputPart2() {
        List<String> stepsList = new ArrayList<>();

        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String step;
            while((step = reader.readLine()) != null) {
                stepsList.add(step.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stepsList;
    }
}
