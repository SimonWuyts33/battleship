package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Orientation;
import be.swsb.coderetreat.battleship.domain.Position;
import be.swsb.coderetreat.battleship.domain.ShipType;

public interface GameStage {
//TODO add tests for default behavior in all subclasses

    default void addShip(Player currentPlayer, ShipType shipType, Position position, Orientation orientation) {
        actionNotAllowed("addShip");
    }

    default void startBattle() {
        actionNotAllowed("startBattle");
    }

    default void shootAtEnemy(Player currentPlayer, Position position) {
        actionNotAllowed("shootAtEnemy");
    }

    default boolean hasAFleetSunk() {
        return false;
    }

    default String renderGameBoard(Player player) {
        return actionNotAllowed("renderGameBoardFor");
    }

    default void endBattle() {
        actionNotAllowed("endBattle");
    }

    default Player getWinner() {
        return actionNotAllowed("getWinner");
    }

    private <T> T actionNotAllowed(String action) {
        throw new IllegalStateException("%s not allowed in %s".formatted(action, this.getClass().getSimpleName()));
    }
}
