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
    private String topRow;
    private String sideRow;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;};

    public void setTopRow(String topRow) { this.topRow = topRow; };

    public void setSideRow(String sideRow) { this.sideRow = sideRow; };

    public String getTopRow() {
        return topRow;
    }

    public String getSideRow() {
        return sideRow;
    }

}
