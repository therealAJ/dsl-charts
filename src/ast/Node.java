package ast;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by jason on 2018-09-28.
 */
public abstract class Node {
    public abstract void parse();
    public abstract void evaluate() throws FileNotFoundException, UnsupportedEncodingException;
    static protected PrintWriter writer;
}
