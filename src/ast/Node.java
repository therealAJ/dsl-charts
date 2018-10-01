package ast;

import java.io.PrintWriter;

/**
 * Created by jason on 2018-09-28.
 */
// should/could be interface?
public abstract class Node {
    public abstract void parse();
    public abstract void evaluate();
    static protected PrintWriter writer;
}
