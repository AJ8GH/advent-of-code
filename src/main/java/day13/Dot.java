package day13;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dot {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "#";
    }
}
