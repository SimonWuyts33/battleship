package be.swsb.coderetreat.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ship {

    private final Map<Position, ShipPositionHealth> shipStatus = new HashMap<>();

    public Ship(ShipType shipType, Position bowPosition, Orientation orientation) {
        final var verticalBowPosition = bowPosition.verticalPosition();
        final var horizontalBowPosition = bowPosition.horizontalPosition();
        for (int i = 0; i < shipType.length; i++) {
            switch (orientation) {
                case HORIZONTAL ->
                        shipStatus.put(Position.pos(horizontalBowPosition + i, verticalBowPosition), ShipPositionHealth.OK);
                case VERTICAL ->
                        shipStatus.put(Position.pos(horizontalBowPosition, verticalBowPosition + i), ShipPositionHealth.OK);
            }
        }
    }

    public static Ship create(ShipType shipType, Position position, Orientation orientation) {
        return new Ship(shipType, position, orientation);
    }

    public Set<Position> positions() {
        return shipStatus.keySet();
    }
}
