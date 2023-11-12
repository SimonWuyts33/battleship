package be.swsb.coderetreat.battleship;

public enum ShipType {
    CARRIER(5),
    BATTLESHIP(4),
    DESTROYER(3),
    SUBMARINE(3),
    PATROL_BOAT(2);

    public final int length;

    ShipType(int length) {
        this.length = length;
    }
}
