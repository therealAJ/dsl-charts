package ast;

import util.Constants;
import util.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by daylan on 9/29/2018.
 */
public class ChartValueNode extends Node {
    String name;
    int count;
    String colour;
    String border;

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
