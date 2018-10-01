import ast.ProgramNode;
import util.Tokenizer;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> literals = Arrays.asList("GRAPH:", "TYPE:","ITEMS:","ITEM:","LABELS:","X:","Y:",",","END");
        Tokenizer.makeTokenizer("input.txt",literals);
        ProgramNode programNode = new ProgramNode();

        // programNode tracks a list of all the graphs in input
        programNode.parse();

        // iterate through and evaluate all of the graphs
        programNode.evaluate();

        //create HTML strings from graphs
        List<String> htmlStrings = programNode.generateHtmlStrings();

        //write HTML to output file;
        programNode.writeHtmlToFile(htmlStrings);
    }
}
