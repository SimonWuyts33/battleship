package be.swsb.coderetreat.battleship;

import be.swsb.coderetreat.battleship.domain.Orientation;
import be.swsb.coderetreat.battleship.domain.Position;
import be.swsb.coderetreat.battleship.domain.ShipType;
import be.swsb.coderetreat.battleship.gameplay.GameStage;
import be.swsb.coderetreat.battleship.gameplay.Player;
import be.swsb.coderetreat.battleship.gameplay.SetupStage;

public class GameController {
    public void addShip(Player currentPlayer, ShipType shipType, Position position, Orientation orientation) {
        gameStage.addShip(currentPlayer, shipType, position, orientation);
    }

    public void startBattle() {
        gameStage.startBattle();
    }    /**
     * TODO
     *      add currentPlayer concept
     *      only allow action on own turn
     *      check if game has ended after every shot
     *          if last ship sunk, end game
     *          [EXTRA: if hit, allow to shoot again]
     *          else turn goes to next player
     */
    private GameStage gameStage = new SetupStage(this::setGameStage);

    public void shootAtEnemy(Player currentPlayer, Position position) {
        gameStage.shootAtEnemy(currentPlayer, position);
    }

    public String renderGameBoard(Player player) {
        return gameStage.renderGameBoard(player);
    }

    public Player getWinner() {
        return gameStage.getWinner();
    }

    private void setGameStage(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    // TODO? remove/make private, only used for testing atm. Controller should end battle automatically if a fleet is sunk
    void endBattle() {
        gameStage.endBattle();
    }


}
