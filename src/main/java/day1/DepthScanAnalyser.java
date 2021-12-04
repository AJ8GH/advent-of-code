package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepthScanAnalyser {
    private static final Path INPUT = Path.of("./src/main/java/day1/input.txt");

    private final List<Integer> depths = new ArrayList<>();
    private final List<Integer> threeDepthWindows = new ArrayList<>();

    public static void main(String[] args) {
        // part 1
        var analyser = new DepthScanAnalyser();
        analyser.deserializeDepthData();
        int depthIncreases = analyser.getNumberOfDepthIncreases(analyser.depths);
        System.out.println(depthIncreases);

        // part 2
        analyser.getThreeDepthWindows();
        depthIncreases = analyser.getNumberOfDepthIncreases(analyser.threeDepthWindows);
        System.out.println(depthIncreases);
    }

    private int getNumberOfDepthIncreases(List<Integer> list) {
        int numberOfDepthIncreases = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i > 0 && list.get(i) > list.get(i - 1)) {
                    numberOfDepthIncreases++;
                }
            }
        return numberOfDepthIncreases;
    }

    private void getThreeDepthWindows() {
        for (int i = 0; i < depths.size() - 2; i++) {
            int sum = depths.get(i) + depths.get(i + 1) + depths.get(i + 2);
            threeDepthWindows.add(sum);
        }
    }

    private void deserializeDepthData() {
        try (Scanner scanner = new Scanner(Files.newBufferedReader(INPUT))) {
            while (scanner.hasNextLine()) {
                int depth = Integer.parseInt(scanner.nextLine().trim());
                depths.add(depth);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
