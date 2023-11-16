package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Position;

import java.util.function.Consumer;

public class BattleStage implements GameStage {
    private final Fleet blueFleet;
    private final Fleet redFleet;
    private final Consumer<GameStage> advanceToNextStage;
    private final GameBoard gameBoard;

    public BattleStage(Fleet BlueFleet, Fleet redFleet, Consumer<GameStage> advanceToNextStage) {
        this.blueFleet = BlueFleet;
        this.redFleet = redFleet;
        this.advanceToNextStage = advanceToNextStage;
        gameBoard = new GameBoard();
    }

    @Override
    public void shootAtEnemy(Player currentPlayer, Position position) {
        enemyFleet(currentPlayer).shootAt(position);
    }

    @Override
    public boolean hasAFleetSunk() {
        return blueFleet.isSunk() || redFleet.isSunk();
    }

    @Override
    public String renderGameBoard(Player player) {
        return gameBoard.renderToEmoji(ownFleet(player));
    }

    @Override
    public void endBattle() {
        if (!hasAFleetSunk()) {
            throw new IllegalStateException("The battle is not done yet");
        }
        // Not possible to tie atm
        if (blueFleet.isSunk()) {
            advanceToNextStage.accept(new EndStage(Player.RED, renderGameBoard(Player.BLUE), renderGameBoard(Player.RED)));
        } else {
            advanceToNextStage.accept(new EndStage(Player.BLUE, renderGameBoard(Player.BLUE), renderGameBoard(Player.RED)));
        }
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

