package ast;

import util.Constants;
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
    int count;

    public BarChartNode(int count)
    {
        valueNodes = new ArrayList<>();
        this.count = count;
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
    public void evaluate() {
        String snippet = "var ctx" + count + " = document.getElementById(\"chart" + count +"\");\n" +
                "var myChart"  + count + " = new Chart(ctx"  + count + ", {\n" +
                "type: 'bar',\n" +
                "data: {\n" +
                "labels: [";
        writer.println(snippet);
        // labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"], 
        for(int i = 0; i < valueNodes.size(); i++) {
            valueNodes.get(i).evaluate(Constants.BAR_CHART_PROPERTIES.NAME);
            if(i != valueNodes.size()-1) {
                writer.println(",");
            }
        }

    }
}
