package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Position;

public interface GameStage {

    default void shootAtEnemy(Player currentPlayer, Position position) {
        actionNotAllowed("shootAtEnemy");
    }

    default boolean hasGameEnded() {
        return actionNotAllowed("hasGameEnded");
    }

    default String renderGameBoard(Player player) {
        return actionNotAllowed("renderGameBoardFor");
    }

    private <T> T actionNotAllowed(String action) {
        throw new IllegalStateException("%s is not allowed in %s".formatted(action, this.getClass().getSimpleName()));
    }
}
