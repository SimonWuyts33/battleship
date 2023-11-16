package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SetupStage implements GameStage {

    private final Consumer<GameStage> advanceToNextStage;
    private final List<Ship> blueShips = new ArrayList<>();
    private final List<Ship> redShips = new ArrayList<>();

    public SetupStage(Consumer<GameStage> advanceToNextStage) {
        this.advanceToNextStage = advanceToNextStage;
    }

    @Override
    public void addShip(Player currentPlayer, ShipType shipType, Position position, Orientation orientation) {
        switch (currentPlayer) {
            case BLUE -> blueShips.add(Ship.create(shipType, position, orientation));
            case RED -> redShips.add(Ship.create(shipType, position, orientation));
        }
    }

    @Override
    public void startBattle() {
        advanceToNextStage.accept(new BattleStage(Fleet.of(blueShips.toArray(Ship[]::new)), Fleet.of(redShips.toArray(Ship[]::new)), advanceToNextStage));
    }
}
