package be.swsb.coderetreat.battleship;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Ship;
import be.swsb.coderetreat.battleship.gameplay.GameBoard;
import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.domain.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.domain.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipType.*;
import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {

    @Test
    void renderToEmoji_defaultSize_10x10() {
        var ocean = new GameBoard(Fleet.of());

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
        var ocean = new GameBoard(Fleet.of(
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
        var ocean = new GameBoard(fleet);

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
        var ocean = new GameBoard(fleet);

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