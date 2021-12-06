package day6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LanternFish {
    private int daysLeftInCycle;
    private List<LanternFish> children = new ArrayList<>();

    public LanternFish(int daysLeftInCycle) {
        this.daysLeftInCycle = daysLeftInCycle;
    }

    public LanternFish() {
        this.daysLeftInCycle = 8;
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

    @Override
    public String toString() {
        return daysLeftInCycle + children.toString();
    }
}
