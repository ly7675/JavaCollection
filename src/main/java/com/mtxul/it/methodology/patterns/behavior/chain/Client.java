package com.mtxul.it.methodology.patterns.behavior.chain;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Handler handler3 = new ConcreteHandler3(handler2);
        Request request1 = new Request(RequestType.type1, "request1");
        handler2.handleRequest(request1);
        Request request2 = new Request(RequestType.type2, "request2");
        handler2.handleRequest(request2);
        Request request3 = new Request(RequestType.type3, "request3");
        handler3.handleRequest(request3);
        handler3.handleRequest(request1);
    }
}
