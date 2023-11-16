package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Ship;
import org.junit.jupiter.api.Test;

import static be.swsb.coderetreat.battleship.domain.Orientation.HORIZONTAL;
import static be.swsb.coderetreat.battleship.domain.Orientation.VERTICAL;
import static be.swsb.coderetreat.battleship.domain.Position.pos;
import static be.swsb.coderetreat.battleship.domain.ShipType.CARRIER;
import static be.swsb.coderetreat.battleship.domain.ShipType.SUBMARINE;
import static org.assertj.core.api.Assertions.assertThat;

class BattleStageTest {
    private final GameStage gameStage = new BattleStage(
            Fleet.of(
                    Ship.create(CARRIER, pos(1, 1), HORIZONTAL),
                    Ship.create(SUBMARINE, pos(4, 3), VERTICAL)),
            Fleet.of(
                    Ship.create(CARRIER, pos(3, 2), VERTICAL),
                    Ship.create(SUBMARINE, pos(4, 5), VERTICAL))
    );

    @Test
    void shootAtEnemy_untilGameEnds() {
        assertThat(gameStage.hasGameEnded()).isFalse();
        assertThat(gameStage.renderGameBoard(Player.BLUE)).isEqualTo(
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

        assertThat(gameStage.renderGameBoard(Player.RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
        //Blue keeps missing while red sinks all ships
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(1, 1));
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(1, 2));
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(1, 3));
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(1, 4));
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(1, 5));
        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(4, 3));


        gameStage.shootAtEnemy(Player.BLUE, pos(1, 1));
        gameStage.shootAtEnemy(Player.RED, pos(5, 3));
        gameStage.shootAtEnemy(Player.BLUE, pos(5, 5));

        assertThat(gameStage.hasGameEnded()).isFalse();
        gameStage.shootAtEnemy(Player.RED, pos(6, 3));


        assertThat(gameStage.renderGameBoard(Player.BLUE)).isEqualTo(
                """
                        🛟🛟🛟🛟🛟🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛟🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛟🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🛟🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );

        assertThat(gameStage.renderGameBoard(Player.RED)).isEqualTo(
                """
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊💥🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🛳️🌊🌊🌊🌊🌊
                        🌊🛳️🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        🌊🌊🌊🌊🌊🌊🌊🌊🌊🌊
                        """
        );
        assertThat(gameStage.hasGameEnded()).isTrue();


    }

    @Test
    void hasGameEnded() {
        assertThat(gameStage.hasGameEnded()).isFalse();

    }
}