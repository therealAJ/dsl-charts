package ChartAttributes;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by daylan on 9/29/2018.
 */
public class Datasets {
    public String label;
    public ArrayList<Integer> data;
    public ArrayList<String> bgColours;
    public ArrayList<String> borderColours;

    public Datasets() {
        data = new ArrayList<>();
        bgColours = new ArrayList<>();
        borderColours = new ArrayList<>();
    }
}
