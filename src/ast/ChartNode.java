package ast;

import ChartAttributes.DataObject;
import ChartAttributes.OptionsObject;
import util.Colour;
import util.ColourPicker;
import main.Main;
import util.Tokenizer;

import java.util.List;

public abstract class ChartNode extends Node {
    public int ID;
    public String title;
    public String type;
    public DataObject data;
    public OptionsObject options;
    List<ChartValueNode> chartItems;
    String xLabel;
    String yLabel;

    public ChartNode(){}

    // TODO: determine our grammar for creating other types of charts. Can we use a generic parse for all graph types?

    @Override
    public void parse() {
        Tokenizer.getTokenizer().getAndCheckNext("DATA:");
        if (Tokenizer.getTokenizer().checkToken("ITEMS:"))
        {
            Tokenizer.getTokenizer().getAndCheckNext("ITEMS:");
            while (Tokenizer.getTokenizer().checkToken("ITEM:")) {
                Tokenizer.getTokenizer().getNext();
                ChartValueNode valueNode = new ChartValueNode();
                valueNode.parse();
                chartItems.add(valueNode);
            }
        }
        else
        {
            chartItems = (List<ChartValueNode>) Main.symbolTable.get(Tokenizer.getTokenizer().getNext());
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

    // need to evaluate data object in other types such as line graph.
    // for now, this abstraction works for bar and pie
    public void addData() {
        data.datasets.label = xLabel;
        int i =0;
        for (ChartValueNode node: chartItems) {
            data.labels.add(node.name);
            data.datasets.data.add(node.count);
            Colour c = evaluateColour(node, i);
            data.datasets.bgColours.add(c.getBg());
            data.datasets.borderColours.add(c.getBorder());
            i++;
        }
    }

    public void addOptions () {}

    public void evaluate() {
        data = new DataObject();
        addData();
        options = new OptionsObject();
        addOptions();
    }

    private Colour evaluateColour(ChartValueNode node, int i) {
        if (node.colour == null) return ColourPicker.chooseAny(i);
        String c = node.colour;
        Colour attempt = ColourPicker.select(c);
        if (attempt != null) return attempt;
        else return new Colour(c);
    }
}
