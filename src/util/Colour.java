package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colour {
    private int red;
    private int green;
    private int blue;

    private String bg;
    private String border;

    public static final Colour RED = new Colour("rgb(255, 99, 132)");
    public static final Colour BLUE = new Colour("rgb(54, 162, 235)");
    public static final Colour YELLOW = new Colour("rgb(255, 206, 86)");
    public static final Colour TEAL = new Colour("rgb(75, 192, 192)");
    public static final Colour PURPLE = new Colour("rgb(153, 102, 255)");
    public static final Colour ORANGE = new Colour("rgb(255, 159, 64)");


    public Colour (String colour) {
        splitRGBValues(colour);
        defineBGAndBorder();
    }

    public String toString()
    {
        return String.format("rgba(%d, %d, %d, 1.0)", red, green, blue);
    }

    private void splitRGBValues(String input) {
        Pattern c = Pattern.compile("rgb *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)");
        Matcher m = c.matcher(input);

        if (m.matches()) {
            red = Integer.valueOf(m.group(1));
            green = Integer.valueOf(m.group(2));
            blue = Integer.valueOf(m.group(3));
        } else {
            // TODO: invalid colour
        }
    }

    private void defineBGAndBorder() {
        this.bg = "rgba("+red+","+green+","+blue+",0.2)";
        this.border = "rgba("+red+","+green+","+blue+",1.0)";
    }

    public String getBg() {
        return this.bg;
    }

    public String getBorder() {
        return this.border;
    }
}
