package be.swsb.coderetreat.battleship;

public class Ocean {

    private final int rowsMin = 1;
    private final int rowsMax = 10;
    private final int columnsMin = 1;
    private final int columnsMax = 10;

    public String renderToEmoji() {
        var lineSeparator = System.lineSeparator();
        var renderBuilder = new StringBuilder(210);
        for (int row = rowsMin; row <= rowsMax; row++) {
            renderBuilder.append("🌊".repeat(columnsMax));
            renderBuilder.append(lineSeparator);
        }
        return renderBuilder.toString();
    }
}
