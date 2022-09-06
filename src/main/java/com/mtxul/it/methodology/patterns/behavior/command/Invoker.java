package com.mtxul.it.methodology.patterns.behavior.command;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */

/**
 * 遥控器
 */
public class Invoker {
    private final Command[] onCommands;
    private final Command[] offCommands;

    public Invoker() {
        int slotNum = 7;
        this.onCommands = new Command[slotNum];
        this.offCommands = new Command[slotNum];
    }

    public void setOnCommand(Command command, int slot) {
        onCommands[slot] = command;
    }

    public void setOffCommand(Command command, int slot) {
        offCommands[slot] = command;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }
}
