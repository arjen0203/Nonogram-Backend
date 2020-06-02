package fun4.nonogrambackend.domain;

import lombok.Data;

@Data
public class NonogramSimple {
    private int id;
    private String name;
    private String createrName;

    public NonogramSimple(int id, String name, String createrName) {
        this.id = id;
        this.name = name;
        this.createrName = createrName;
    }

}
