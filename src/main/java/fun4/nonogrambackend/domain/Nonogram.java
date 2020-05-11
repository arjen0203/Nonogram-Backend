package fun4.nonogrambackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Nonogram {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany
    private List<HintTopValue> topValues;
    @OneToMany
    private List<HintSideValue> sideValues;

    public void setSideValues(List<HintSideValue> sideValues) {
        this.sideValues = sideValues;
    }

    public void setTopValues(List<HintTopValue> topValues) {
        this.topValues = topValues;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
