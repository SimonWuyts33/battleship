package be.swsb.coderetreat.battleship.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * "smart" collection of ships
 */
public class Fleet {
    private final Set<Ship> ships = new HashSet<>();

    private Fleet() {
    }

    public static Fleet of(Ship... ships) {
        var fleet = new Fleet();
        fleet.ships.addAll(Set.of(ships));
        return fleet;
    }

    private Optional<Ship> shipAt(Position position) {
        return ships.stream().filter(ship -> ship.isAt(position)).findAny();
    }

    public Optional<ShipPositionHealth> shipHealthAtPosition(Position position) {
        return shipAt(position).map(ship -> ship.healthAt(position));
    }

    public void shootAt(Position position) {
        shipAt(position).ifPresent(ship -> ship.damageAt(position));
    }

    public boolean isSunk() {
        return ships.stream().allMatch(Ship::isSunk);
    }
}
