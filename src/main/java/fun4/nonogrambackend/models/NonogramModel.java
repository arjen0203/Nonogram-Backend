package fun4.nonogrambackend.models;

public class NonogramModel {
    private final long id;
    private final int[][] topRow;
    private final int[][] sideRow;

    public NonogramModel(long id, int[][] topRow, int[][] sideRow) {
        this.id = id;
        this.topRow = topRow;
        this.sideRow = sideRow;
    }

    public long getId() {
        return id;
    }

    public int[][] getTopRow() {
        return topRow;
    }

    public int[][] getSideRow() {
        return sideRow;
    }

}
