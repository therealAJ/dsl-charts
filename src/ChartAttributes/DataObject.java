package ChartAttributes;

import java.util.ArrayList;

public class DataObject {
    public ArrayList<String> labels;
    public Datasets datasets;

    public DataObject() {
        labels = new ArrayList<>();
        datasets = new Datasets();
    }
}
