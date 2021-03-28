package domain.piece;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Color {
    BLACK(true),
    WHITE(false);

    private final boolean color;

    Color(boolean color) {
        this.color = color;
    }

    public static Color of(boolean color) {
        return Arrays.stream(values())
                .filter(value -> value.color == color)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException());
    }

    public static String findColorName(Boolean color) {
        if (BLACK.getValue() == color) {
            return BLACK.name();
        }
        return WHITE.name();
    }

    public boolean getValue() {
        return color;
    }
}
