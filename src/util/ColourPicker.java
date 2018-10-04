package util;

import java.util.*;

public class ColourPicker {

    private static final ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(
            "red","blue","yellow","teal","purple","orange"));

    public static final Map<String, Colour> PREDEFINED_COLOURS;
    static {
        PREDEFINED_COLOURS = new HashMap<String, Colour>();
        PREDEFINED_COLOURS.put("red", Colour.RED);
        PREDEFINED_COLOURS.put("blue", Colour.BLUE);
        PREDEFINED_COLOURS.put("yellow", Colour.YELLOW);
        PREDEFINED_COLOURS.put("teal", Colour.TEAL);
        PREDEFINED_COLOURS.put("purple", Colour.PURPLE);
        PREDEFINED_COLOURS.put("orange", Colour.ORANGE);
    }
    private static final int MAP_SIZE = 6;

    public static Colour select(String c) {
        String key = c.toLowerCase();
        Colour value = PREDEFINED_COLOURS.get(key);
        if (value != null) return value;
        else return null;
    }

    public static Colour chooseAny(int i) {
        int index = i % MAP_SIZE;
        return PREDEFINED_COLOURS.get(nameList.get(index));
    }
}
