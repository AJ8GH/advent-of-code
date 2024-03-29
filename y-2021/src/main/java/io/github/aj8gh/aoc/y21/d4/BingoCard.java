package io.github.aj8gh.aoc.y21.d4;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class BingoCard {
  private final List<List<Integer>> numbers;
  private final int cardNumber;
  private boolean won = false;

  public BingoCard(List<List<Integer>> numbers, int cardNumber) {
    this.numbers = numbers;
    this.cardNumber = cardNumber;
  }

  public boolean markNumber(int number) {
    if (won) {
      return false;
    }
    numbers.forEach(row -> {
      int index = row.indexOf(number);
      if (index >= 0) {
        row.set(index, -1);
      }
    });
    return checkForBingo();
  }

  private boolean checkForBingo() {
    for (int i = 0; i < 5; i++) {
      if (getRow(i).stream().filter(n -> n < 0).count() == 5
          || getColumn(i).stream().filter(n -> n < 0).count() == 5) {
        log.info("Card {}: BINGO!", cardNumber);
        log.info(this.toString());
        return this.won = true;
      }
    }
    return false;
  }


  public List<Integer> getRow(int rowNumber) {
    return numbers.get(rowNumber);
  }

  public List<Integer> getColumn(int columnNumber) {
    List<Integer> column = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      column.add(numbers.get(i).get(columnNumber));
    }
    return column;
  }

  @Override
  public String toString() {
    return "Card " + cardNumber + ": " + numbers.toString();
  }
}
