package be.swsb.coderetreat.battleship;

import static be.swsb.coderetreat.battleship.Position.pos;

public class GameBoard {

    private final Fleet fleet;

    public GameBoard(Fleet fleet) {
        this.fleet = fleet;
    }

    public String renderToEmoji() {
        var lineSeparator = System.lineSeparator();
        var renderBuilder = new StringBuilder();
        int rowsMin = 1;
        int rowsMax = 10;
        int columnsMin = 1;
        int columnsMax = 10;
        for (int row = rowsMin; row <= rowsMax; row++) {
            for (int column = columnsMin; column <= columnsMax; column++) {
                renderBuilder.append(mapToEmoji(pos(row, column)));
            }
            renderBuilder.append(lineSeparator);
        }
        return renderBuilder.toString();
    }

    private String mapToEmoji(Position pos) {
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
