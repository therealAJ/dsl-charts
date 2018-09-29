package ast;

import util.Tokenizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 2018-09-28.
 */
public class BarChartNode extends ChartNode {
    List<BarChartValueNode> valueNodes;
    String xLabel;
    String yLabel;
    public BarChartNode()
    {
        valueNodes = new ArrayList<>();
    }

    @Override
    public void parse() {
        Tokenizer.getTokenizer().getAndCheckNext("ITEMS:");
        while (Tokenizer.getTokenizer().checkToken("ITEM:"))
        {
            Tokenizer.getTokenizer().getNext();
            BarChartValueNode valueNode = new BarChartValueNode();
            valueNode.parse();
            valueNodes.add(valueNode);
        }

        Tokenizer.getTokenizer().getAndCheckNext("LABELS:");
        Tokenizer.getTokenizer().getAndCheckNext("X:");
        xLabel = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("Y:");
        yLabel = Tokenizer.getTokenizer().getNext();
    }

    @Override
    public String evaluate() {
        return null;
    }
}
