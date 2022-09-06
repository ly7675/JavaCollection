package com.mtxul.it.methodology.patterns.behavior.chain;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class ConcreteHandler3 extends Handler {
    public ConcreteHandler3(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type3) {
            System.out.println(request.getName() + " is handle by ConcreteHandler3");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
