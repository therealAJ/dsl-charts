package ast;

import util.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class DecNode extends Node {
    @Override
    public void parse() {
        String variableName = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("ITEMS:");
        List<ChartValueNode> chartItems = new ArrayList<>();
        while (Tokenizer.getTokenizer().checkToken("ITEM:"))
        {
            Tokenizer.getTokenizer().getNext();
            ChartValueNode valueNode = new ChartValueNode();
            valueNode.parse();
            chartItems.add(valueNode);
        }
        Main.symbolTable.put(variableName, chartItems);
    }

    @Override
    public void evaluate() {
        return;
    }
}
