package be.swsb.coderetreat.battleship;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Ship;
import be.swsb.coderetreat.battleship.domain.ShipPositionHealth;
import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.domain.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.domain.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipType.*;
import static org.assertj.core.api.Assertions.assertThat;

class FleetTest {

    private final Fleet fleet = Fleet.of(
            Ship.create(CARRIER, pos(1, 1), HORIZONTAL),
            Ship.create(SUBMARINE, pos(4, 3), VERTICAL));

    @Test
    void shipHealthAtPosition() {
        assertThat(fleet.shipHealthAtPosition(pos(0, 0))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(4, 2))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(1, 6))).isEmpty();

        assertThat(fleet.shipHealthAtPosition(pos(1, 1))).contains(ShipPositionHealth.OK);
        assertThat(fleet.shipHealthAtPosition(pos(1, 5))).contains(ShipPositionHealth.OK);
        assertThat(fleet.shipHealthAtPosition(pos(5, 3))).contains(ShipPositionHealth.OK);
    }

    @Test
    void shootAt_miss() {
        fleet.shootAt(pos(0, 0));
        fleet.shootAt(pos(7, 3));

        assertThat(fleet.shipHealthAtPosition(pos(0, 0))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(4, 2))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(1, 6))).isEmpty();

        assertThat(fleet.shipHealthAtPosition(pos(1, 1))).contains(ShipPositionHealth.OK);
        assertThat(fleet.shipHealthAtPosition(pos(1, 5))).contains(ShipPositionHealth.OK);
        assertThat(fleet.shipHealthAtPosition(pos(5, 3))).contains(ShipPositionHealth.OK);
    }

    @Test
    void shootAt_hit() {
        fleet.shootAt(pos(1, 5));
        fleet.shootAt(pos(7, 3));

        assertThat(fleet.shipHealthAtPosition(pos(0, 0))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(4, 2))).isEmpty();
        assertThat(fleet.shipHealthAtPosition(pos(1, 6))).isEmpty();

        assertThat(fleet.shipHealthAtPosition(pos(1, 1))).contains(ShipPositionHealth.OK);
        assertThat(fleet.shipHealthAtPosition(pos(1, 5))).contains(ShipPositionHealth.DAMAGED);
        assertThat(fleet.shipHealthAtPosition(pos(5, 3))).contains(ShipPositionHealth.OK);
        assertThat(fleet.isSunk()).isFalse();
    }

    @Test
    void sunkenFleet() {
        var fleet = Fleet.of(Ship.create(PATROL_BOAT, pos(1, 1), HORIZONTAL));
        assertThat(fleet.isSunk()).isFalse();
        fleet.shootAt(pos(1, 1));
        fleet.shootAt(pos(1, 2));

        assertThat(fleet.isSunk()).isTrue();
        assertThat(fleet.shipHealthAtPosition(pos(1, 1))).contains(ShipPositionHealth.SUNK);
        assertThat(fleet.shipHealthAtPosition(pos(1, 2))).contains(ShipPositionHealth.SUNK);
    }
}