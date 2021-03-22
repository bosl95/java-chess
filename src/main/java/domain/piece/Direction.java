package domain.piece;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    EAST(0, 1),
    SOUTHEAST(1, 1),
    SOUTH(1, 0),
    SOUTHWEST(1, -1),
    WEST(0, -1),
    NORTHWEST(-1, -1),
    NORTH(-1, 0),
    NORTHEAST(-1, 1),

    NNE(1, 2),
    NNW(-1, 2),
    SSE(1, -2),
    SSW(-1, -2),
    EEN(2, 1),
    EES(2, -1),
    WWN(-2, 1),
    WWS(-2, -1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Direction findDiagonalDirection(int rowDiff, int colDiff) {
        if (rowDiff > 0 && colDiff > 0) {
            return SOUTHEAST;
        }

        if (rowDiff > 0 && colDiff < 0) {
            return SOUTHWEST;
        }

        if (rowDiff < 0 && colDiff < 0) {
            return NORTHWEST;
        }

        return NORTHEAST;
    }

    public static Direction findLinearDirection(int rowDiff, int colDiff) {
        if (rowDiff < 0) {
            return NORTH;
        }

        if (rowDiff > 0) {
            return SOUTH;
        }

        if (colDiff < 0) {
            return WEST;
        }

        return EAST;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(NORTH, EAST, SOUTH, WEST);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
    }

    public static List<Direction> verticalDirection() {
        return Arrays.asList(SOUTH, NORTH);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(SOUTH, SOUTHWEST, SOUTHEAST);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(NORTH, NORTHWEST, NORTHEAST);
    }
}