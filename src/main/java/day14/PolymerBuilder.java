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
    private final Map<String, Long> count = new HashMap<>();

    public void build(int steps) {
        for (int i = 0; i < steps; i++) {
            StringBuilder newTemplate = new StringBuilder();
            for (int j = 0; j < template.length() - 1; j++) {
                newTemplate.append(template.charAt(j));
                String insertion = pairs.get(template.substring(j, j + 2));
                if (insertion != null) newTemplate.append(insertion);
                if (j == template.length() - 2) newTemplate.append(template.substring(template.length() - 1));
            }
            template = newTemplate.toString();
            log.info("{}", template.length());
        }
    }

    public long getMostMinusLeast() {
        countSymbols();
        List<Long> sortedCount = count.values().stream()
                .sorted().collect(Collectors.toList());
        return sortedCount.get(sortedCount.size() - 1) - sortedCount.get(0);
    }

    private void countSymbols() {
        Arrays.stream(template.split(""))
                .forEach(s -> count.put(s, count.getOrDefault(s, 0L) + 1));

    }
}
