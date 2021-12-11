package day9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RiskLevelAnalyzer {
    private static final String INPUT = "./src/main/resources/day9/input.txt";
    private static final String EXAMPLE = "./src/main/resources/day9/example.txt";

    public static void main(String[] args) {
        var riskLevelAnalyzer = new RiskLevelAnalyzer();
        var heightMap = riskLevelAnalyzer.deserialize(INPUT);

        // part 1
        heightMap.findLowPoints();
        int riskLevel = riskLevelAnalyzer.calculateScore(heightMap.getLowPoints());
        System.out.println(riskLevel);

        // part 2
        heightMap.findBasins();
        int solution = riskLevelAnalyzer.getLargestBasinsFactor(heightMap);
        System.out.println(solution);
    }

    private int calculateScore(List<Point> lowPoints) {
        return lowPoints.stream()
                .map(Point::getHeight)
                .reduce(lowPoints.size(), Integer::sum);
    }

    private int getLargestBasinsFactor(HeightMap heightMap) {
        List<Basin> basins = heightMap.getBasins();
        basins.sort(Comparator.comparing(Basin::size));
        return basins.subList(basins.size() - 3, basins.size())
                .stream()
                .map(Basin::size)
                .reduce(1, (s1, s2) -> s1 * s2);
    }

    private HeightMap deserialize(String filePath) {
        List<List<Point>> heightMatrix = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                heightMatrix.add(Arrays.stream(line.split(""))
                        .map(n -> new Point(Integer.parseInt(n)))
                        .collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HeightMap(heightMatrix);
    }
}
