import ast.ProgramNode;
import util.Constants;
import util.Tokenizer;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, Object> symbolTable = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Tokenizer.makeTokenizer(Constants.INPUT_FILE_PATH, Constants.LITERALS);
        ProgramNode programNode = new ProgramNode();

        // programNode tracks a list of all the graphs in input
        programNode.parse();

        // iterate through and evaluate all of the graphs
        programNode.evaluate();

        //create HTML strings from graphs
        List<String> htmlStrings = programNode.generateHtmlStrings();

        //write HTML to output file;
        programNode.writeHtmlToFile(htmlStrings);

        // open the generated html page
        File output = new File(Constants.OUTPUT_FILE_PATH);
        Desktop.getDesktop().browse(output.toURI());
    }
}
