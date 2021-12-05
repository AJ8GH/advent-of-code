package day4;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Deserializer {
    private static final String SEQUENCE = "./src/main/resources/day4/sequence.txt";
    private static final String CARDS = "./src/main/resources/day4/cards.txt";

    public List<Integer> deserializeSequence() {
        List<Integer> sequence = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(SEQUENCE))) {
            String sequenceStr = reader.readLine();
            List.of(sequenceStr.split(","))
                    .forEach(s -> sequence.add(Integer.valueOf(s)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(sequence.toString());
        return sequence;
    }

    public List<BingoCard> deserializeCards() {
        List<BingoCard> cards = new ArrayList<>();
        try (var scanner = new Scanner(new BufferedReader(new FileReader(CARDS)))) {
            while (scanner.hasNextInt()) {
                List<List<Integer>> rows = new ArrayList<>(5);
                for (int i = 0; i < 5; i++) {
                    List<Integer> row = new ArrayList<>(5);
                    for (int j = 0; j < 5; j++) row.add(scanner.nextInt());
                    rows.add(row);
                }
                cards.add(new BingoCard(rows, cards.size()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        log.info(cards.toString());
        return cards;
    }
}
