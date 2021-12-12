package day10;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Runner {
    private static final String INPUT = "./src/main/resources/day10/input.txt";
    private static final String EXAMPLE = "./src/main/resources/day10/example.txt";
    private static final SyntaxChecker SYNTAX_CHECKER = new SyntaxChecker();

    public static void main(String[] args) {
        // part 1
        List<String> lines = deserialize(EXAMPLE);
        int score = calculateScore(lines);
        log.info("Part 1 - Example: {}", score);
        assert score == 26397;

        lines = deserialize(INPUT);
        score = calculateScore(lines);
        log.info("Part 1 - Solution: {}", score);
        assert score == 462693;

        //part 2
        lines = deserialize(EXAMPLE);
        long completionScore = getMiddleScore(lines);
        log.info("Part 2 - Example: {}", completionScore);
        assert completionScore == 288957;

        lines = deserialize(INPUT);
        completionScore = getMiddleScore(lines);
        log.info("Part 2 - Solution: {}", completionScore);
        assert completionScore == 3094671161L;
    }

    private static int calculateScore(List<String> lines) {
        return lines.stream()
                .map(SYNTAX_CHECKER::checkCorrupted)
                .reduce(0, Integer::sum);
    }

    private static long getMiddleScore(List<String> lines) {
        List<Long> scores = lines.stream()
                .map(SYNTAX_CHECKER::checkIncomplete)
                .filter(score -> score > 0)
                .sorted()
                .collect(Collectors.toList());
        return scores.get(scores.size() / 2);
    }

    private static List<String> deserialize(String filePath) {
        List<String> lines = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
