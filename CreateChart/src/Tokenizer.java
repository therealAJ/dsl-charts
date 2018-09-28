import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {


    private static String program = "";
    private static List<String> literals;
    private String[] tokens;
    private int currentToken;
    private static Tokenizer theTokenizer;

    private Tokenizer(String filename, List<String> literalsList) throws Exception {
        literals = literalsList;
        try {
            String fileName = new File("src/" + filename).getAbsolutePath();
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                program += line;
            }
        } catch (IOException e) {
            String errorMessage = "Didn't find file: " + filename;
            throw new Exception(errorMessage);
        }
        tokenize();
//        System.out.println(program);
    }

    private void tokenize (){
        String tokenizedProgram = program;
        tokenizedProgram = tokenizedProgram.replace("\n","");
        tokenizedProgram = tokenizedProgram.replace(",","");
//        System.out.println(tokenizedProgram);
        for (String s : literals){
            tokenizedProgram = tokenizedProgram.replace(s,"_"+s+"_");
//            System.out.println(tokenizedProgram);
        }
        tokenizedProgram = tokenizedProgram.replaceAll("__","_");
//        System.out.println(tokenizedProgram);
        String [] temparray=tokenizedProgram.split("_");
        tokens = new String[temparray.length-1];
        System.arraycopy(temparray,1,tokens,0,temparray.length-1);
        System.out.println(Arrays.asList(tokens));
    }

    public static void makeTokenizer(String filename, List<String> literals) throws Exception {
        if (theTokenizer==null){
            theTokenizer = new Tokenizer(filename,literals);
        }
    }

    private String checkNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
        }
        else
            token="NO_MORE_TOKENS";
        return token;
    }

    public String getNext(){
        String token="";
        if (currentToken<tokens.length){
            token = tokens[currentToken];
            currentToken++;
        }
        else
            token="NULLTOKEN";
        return token;
    }


    public boolean checkToken(String regexp){
        String s = checkNext();
        System.out.println("comparing: "+s+"  to  "+regexp);
        return (s.matches(regexp));
    }


    public String getAndCheckNext(String regexp){
        String s = getNext();
        if (!s.matches(regexp)) System.exit(0);
        System.out.println("matched: "+s+"  to  "+regexp);
        return s;
    }

    public boolean moreTokens(){
        return currentToken<tokens.length;
    }


    public static Tokenizer getTokenizer(){
        return theTokenizer;
    }

}
