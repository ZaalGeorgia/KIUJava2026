package lab01;

public class GateMood {

    interface Mode {
        void act(Door door);
    }

    static class OpenMode implements Mode {
        @Override
        public void act(Door door) {
            System.out.println("Closing gate");
            door.setMode(new ClosedMode());
        }
    }

    static class ClosedMode implements Mode {
        @Override
        public void act(Door door) {
            System.out.println("Opening gate");
            door.setMode(new OpenMode());
        }
    }

    static class Door {
        private Mode mode = new ClosedMode();

        void setMode(Mode mode) {
            this.mode = mode;
        }

        void push() {
            mode.act(this);
        }
    }

    public static void main(String[] args) {
        Door door = new Door();
        door.push();
        door.push();
    }
}
