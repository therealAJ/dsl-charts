import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> literals = Arrays.asList("GRAPH:", "TYPE:","ITEMS:","ITEM:","LABELS:","X:","Y:",",","END");
        Tokenizer.makeTokenizer("input.txt",literals);
        GraphNode graphNode = new GraphNode();
        graphNode.parse();
    }
}
