package io.github.aj8gh.aoc.y21.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String INPUT = "./src/main/resources/io.github.aj8gh.aoc.y21.day10/input.txt";
    private static final String EXAMPLE = "./src/main/resources/io.github.aj8gh.aoc.y21.day10/example.txt";
    private static final SyntaxChecker SYNTAX_CHECKER = new SyntaxChecker();

    public static void main(String[] args) {
        // part 1
        List<String> lines = deserialize(EXAMPLE);
        int score = SYNTAX_CHECKER.getCorruptedScore(lines);
        log.info("Part 1 - Example: {}", score);
        assert score == 26397;

        lines = deserialize(INPUT);
        score = SYNTAX_CHECKER.getCorruptedScore(lines);
        log.info("Part 1 - Solution: {}", score);
        assert score == 462693;

        //part 2
        lines = deserialize(EXAMPLE);
        long completionScore = SYNTAX_CHECKER.getMiddleCompletionScore(lines);
        log.info("Part 2 - Example: {}", completionScore);
        assert completionScore == 288957;

        lines = deserialize(INPUT);
        completionScore = SYNTAX_CHECKER.getMiddleCompletionScore(lines);
        log.info("Part 2 - Solution: {}", completionScore);
        assert completionScore == 3094671161L;
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
