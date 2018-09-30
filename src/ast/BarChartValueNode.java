package ast;

import util.Constants;
import util.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

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
    public void evaluate() {
    }

    public void evaluate(Constants.BAR_CHART_PROPERTIES type) {
        switch (type) {
            case NAME:
                writer.println("\""+ name + "\"");
        }
    }
}
