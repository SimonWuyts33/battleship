package be.swsb.coderetreat.battleship.gameplay;

import be.swsb.coderetreat.battleship.domain.Fleet;
import be.swsb.coderetreat.battleship.domain.Position;

import static be.swsb.coderetreat.battleship.domain.Position.pos;

public class GameBoard {


    public String renderToEmoji(Fleet fleet) {
        var lineSeparator = System.lineSeparator();
        var renderBuilder = new StringBuilder();
        int rowsMin = 1;
        int rowsMax = 10;
        int columnsMin = 1;
        int columnsMax = 10;
        for (int row = rowsMin; row <= rowsMax; row++) {
            for (int column = columnsMin; column <= columnsMax; column++) {
                renderBuilder.append(renderPositionToEmoji(fleet, pos(row, column)));
            }
            renderBuilder.append(lineSeparator);
        }
        return renderBuilder.toString();
    }

    private String renderPositionToEmoji(Fleet fleet, Position pos) {
        return fleet.shipHealthAtPosition(pos).map(
                shipPositionHealth ->
                        switch (shipPositionHealth) {
                            case OK -> "🛳️";
                            case DAMAGED -> "💥";
                            case SUNK -> "🛟";
                        }
        ).orElse("🌊");
    }
}
