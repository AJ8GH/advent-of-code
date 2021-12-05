package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticReader {
    private static final String INPUT = "./src/main/resources/day3/input.txt";
    private static final char ONE = '1';
    private static final char ZERO = '0';

    private final List<String> binaryStrings = new ArrayList<>();

    public static void main(String[] args) {
        var diagnosticReader = new DiagnosticReader();

        // part 1
        diagnosticReader.deserializeReport();
        int solution1 = diagnosticReader.getGammaByEpsilon();
        System.out.println(solution1);

        // part 2
        String o2Gen = diagnosticReader.getGen(true);
        String co2Gen = diagnosticReader.getGen(false);
        int solution2 = Integer.parseInt(o2Gen, 2) * Integer.parseInt(co2Gen, 2);
        System.out.println(solution2);
    }

    private int getGammaByEpsilon() {
        int zeros;
        int ones;
        StringBuilder gammaSb = new StringBuilder();
        StringBuilder epsilonSb = new StringBuilder();

        for (int i = 0; i < binaryStrings.get(0).length(); i++) {
            zeros = 0;
            ones = 0;
            for (String binary : binaryStrings) {
                if (binary.charAt(i) == ZERO) zeros++;
                if (binary.charAt(i) == ONE) ones++;
            }
            gammaSb.append(zeros > ones ? 0 : 1);
            epsilonSb.append(zeros > ones ? 1 : 0);
        }

        int gammaDec = Integer.parseInt(gammaSb.toString(), 2);
        int epsilonDec = Integer.parseInt(epsilonSb.toString(), 2);

        return epsilonDec * gammaDec;
    }

    private String getGen(boolean oxygen) {
        var filteredList = new ArrayList<>(binaryStrings);
        for (int i = 0; i < binaryStrings.get(0).length(); i++) {
            int finalI = i;
            int zeros = 0;
            int ones = 0;
            for (String binary : filteredList) {
                if (binary.charAt(i) == ONE) ones++;
                if (binary.charAt(i) == ZERO) zeros++;
            }
            if (ones >= zeros) {
                filteredList.removeIf(s -> s.charAt(finalI) != (oxygen ? ONE : ZERO));
            } else {
                filteredList.removeIf(s -> s.charAt(finalI) != (oxygen ? ZERO : ONE));
            }
            if (filteredList.size() == 1) break;
        }
        return filteredList.get(0);
    }

    private void deserializeReport() {
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String binary;
            while ((binary = reader.readLine()) != null) {
                binaryStrings.add(binary.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
