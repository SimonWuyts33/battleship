package be.swsb.coderetreat.battleship;

/**
 * Horizontal 1 vertical 1, horizontal 2 vertical 1
 * horizontal 1 vertical 2, horizontal 2 vertical 2
 */
public record Position (
    int horizontalPosition,
    int verticalPosition){

    public static Position pos(int horizontal, int vertical) {
        return new Position(horizontal, vertical);
    }
}
