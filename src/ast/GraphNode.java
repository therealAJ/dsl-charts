package ast;

import ChartAttributes.ChartType;
import ChartAttributes.DataObject;
import ChartAttributes.OptionsObject;
import javafx.scene.chart.PieChart;
import util.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by jason on 2018-09-28.
 */
public class GraphNode extends Node {
    public String title;
    String type;
    ChartNode chartNode;

    // usage of passing count around?
    int count;

    public GraphNode(int count) {

    }

    // default constructor
    public GraphNode() {}

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
        chartNode.print();
    }

    public void evaluate() {
//        System.out.println("GraphNode evaluate called");
        chartNode.evaluate();
    }

    //    public void printGraphs() {
//        writer = new PrintWriter("charts.html", "UTF-8");
//        writer.println(Constants.START_HTML);
//
//        for (GraphNode graph: graphs) {
//            printHtmlCanvas();
//            printChartJsCode();
//        }
//        writer.println(Constants.END_HTML);
//        writer.close();
//    }

//    public void printHtmlCanvas() {
//        for(int i = 0; i < graphs.size(); i++) {
//            writer.println("<canvas id=\"chart" + i + "\" " +
//                    "width=\"400\" height=\"400\"></canvas>");
//        }
//    }
//
//    public void printChartJsCode() throws FileNotFoundException, UnsupportedEncodingException {
//        writer.println("<script>");
//        for(GraphNode g : graphs) {
//            g.evaluate();
//        }
//        writer.println("</script>");
//    }

}
