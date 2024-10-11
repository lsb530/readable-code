package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class Middle implements GameLevel {

    private static final int ROWS = 14;
    private static final int COLS = 18;
    private static final int LANDMINES = 40;

    @Override
    public int getRowSize() {
        return ROWS;
    }

    @Override
    public int getColSize() {
        return COLS;
    }

    @Override
    public int getLandMineCount() {
        return LANDMINES;
    }
}
