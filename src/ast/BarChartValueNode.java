package ast;

import util.Tokenizer;

/**
 * Created by jason on 2018-09-28.
 */
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
    public String evaluate() {
        return null;
    }
}
