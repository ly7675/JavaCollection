package com.mtxul.it.methodology.patterns.structure.bridge;

/**
 * 使用桥接模式通过将实现和抽象放在两个不同的类层次中而使它们可以独立改变
 *
 * @User: MTXUL
 * @Date: 2022/8/27
 */
public class BridgeMain {
    public static void main(String[] args) {
        Specific2RemoteControl specific2RemoteControl = new Specific2RemoteControl(new Specific2TV());
        specific2RemoteControl.on();
        specific2RemoteControl.tuneChannel();
        specific2RemoteControl.off();
    }

    static abstract class TV {
        abstract void on();

        abstract void tuneChannel();

        abstract void off();
    }

    static class Specific1TV extends TV {
        @Override
        void on() {
            System.out.println("Specific1TV on");
        }

        @Override
        void tuneChannel() {
            System.out.println("Specific1TV tuneChannel");
        }

        @Override
        void off() {
            System.out.println("Specific1TV off");
        }
    }

    static class Specific2TV extends TV {
        @Override
        void on() {
            System.out.println("Specific2TV on");
        }

        @Override
        void tuneChannel() {
            System.out.println("Specific2TV tuneChannel");
        }

        @Override
        void off() {
            System.out.println("Specific2TV off");
        }
    }

    static abstract class RemoteControl {
        protected TV tv;

        public RemoteControl(TV tv) {
            this.tv = tv;
        }

        public abstract void on();

        public abstract void off();

        public abstract void tuneChannel();
    }

    static class Specific1RemoteControl extends RemoteControl {

        public Specific1RemoteControl(TV tv) {
            super(tv);
        }

        @Override
        public void on() {
            System.out.println("Specific1RemoteControl on");
            tv.on();
        }

        @Override
        public void off() {
            System.out.println("Specific1RemoteControl off");
            tv.off();
        }

        @Override
        public void tuneChannel() {
            System.out.println("Specific1RemoteControl tuneChannel");
            tv.tuneChannel();
        }
    }

    static class Specific2RemoteControl extends RemoteControl {

        public Specific2RemoteControl(TV tv) {
            super(tv);
        }

        @Override
        public void on() {
            System.out.println("Specific2RemoteControl on");
            tv.on();
        }

        @Override
        public void off() {
            System.out.println("Specific2RemoteControl off");
            tv.off();
        }

        @Override
        public void tuneChannel() {
            System.out.println("Specific2RemoteControl tuneChannel");
            tv.tuneChannel();
        }
    }
}
