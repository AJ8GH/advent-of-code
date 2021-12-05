package day5;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class HydroVentMap {
    private final List<List<Integer>> coordinates;
    private final List<List<Integer>> collisionMap;

    public HydroVentMap(List<List<Integer>> coordinates) {
        this.coordinates = coordinates;
        this.collisionMap = createCollisionMap();
        updateCollisionMap();
    }

    private List<List<Integer>> createCollisionMap() {
        int maxX = getMax(0);
        int maxY = getMax(1);

        List<List<Integer>> collisionMap = new ArrayList<>(maxY + 1);
        for (int i = 0; i < maxX + 1; i++) {
            List<Integer> row  = new ArrayList<>(maxX + 1);
            for (int j = 0; j < maxX + 1; j++) row.add(0);
            collisionMap.add(row);
        }
        return collisionMap;
    }

    private void updateCollisionMap() {
        for (List<Integer> coords : coordinates) {
            int x1 = Math.min(coords.get(0), coords.get(2));
            int x2 = Math.max(coords.get(0), coords.get(2));
            int y1 = Math.min(coords.get(1), coords.get(3));
            int y2 = Math.max(coords.get(1), coords.get(3));

            if (y1 == y2) {
                List<Integer> row = collisionMap.get(y1);
                for (int x = x1; x <= x2; x++) {
                    row.set(x, row.get(x) + 1);
                }
            }

            if (x1 == x2) {
                for (int y = y1; y <= y2; y++) {
                    List<Integer> row = collisionMap.get(y);
                    row.set(x1, row.get(x1) + 1);
                }
            }

            log.info(this.toString());
        }
    }

    private int getMax(int index) {
        int max = 0;
        for (List<Integer> coords : coordinates) {
            for (int i = index; i < index + 3; i += 2) {
                if (coords.get(i) > max) max = coords.get(i);
            }
        }
        log.info("Maximum Coordinate: {}", max);
        return max;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> row : collisionMap) {
            sb.append(row).append("\n");
        }
        return sb.toString();
    }
}
