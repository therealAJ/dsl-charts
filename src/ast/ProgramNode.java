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
    public List<GraphNode> graphs = new ArrayList<>();

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

    public List<String> generateHtmlStrings() {
        List<String> htmlStrings = new ArrayList<>();
        for (GraphNode g: graphs) {
            SnippetGenerator sg = new SnippetGenerator(g.getChartNode());
            String htmlStr = sg.printSnippet();
            htmlStrings.add(htmlStr);
            System.out.println(htmlStr); // logging
        }
        return htmlStrings;
    }

    public void writeHtmlToFile(List<String> htmlStrings) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("charts.html", "UTF-8");
        writer.println(Constants.START_HTML);
        for(String htmlStr : htmlStrings) {
            writer.println(htmlStr);
        }
        writer.println(Constants.END_HTML);
        writer.close();
    }
}
