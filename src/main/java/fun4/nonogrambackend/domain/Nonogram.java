package fun4.nonogrambackend.domain;

import javax.persistence.*;
import java.util.ArrayList;
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

    public String getName() { return name; }

    public int[][] getSideValues() {
        ArrayList<ArrayList<Integer>> arrayValues = new ArrayList<>();

        for (HintSideValue hint: sideValues) {
            while (arrayValues.size() != hint.getxCord() + 1) {
                arrayValues.add(new ArrayList<>());
            }
            arrayValues.get(hint.getxCord()).add(hint.getyCord(), hint.getValue());
        }

        return convertListToArray(arrayValues);
    }

    public int[][] getTopValues() {
        ArrayList<ArrayList<Integer>> arrayValues = new ArrayList<>();

        for (HintTopValue hint: topValues) {
            while (arrayValues.size() != hint.getxCord() + 1) {
                arrayValues.add(new ArrayList<>());
            }
            arrayValues.get(hint.getxCord()).add(hint.getyCord(), hint.getValue());
        }

        return convertListToArray(arrayValues);
    }

    private int[][] convertListToArray(ArrayList<ArrayList<Integer>> arrayValues) {
        int[][] array = new int[arrayValues.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[arrayValues.get(i).size()];
        }
        for(int i=0; i < arrayValues.size(); i++){
            for (int j = 0; j < arrayValues.get(i).size(); j++) {
                array[i][j] = arrayValues.get(i).get(j);
            }
        }

        return array;
    }
}
