package day8;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
public class Entry {
    private static final Map<Integer, Integer> UNIQUE_SEGMENT_MAP = Map.of(
            1, 2,
            4, 4,
            7, 3,
            8, 7
    );

    private final List<String> digits;
    private final List<String> input;
    private final List<String> output;

    private String topMiddle;
    private String bottomLeft;

    public Entry(String input, String output) {
        this.input = Arrays.asList(input.split(" "));
        this.output = Arrays.asList(output.split(" "));
        this.digits = new ArrayList<>();
        digits.addAll(this.input);
        digits.addAll(this.output);
        getTopMiddle();
        getBottomLeft();
    }

    public int getDigitValue(String digitString) {
        for (Map.Entry<Integer, Integer> entry : UNIQUE_SEGMENT_MAP.entrySet()) {
            if (entry.getValue() == digitString.length()) return entry.getKey();
        }

        String[] segments = getDigitStringByValue(1).split("");
        switch (digitString.length()) {
            case 5:
                if (digitString.contains(segments[0]) && digitString.contains(segments[1])) {
                    return 3;
                } else if (bottomLeft != null && digitString.contains(bottomLeft)) {
                    return 2;
                }
                return 5;
            case 6:
                if (bottomLeft != null && !digitString.contains(bottomLeft)) {
                    return 9;
                } else if (digitString.contains(segments[0]) && digitString.contains(segments[1])) {
                    return 0;
                }
                return 6;
            default:
                return -1;
            }
    }

    private void getTopMiddle() {
        String one = getDigitStringByValue(1);
        String seven = getDigitStringByValue(7);
        for (String segment : seven.split("")) {
            if (!one.contains(segment)) {
                this.topMiddle = segment;
                break;
            }
        }
    }

    private void getBottomLeft() {
        String four = getDigitStringByValue(4);
        String eight = getDigitStringByValue(8);
        String three = getDigitStringByValue(3);
        for (String segment : eight.split("")) {
            if (!four.contains(segment) && !three.contains(segment)) {
                this.bottomLeft = segment;
                break;
            }
        }
    }

    private String getDigitStringByValue(int value) {
        for (String digitString : digits) {
            if (value == 3) {
                if (getDigitValue(digitString) == value) return digitString;
            } else {
                int segments = UNIQUE_SEGMENT_MAP.get(value);
                if (digitString.length() == segments) return digitString;
            }
        }
        return null;
    }
}
