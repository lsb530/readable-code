package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    boolean isLandMine();

    boolean hasLandMineCount();

    String getSign();

    CellSnapshot getSnapshot();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

}
