package day4;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

    public String toString() {
        return "Card " + cardNumber + ": " + numbers.toString();
    }

    public boolean markNumber(int number) {
        if (won) return false;
        numbers.forEach(row -> {
            int index = row.indexOf(number);
            if (index >= 0) {
                row.remove(index);
                row.add(index, -1);
            }
        });
        return checkForBingo();
    }

    private boolean checkForBingo() {
         for (int i = 0; i < 5; i++) {
             if (getRow(i).stream().filter(n -> n < 0).count() == 5 ||
                     getColumn(i).stream().filter(n -> n < 0).count() == 5) {
                 log.info("Card {}: BINGO!", cardNumber);
                 log.info(this.toString());
                 return this.won = true;
             }
         }
         return false;
    }
}
