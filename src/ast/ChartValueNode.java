package ast;

import util.Constants;
import util.Tokenizer;

public class ChartValueNode extends Node {
    String name;
    int count;
    String colour;
    String border;

    @Override
    public void parse() {
        // TODO: Can check if next is a color if it is then add color if not set default
        name = Tokenizer.getTokenizer().getNext();
        count = Integer.valueOf(Tokenizer.getTokenizer().getNext());
        colour = Tokenizer.getTokenizer().getNext();
    }

    @Override
    public void evaluate() {
    }
}
