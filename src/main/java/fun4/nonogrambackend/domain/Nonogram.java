package fun4.nonogrambackend.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Nonogram {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "nonogram")
    private List<HintTopValue> topValues;

    //private List<HintSideValue> sideValues;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;};

    public void setName(String name) {
        this.name = name;
    };

}
