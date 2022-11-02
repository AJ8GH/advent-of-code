package io.github.aj8gh.aoc.y21.day10;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class SyntaxChecker {
    private static final Map<String, String> PAIRS = Map.of(
            "(", ")",
            "[", "]",
            "{", "}",
            "<", ">"
    );

    private static final Map<String, Integer> CORRUPT_SCORES = Map.of(
            ")", 3,
            "]", 57,
            "}", 1197,
            ">", 25137
    );

    private static final Map<String, Long> COMPLETION_SCORES = Map.of(
            ")", 1L,
            "]", 2L,
            "}", 3L,
            ">", 4L
    );

    public int getCorruptedScore(List<String> lines) {
        return lines.stream()
                .map(this::checkCorrupted)
                .reduce(0, Integer::sum);
    }

    public long getMiddleCompletionScore(List<String> lines) {
        List<Long> scores = lines.stream()
                .map(this::checkIncomplete)
                .filter(score -> score > 0)
                .sorted()
                .collect(Collectors.toList());
        return scores.get(scores.size() / 2);
    }


    private int checkCorrupted(String line) {
        List<String> expected = new ArrayList<>();
        String[] brackets = line.split("");
        for (String bracket : brackets) {
            if (!checkBracket(bracket, expected)) {
                return CORRUPT_SCORES.get(bracket);
            }
        }
        return 0;
    }

    private long checkIncomplete(String line) {
        List<String> expected = new ArrayList<>();
        String[] brackets = line.split("");
        for (String bracket : brackets) {
            if (!checkBracket(bracket, expected)) return 0;
        }
        return getCompletionScore(expected);
    }

    private boolean checkBracket(String bracket, List<String> expected) {
        if (isOpening(bracket)) {
            return expected.add(PAIRS.get(bracket));
        } else if (bracket.equals(expected.get(expected.size() - 1))) {
            expected.remove(expected.size() - 1);
            return true;
        }
        return false;
    }

    private long getCompletionScore(List<String> brackets) {
        List<Long> scores = brackets.stream()
                .map(COMPLETION_SCORES::get)
                .collect(Collectors.toList());
        Collections.reverse(scores);
        long totalScore = 0;
        for (long score : scores) {
            totalScore *= 5;
            totalScore += score;
        }
        return totalScore;
    }

    private boolean isOpening(String bracket) {
        return PAIRS.containsKey(bracket);
    }
}
