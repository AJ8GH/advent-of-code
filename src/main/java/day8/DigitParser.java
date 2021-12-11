package day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DigitParser {
    private static final String INPUT_EXAMPLE = "./src/main/resources/day8/example.txt";
    private static final String INPUT_PATH = "./src/main/resources/day8/input.txt";
    private static final Set<Integer> UNIQUE_SEGMENTS = Set.of(2, 3, 4, 7);

    private final List<Entry> entries = new ArrayList<>();

    public static void main(String[] args) {
        var displayInterpreter = new DigitParser();
        displayInterpreter.deserializeInput(INPUT_PATH);

        // part 1
        int uniqueDigitCount = displayInterpreter.getUniqueDigitCount();
        System.out.println(uniqueDigitCount);

        // part 2
        int outputTotal = displayInterpreter.getTotalOutput();
        System.out.println(outputTotal);
    }

    private int getTotalOutput() {
        return entries.stream().map(e -> {
                StringBuilder outputString = new StringBuilder();
                for (String digit : e.getOutput()) {
                    outputString.append(e.getDigitValue(digit));
                }
                return Integer.parseInt(outputString.toString());
            }).reduce(Integer::sum).get();
    }

    private int getUniqueDigitCount() {
        int uniqueDigitCount = 0;
        for (Entry entry : entries) {
            uniqueDigitCount += entry.getOutput()
                    .stream()
                    .filter(d -> UNIQUE_SEGMENTS.contains(d.length()))
                    .count();
        }
        return uniqueDigitCount;
    }

    private void deserializeInput(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] inputOutput = line.split(" \\| ");
                entries.add(new Entry(inputOutput[0], inputOutput[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
