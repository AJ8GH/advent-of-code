package day15;

import lombok.Data;

@Data
public class Position {
    private final int riskLevel;
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return String.valueOf(riskLevel);
    }
}
