package day14;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Slf4j
@AllArgsConstructor
public class PolymerBuilder {
    private String template;
    private final Map<String, String> pairs;
    private final Map<String, Integer> count = new HashMap<>();

    public void build(int steps) {
        for (int i = 0; i < steps; i++) {
            String[] symbols = template.split("");
            StringBuilder newTemplate = new StringBuilder();
            for (int j = 0; j < symbols.length - 1; j++) {
                newTemplate.append(symbols[j]);
                String insertion = pairs.get(symbols[j] + symbols[j + 1]);
                if (insertion != null) newTemplate.append(insertion);
                if (j == symbols.length - 2) newTemplate.append(symbols[symbols.length - 1]);
            }
            template = newTemplate.toString();
            log.info(template);
        }
    }

    public int getMostMinusLeast() {
        countSymbols();
        List<Integer> sortedCount = count.values().stream()
                .sorted().collect(Collectors.toList());
        return sortedCount.get(sortedCount.size() - 1) - sortedCount.get(0);
    }

    private void countSymbols() {
        Arrays.stream(template.split(""))
                .forEach(s -> count.put(s, count.getOrDefault(s, 0) + 1));

    }
}
