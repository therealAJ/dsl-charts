package ast;

import util.Constants;
import util.Tokenizer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends Node {
    public List<GraphNode> graphs = new ArrayList<>(); //"public" hack to let us get index of graph

    @Override
    public void parse() {
        int graphCount = 1;
        while (Tokenizer.getTokenizer().moreTokens()) {
            Tokenizer.getTokenizer().getAndCheckNext("GRAPH:");
            GraphNode g = new GraphNode(graphCount);
            g.parse();
            graphs.add(g);
            graphCount++;
        }
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("charts.html", "UTF-8");
        writer.println(Constants.START_HTML);
        printHtmlCanvas();
        printChartJsCode();
        writer.println(Constants.END_HTML);
        writer.close();
    }

    public void printHtmlCanvas() {
        for(int i = 0; i < graphs.size(); i++) {
            writer.println("<canvas id=\"chart" + i + "\" " +
                    "width=\"400\" height=\"400\"></canvas>");
        }
    }

    public void printChartJsCode() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("<script>");
        for(GraphNode g : graphs) {
            g.evaluate();
        }
        writer.println("</script>");
    }
}
