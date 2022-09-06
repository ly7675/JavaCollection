package com.mtxul.it.methodology.patterns.behavior.command;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

