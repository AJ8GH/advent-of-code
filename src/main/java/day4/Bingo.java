package day4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Bingo {

    public static void main(String[] args) {
        var deserializer = new Deserializer();
        var bingo = new Bingo();
        List<Integer> sequence = deserializer.deserializeSequence();
        List<BingoCard> cards = deserializer.deserializeCards();

        // part 1
        int firstToWinScore = bingo.runSequence(sequence, cards);
        System.out.println(firstToWinScore);

        // part 2
        int lastToWinScore = bingo.getLastToWin(sequence, cards);
        System.out.println(lastToWinScore);
    }

    private int runSequence(List<Integer> sequence, List<BingoCard> cards) {
        for (int number : sequence) {
            log.info("Number: {}", number);
            for (BingoCard card : cards) {
                if (card.markNumber(number)) {
                    return calculateScore(card, number);
                }
            }
        }
        return -1;
    }

    private int calculateScore(BingoCard card, int number) {
        int score = 0;
        var numbers = card.getNumbers();
        for (List<Integer> row : numbers) {
            score += row.stream().filter(n -> n > 0).reduce(0, Integer::sum);
        }
        System.out.println(score);
        return score * number;
    }

    private int getLastToWin(List<Integer> sequence, List<BingoCard> cards) {
        List<Integer> numbers = new ArrayList<>();
        List<BingoCard> winners = new ArrayList<>();
        sequence.forEach(num -> cards.forEach(card -> {
            if (card.markNumber(num)) {
                winners.add(card);
                numbers.add(num);
            }
        }));
        return calculateScore(winners.get(winners.size() - 1), numbers.get(numbers.size() - 1));
    }
}
