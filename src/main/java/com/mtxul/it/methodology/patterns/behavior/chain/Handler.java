package com.mtxul.it.methodology.patterns.behavior.chain;


/**
 * 责任链:使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链发送该请求，直到有一个对象处理它为止。
 *
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}
