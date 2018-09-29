package ast;

import util.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jason on 2018-09-28.
 */
public class GraphNode extends Node {
    ChartNode chartNode;
    String title;
    int count;

    public GraphNode(int count) {
        this.count = count;
    }

    @Override
    public void parse() {
        title = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("TYPE:");
        String chartType = Tokenizer.getTokenizer().getNext();
        if (chartType.equals("Bar"))
        {
            chartNode = new BarChartNode(count);
            chartNode.parse();
        }
        else if (chartType.equals("Pie"))
        {
            // chartNode = new PieChartNode();
        }
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        chartNode.evaluate();
    }
}
