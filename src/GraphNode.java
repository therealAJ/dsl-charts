/**
 * Created by jason on 2018-09-28.
 */
public class GraphNode implements Node {
    ChartNode chartNode;
    String title;
    @Override
    public void parse() {
        Tokenizer.getTokenizer().getAndCheckNext("GRAPH:");
        title = Tokenizer.getTokenizer().getNext();
        Tokenizer.getTokenizer().getAndCheckNext("TYPE:");
        String chartType = Tokenizer.getTokenizer().getNext();
        if (chartType.equals("Bar"))
        {
            chartNode = new BarChartNode();
            chartNode.parse();
        }
        else if (chartType.equals("Pie"))
        {
            // chartNode = new PieChartNode();
        }
    }

    @Override
    public String evaluate() {
        return null;
    }
}
