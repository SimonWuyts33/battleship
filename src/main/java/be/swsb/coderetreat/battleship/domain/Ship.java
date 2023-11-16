package be.swsb.coderetreat.battleship.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipPositionHealth.DAMAGED;
import static be.swsb.coderetreat.battleship.domain.ShipPositionHealth.SUNK;

public class Ship {

    private final Map<Position, ShipPositionHealth> shipStatus = new HashMap<>();

    private Ship(ShipType shipType, Position bowPosition, Orientation orientation) {
        final var verticalBowPosition = bowPosition.rowNumber();
        final var horizontalBowPosition = bowPosition.columnNumber();
        for (int i = 0; i < shipType.length; i++) {
            switch (orientation) {
                case HORIZONTAL ->
                        shipStatus.put(pos(verticalBowPosition, horizontalBowPosition + i), ShipPositionHealth.OK);
                case VERTICAL ->
                        shipStatus.put(pos(verticalBowPosition + i, horizontalBowPosition), ShipPositionHealth.OK);
            }
        }
    }

    public static Ship create(ShipType shipType, Position position, Orientation orientation) {
        return new Ship(shipType, position, orientation);
    }

    public Set<Position> positions() {
        return shipStatus.keySet();
    }

    public boolean isAt(Position position) {
        return shipStatus.containsKey(position);
    }

    /**
     * @param position a position of this ship (verify with isAt
     * @return health or null if ship is not at position
     */
    public ShipPositionHealth healthAt(Position position) {
        return shipStatus.get(position);
    }

    public void damageAt(Position position) {
        shipStatus.put(position, DAMAGED);
        if (shipStatus.values().stream().allMatch(health -> health == DAMAGED)) {
            shipStatus.keySet().forEach(pos -> shipStatus.put(pos, SUNK));
        }
    }

    public boolean isSunk() {
        return shipStatus.containsValue(SUNK);
    }
}
