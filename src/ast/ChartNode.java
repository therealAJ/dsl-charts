package ast;

import ChartAttributes.ChartType;
import ChartAttributes.DataObject;
import ChartAttributes.OptionsObject;
import ast.Node;
import javafx.scene.chart.Chart;
import util.Tokenizer;

import java.util.List;

/**
 * Created by jason on 2018-09-28.
 */
public abstract class ChartNode extends Node {
    String title;
    String type;
    DataObject data;
    OptionsObject options;
    List<ChartValueNode> chartItems;
    String xLabel;
    String yLabel;

    public ChartNode(){}

    public ChartNode(String chartType) {
        this.type = chartType;
        data = new DataObject();
        options = new OptionsObject();
    }


    // TODO: determine our grammar for creating other types of charts. Can we use a generic parse for all graph types?
    @Override
    public void parse() {
        Tokenizer.getTokenizer().getAndCheckNext("ITEMS:");
        while (Tokenizer.getTokenizer().checkToken("ITEM:")) {
            Tokenizer.getTokenizer().getNext();
            ChartValueNode valueNode = new ChartValueNode();
            valueNode.parse();
            chartItems.add(valueNode);
        }

        Tokenizer.getTokenizer().getAndCheckNext("LABELS:");
        Tokenizer.getTokenizer().getAndCheckNext("X:");
        xLabel = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("Y:");
        yLabel = Tokenizer.getTokenizer().getNext();
    }

    public void print() {
        System.out.println("\n**** " + type + " chart. Number of items: " + chartItems.size() + " ****");
        System.out.println("title: " + title);
        System.out.println("X axis: " + xLabel + ", Y axis: " + yLabel);
        for (ChartValueNode node: chartItems) {
            System.out.println("Name: " + node.name + ", colour: " + node.colour + ", count: " + node.count);
        }
        System.out.println("**** " + type + " chart end ****\n");
    }

    public void addData() {}

    public void addOptions () {}

    public void evaluate() {
        System.out.println("ChartNode evaluate called");
        data = new DataObject();
        addData();
        options = new OptionsObject();
        addOptions();
    }






}
