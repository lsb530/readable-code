package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class Beginner implements GameLevel {

    private static final int ROWS = 8;
    private static final int COLS = 10;
    private static final int LANDMINES = 10;

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
