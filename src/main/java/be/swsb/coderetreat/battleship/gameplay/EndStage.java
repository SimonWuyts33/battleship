package be.swsb.coderetreat.battleship.gameplay;

public class EndStage implements GameStage {
    private final Player winner;
    private final String blueFinalRender;
    private final String redFinalRender;

    public EndStage(Player winner, String blueFinalRender, String redFinalRender) {
        this.winner = winner;
        this.blueFinalRender = blueFinalRender;
        this.redFinalRender = redFinalRender;
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public String renderGameBoard(Player player) {
        return switch (player) {
            case BLUE -> blueFinalRender;
            case RED -> redFinalRender;
        };
    }
}
