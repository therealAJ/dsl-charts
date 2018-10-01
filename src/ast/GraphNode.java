package ast;

import ChartAttributes.ChartType;
import util.Tokenizer;

public class GraphNode extends Node {
    public String title;
    ChartNode chartNode;

    public ChartNode getChartNode() {
        return this.chartNode;
    }

    @Override
    public void parse() {
        title = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("TYPE:");
        String chartType = Tokenizer.getTokenizer().getNext().toLowerCase();

        if (chartType.equals(ChartType.BAR)) {
            chartNode = new BarChartNode();
        } else if (chartType.equals(ChartType.PIE)) {
            chartNode = new PieChartNode();
        }
        chartNode.type = chartType;
        chartNode.title = title;
        chartNode.parse();
    }

    public void evaluate() {
        chartNode.evaluate();
    }
}
