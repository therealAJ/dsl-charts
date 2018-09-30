package ChartAttributes;

import java.util.ArrayList;

/**
 * Created by daylan on 9/29/2018.
 */
public class DataObject {
    public ArrayList<String> labels;
    public Datasets datasets;

    public DataObject() {
        labels = new ArrayList<>();
        datasets = new Datasets();
    }
}
