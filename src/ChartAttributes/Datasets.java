package ChartAttributes;

import util.Colour;

import java.util.ArrayList;

public class Datasets {
    public String label;
    public ArrayList<Integer> data;
    public ArrayList<Colour> bgColours;
    public ArrayList<Colour> borderColours;

    public Datasets() {
        data = new ArrayList<>();
        bgColours = new ArrayList<>();
        borderColours = new ArrayList<>();
    }
}
