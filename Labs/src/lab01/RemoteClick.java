package lab01;

public class RemoteClick {

    interface Step {
        void run();
    }

    static class Lamp {
        void on() {
            System.out.println("Lamp on");
        }

        void off() {
            System.out.println("Lamp off");
        }
    }

    static class StartStep implements Step {
        private final Lamp lamp;

        StartStep(Lamp lamp) {
            this.lamp = lamp;
        }

        @Override
        public void run() {
            lamp.on();
        }
    }

    static class StopStep implements Step {
        private final Lamp lamp;

        StopStep(Lamp lamp) {
            this.lamp = lamp;
        }

        @Override
        public void run() {
            lamp.off();
        }
    }

    static class Button {
        private Step step;

        void setStep(Step step) {
            this.step = step;
        }

        void press() {
            step.run();
        }
    }

    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Button button = new Button();
        button.setStep(new StartStep(lamp));
        button.press();
        button.setStep(new StopStep(lamp));
        button.press();
    }
}
