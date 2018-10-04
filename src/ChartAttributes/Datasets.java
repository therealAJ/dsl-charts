package ChartAttributes;

import util.Colour;

import java.util.ArrayList;

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
