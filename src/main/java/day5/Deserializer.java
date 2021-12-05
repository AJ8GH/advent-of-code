package day5;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Deserializer {
    private static final String INPUT = "./src/main/resources/day5/input.txt";

    public HydroVentMap readInput() {
        List<List<Integer>> coordinates = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Integer> coordGroup = new ArrayList<>();
                String[] halves = line.split(" -> ");
                coordGroup.add(Integer.valueOf(halves[0].split(",")[0]));
                coordGroup.add(Integer.valueOf(halves[0].split(",")[1]));
                coordGroup.add(Integer.valueOf(halves[1].split(",")[0]));
                coordGroup.add(Integer.valueOf(halves[1].split(",")[1]));
                coordinates.add(coordGroup);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(coordinates.toString());
        return new HydroVentMap(coordinates);
    }
}
