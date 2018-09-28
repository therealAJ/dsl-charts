import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> literals = Arrays.asList("GRAPH:", "TYPE:","ITEMS:","ITEM:","LABELS:","XNAME","YNAME",",","END");
        Tokenizer.makeTokenizer("input.txt",literals);
    }
}
