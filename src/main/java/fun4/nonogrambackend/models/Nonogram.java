package fun4.nonogrambackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nonogram {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int[][] topRow;
    private int[][] sideRow;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;};

    public void setTopRow(int[][] topRow) { this.topRow = topRow; };

    public void setSideRow(int[][] sideRow) { this.sideRow = sideRow; };

    public int[][] getTopRow() {
        return topRow;
    }

    public int[][] getSideRow() {
        return sideRow;
    }

}
