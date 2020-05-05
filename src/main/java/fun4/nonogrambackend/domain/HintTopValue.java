package fun4.nonogrambackend.domain;

import javax.persistence.*;

public class HintTopValue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="nonogramId")
    private Nonogram nonogram;

    private int value;

    private int xCord;
    private int yCord;
}
