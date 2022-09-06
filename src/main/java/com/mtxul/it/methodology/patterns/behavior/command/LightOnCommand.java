package com.mtxul.it.methodology.patterns.behavior.command;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

