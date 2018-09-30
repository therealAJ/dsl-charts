package ast;

import util.Constants;
import util.SnippetGenerator;
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
        while (Tokenizer.getTokenizer().moreTokens()) {
            Tokenizer.getTokenizer().getAndCheckNext("GRAPH:");
            GraphNode g = new GraphNode();
            g.parse();
            graphs.add(g);
        }
    }

    @Override
    public void evaluate() {
        int i = 1;
        for (GraphNode graph: graphs) {
            graph.getChartNode().ID = i;
            graph.evaluate();
            i++;
        }
    }

    public void printGraphs() {
        for (GraphNode g: graphs) {
            SnippetGenerator sg = new SnippetGenerator(g.getChartNode());
            System.out.println(sg.printSnippet());

        }

    }
    /*
    I think printing needs to separated from evaluating.. It becomes too messy to try and do it all at once. I preserved
    this snippet below, but I think it should look something like this rather than containing it in evaluate:
     */

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
