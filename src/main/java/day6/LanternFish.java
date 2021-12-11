package day6;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LanternFish {
    private static final int FIRST_CYCLE = 8;

    private final List<LanternFish> children = new ArrayList<>();
    private int daysLeftInCycle;

    public LanternFish(int daysLeftInCycle) {
        this.daysLeftInCycle = daysLeftInCycle;
    }

    public LanternFish() {
        this.daysLeftInCycle = FIRST_CYCLE;
    }

    public void tick() {
        children.forEach(LanternFish::tick);
        if (daysLeftInCycle == 0) {
            this.daysLeftInCycle = 6;
            children.add(new LanternFish());
        } else {
            daysLeftInCycle--;
        }
    }
}
