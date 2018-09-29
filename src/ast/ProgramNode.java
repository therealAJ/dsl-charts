package ast;

import util.Constants;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends Node {
    List<GraphNode> graphs = new ArrayList<>();

    @Override
    public void parse() {

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("charts.html", "UTF-8");
        writer.println(Constants.START_HTML);
        return "";
    }
}
