package ast;

import util.Constants;
import util.Tokenizer;

public class ChartValueNode extends Node {
    String name;
    int count;
    String colour;

    @Override
    public void parse() {
        name = Tokenizer.getTokenizer().getNext();
        count = Integer.valueOf(Tokenizer.getTokenizer().getNext());
        String colourString = Tokenizer.getTokenizer().getNext();
        System.out.println(colourString);
        colour = colourString != null ? colourString : Constants.COLOUR_NOT_SPECIFIED;
    }

    @Override
    public void evaluate() {
    }
}
