package day13;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final String EXAMPLE = "./src/main/resources/day13/example.txt";
    private static final String INPUT = "./src/main/resources/day13/input.txt";

    private static final List<Fold> FOLDS = new ArrayList<>();
    private static final Set<Dot> DOTS = new HashSet<>();

    public static void main(String[] args) {
        Folder folder = new Folder();

        // part 1
        deserialize(EXAMPLE);
        Set<Dot> foldedDots = folder.fold(DOTS, FOLDS, 1);
        log.info("{}", foldedDots.size());
        assert foldedDots.size() == 17;

        deserialize(INPUT);
        foldedDots = folder.fold(DOTS, FOLDS, 1);
        log.info("{}", foldedDots.size());
        assert foldedDots.size() == 675;

        // part 2
        deserialize(INPUT);
        foldedDots = folder.fold(DOTS, FOLDS);
        log.info("{}", foldedDots.size());
        assert foldedDots.size() == 98;

        PaperGrid paperGrid = new PaperGrid(foldedDots);
        paperGrid.getGrid().forEach(row -> log.info(row.toString()));
    }

    private static void deserialize(String filePath) {
        FOLDS.clear();
        DOTS.clear();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                if (!line.contains("=")) {
                    List<Integer> coords = Arrays.stream(line.split(","))
                            .map(Integer::valueOf).collect(Collectors.toList());
                    Dot dot = new Dot(coords.get(0), coords.get(1));
                    DOTS.add(dot);
                } else {
                    String[] fold = line.split("=");
                    String axis = fold[0].substring(fold[0].length() - 1);
                    Integer point = Integer.valueOf(fold[1]);
                    FOLDS.add(new Fold(axis, point));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
