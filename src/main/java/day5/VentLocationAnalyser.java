package day5;

import java.util.List;

public class VentLocationAnalyser {
    public static void main(String[] args) {
        var deserializer = new Deserializer();
        var hydroVentMap = deserializer.readInput();
        System.out.println(hydroVentMap.getCoordinates());
        long solution = countCollisions(hydroVentMap);
        System.out.println(solution);
    }

    private static long countCollisions(HydroVentMap hydroVentMap) {
        long count = 0;
        for (List<Integer> row : hydroVentMap.getCollisionMap()) {
            count += row
                    .stream()
                    .filter(n -> n > 1)
                    .count();
        }
        return count;
    }
}
