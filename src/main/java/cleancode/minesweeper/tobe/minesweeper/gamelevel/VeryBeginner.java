package cleancode.minesweeper.tobe.minesweeper.gamelevel;

public class VeryBeginner implements GameLevel {

    private static final int ROWS = 4;
    private static final int COLS = 5;
    private static final int LANDMINES = 2;

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
