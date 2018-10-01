package ast;

import util.Colour;
import util.Tokenizer;
import static util.Constants.COLOURS;

public class ChartValueNode extends Node {
    String name;
    int count;
    Colour colour;
    Colour border;

    @Override
    public void parse() {
        name = Tokenizer.getTokenizer().getNext();
        count = Integer.valueOf(Tokenizer.getTokenizer().getNext());
        String colourString = Tokenizer.getTokenizer().getNext();
        colour = COLOURS.containsKey(colourString) ? COLOURS.get(colourString) : COLOURS.get("red");
        String borderString = Tokenizer.getTokenizer().getNext();
        border = COLOURS.containsKey(borderString) ? COLOURS.get(borderString) : COLOURS.get("red");
    }

    @Override
    public void evaluate() {
    }
}
