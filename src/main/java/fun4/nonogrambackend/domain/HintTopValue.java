package fun4.nonogrambackend.domain;

import javax.persistence.*;

@Entity
public class HintTopValue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int value;

    private int xCord;
    private int yCord;

    public HintTopValue() {

    }

    public HintTopValue(int value, int x, int y) {
        this.value = value;
        this.xCord = x;
        this.yCord = y;
    }

    public int getyCord() {
        return yCord;
    }

    public int getValue() {
        return value;
    }

    public int getxCord() {
        return xCord;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }
}
