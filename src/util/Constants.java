package util;

import java.util.*;

public class Constants {

    public static String START_HTML = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "  <head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js\"></script>\n"+
            "    <title>Chart DSL</title>\n" +
            "  </head>\n" +
            "  <body>\n";
    public static String END_HTML = "</body>\n" +
            "</html>\n";

    public enum BAR_CHART_PROPERTIES  {
        NAME, VALUE, COLOR
    }

    public enum CHART_TYPES {
        BAR, PIE, LINE
    }

    public static final String INPUT_FILE_PATH = "input.txt";

    public static final String OUTPUT_FILE_PATH = "charts.html";

    public static final List<String> LITERALS = Arrays.asList("GRAPH:", "TYPE:","ITEMS:","ITEM:","LABELS:","X:","Y:",",","END");

    public static final Map<String, Colour> COLOURS;

    static
    {
        Map<String, Colour> coloursMap = new HashMap<>();
        coloursMap.put("red", new Colour(255, 0, 0));
        coloursMap.put("green", new Colour(0, 255, 0));
        coloursMap.put("blue", new Colour(0, 0, 255));
        COLOURS = Collections.unmodifiableMap(coloursMap);
    }
}
