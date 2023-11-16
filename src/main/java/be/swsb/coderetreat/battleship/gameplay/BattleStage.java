package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Position;

public class BattleStage implements GameStage {
    private final Fleet blueFleet;
    private final Fleet redFleet;
    private final GameBoard gameBoard;

    public BattleStage(Fleet BlueFleet, Fleet redFleet) {
        this.blueFleet = BlueFleet;
        this.redFleet = redFleet;
        gameBoard = new GameBoard();
    }

    @Override
    public void shootAtEnemy(Player currentPlayer, Position position) {
        enemyFleet(currentPlayer).shootAt(position);
    }

    @Override
    public boolean hasGameEnded() {
        return blueFleet.isSunk() || redFleet.isSunk();
    }

    @Override
    public String renderGameBoard(Player player) {
        return gameBoard.renderToEmoji(ownFleet(player));
    }

    private Fleet ownFleet(Player player) {
        return switch (player) {
            case BLUE -> blueFleet;
            case RED -> redFleet;
        };
    }

    private Fleet enemyFleet(Player player) {
        return switch (player) {
            case BLUE -> redFleet;
            case RED -> blueFleet;
        };
    }
}

