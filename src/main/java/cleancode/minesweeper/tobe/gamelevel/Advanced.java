package cleancode.minesweeper.tobe.gamelevel;

public class Advanced implements GameLevel {

    private static final int ROWS = 20;
    private static final int COLS = 24;
    private static final int LANDMINES = 99;

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
