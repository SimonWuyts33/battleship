package be.swsb.coderetreat.battleship;

import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.domain.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.domain.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipType.PATROL_BOAT;
import static be.swsb.coderetreat.battleship.gameplay.Player.BLUE;
import static be.swsb.coderetreat.battleship.gameplay.Player.RED;
import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {

    @Test
    void letsPlay() {
        var game = new GameController();

        // players place their ships
        game.addShip(RED, PATROL_BOAT, pos(3, 5), VERTICAL);
        game.addShip(BLUE, PATROL_BOAT, pos(1, 3), HORIZONTAL);

        //the battle starts
        game.startBattle();
        assertThat(game.renderGameBoard(BLUE)).isEqualTo(
                """
                        🌊🌊🛳️🛳️🌊🌊🌊🌊🌊🌊
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
        assertThat(game.renderGameBoard(RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );


        game.shootAtEnemy(RED, pos(1, 3));
        assertThat(game.renderGameBoard(BLUE)).isEqualTo(
                """
                        🌊🌊💥🛳️🌊🌊🌊🌊🌊🌊
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

        game.shootAtEnemy(BLUE, pos(4, 3));
        assertThat(game.renderGameBoard(RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );

        game.shootAtEnemy(RED, pos(1, 4));
        assertThat(game.renderGameBoard(BLUE)).isEqualTo(
                """
                        🌊🌊🛟🛟🌊🌊🌊🌊🌊🌊
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


        game.shootAtEnemy(BLUE, pos(3, 5));
        assertThat(game.renderGameBoard(RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊💥🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );

        //end game (this should happen automatically?
        game.endBattle();

        // check final render
        assertThat(game.renderGameBoard(BLUE)).isEqualTo(
                """
                        🌊🌊🛟🛟🌊🌊🌊🌊🌊🌊
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

        assertThat(game.renderGameBoard(RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊💥🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );

        //battle ends with a victor
        assertThat(game.getWinner()).isSameAs(RED);
    }
}