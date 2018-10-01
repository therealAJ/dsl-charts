package util;

public class Colour {
    int red;
    int green;
    int blue;

    public Colour(int red, int green, int blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String toString()
    {
        return String.format("rgba(%d, %d, %d, 1.0)", red, green, blue);
    }
}
