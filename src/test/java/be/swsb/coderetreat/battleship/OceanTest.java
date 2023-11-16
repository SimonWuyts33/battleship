package be.swsb.coderetreat.battleship;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.Position.pos;
import static be.swsb.coderetreat.battleship.ShipType.*;
import static org.assertj.core.api.Assertions.assertThat;

class OceanTest {

    @Test
    void renderToEmoji_defaultSize_10x10() {
        var ocean = new Ocean(Fleet.of());

        assertThat(ocean.renderToEmoji()).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
    }

    @Test
    void renderToEmoji_undamagedFleet() {
        var ocean = new Ocean(Fleet.of(
                Ship.create(CARRIER, pos(1, 1), HORIZONTAL),
                Ship.create(SUBMARINE, pos(4, 3), VERTICAL)));

        assertThat(ocean.renderToEmoji()).isEqualTo(
                """
                        🛳️🛳️🛳️🛳️🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );

    }

    @Test
    void renderToEmoji_damagedFleet() {
        var fleet = Fleet.of(
                Ship.create(CARRIER, pos(1, 1), HORIZONTAL),
                Ship.create(SUBMARINE, pos(4, 3), VERTICAL));
        var ocean = new Ocean(fleet);

        fleet.shootAt(pos(1, 4));
        fleet.shootAt(pos(6, 3));

        assertThat(ocean.renderToEmoji()).isEqualTo(
                """
                        🛳️🛳️🛳️💥🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊💥🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
    }

    @Test
    void renderToEmoji_damagedFleetWithSunkenShip() {
        var fleet = Fleet.of(
                Ship.create(CARRIER, pos(1, 1), HORIZONTAL),
                Ship.create(SUBMARINE, pos(4, 3), VERTICAL),
                Ship.create(PATROL_BOAT, pos(4, 9), HORIZONTAL));
        var ocean = new Ocean(fleet);

        fleet.shootAt(pos(1, 4));
        fleet.shootAt(pos(4, 9));
        fleet.shootAt(pos(4, 10));

        assertThat(ocean.renderToEmoji()).isEqualTo(
                """
                        🛳️🛳️🛳️💥🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🛟🛟
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛳️🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
    }
}