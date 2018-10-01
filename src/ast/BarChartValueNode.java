package ast;

import util.Constants;
import util.Tokenizer;

public class BarChartValueNode extends Node {
    String name;
    int count;
    String colour;

    @Override
    public void parse() {
        name = Tokenizer.getTokenizer().getNext();
        count = Integer.valueOf(Tokenizer.getTokenizer().getNext());
        colour = Tokenizer.getTokenizer().getNext();
    }

    @Override
    public void evaluate() {
    }
}
