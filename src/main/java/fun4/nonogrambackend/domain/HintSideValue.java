package fun4.nonogrambackend.domain;

import javax.persistence.*;

@Entity
public class HintSideValue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int value;

    private int xCord;
    private int yCord;

    public HintSideValue() {

    }
    public HintSideValue(int value, int x, int y) {
        this.value = value;
        this.xCord = x;
        this.yCord = y;
    }
}
