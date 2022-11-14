package io.github.aj8gh.aoc.y21.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bingo {

  public int findFirstToWin(List<String> input) {
    var cards = toCardList(input.subList(1, input.size()));
    for (int number : toIntList(input.get(0))) {
      log.info("Number: {}", number);
      for (BingoCard card : cards) {
        if (card.markNumber(number)) {
          return calculateScore(card, number);
        }
      }
    }
    return -1;
  }

  public int findLastToWin(List<String> input) {
    var sequence = toIntList(input.get(0));
    var cards = toCardList(input.subList(1, input.size()));
    var numbers = new ArrayList<Integer>();
    var winners = new ArrayList<BingoCard>();
    sequence.forEach(num -> cards.forEach(card -> {
      if (card.markNumber(num)) {
        winners.add(card);
        numbers.add(num);
      }
    }));
    return calculateScore(winners.get(winners.size() - 1), numbers.get(numbers.size() - 1));
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

  private List<Integer> toIntList(String sequence) {
    return Arrays.stream(sequence.split(","))
        .map(Integer::parseInt)
        .toList();
  }

  private List<BingoCard> toCardList(List<String> input) {
    var cards = new ArrayList<BingoCard>();
    for (int i = 0; i < input.size(); i++) {
      if (input.get(i).isBlank()) {
        continue;
      }
      var rows = new ArrayList<List<Integer>>();
      for (int j = 0; j < 5; j++) {
        rows.add(new ArrayList<>(Arrays.stream(input.get(i++).split("\s+"))
            .filter(s -> !s.isBlank())
            .map(Integer::parseInt)
            .toList()));
      }
      cards.add(new BingoCard(rows, cards.size()));
    }
    return cards;
  }
}
