package com.mtxul.it.methodology.patterns.behavior.chain;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class Request {
    private final RequestType type;
    private final String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

