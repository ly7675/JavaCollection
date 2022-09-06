package com.mtxul.it.methodology.patterns.behavior.interpreter;

import java.util.StringTokenizer;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class TerminalExpression extends Expression {

    private String literal = null;

    public TerminalExpression(String str) {
        literal = str;
    }

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("D A");

    }

    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
