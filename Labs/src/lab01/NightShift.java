package lab01;

public class NightShift {

    static abstract class Supervisor {
        public void schedule() {
            Worker worker = hire();
            worker.work();
        }

        protected abstract Worker hire();
    }

    interface Worker {
        void work();
    }

    static class Baker implements Worker {
        @Override
        public void work() {
            System.out.println("Baking bread");
        }
    }

    static class Driver implements Worker {
        @Override
        public void work() {
            System.out.println("Driving van");
        }
    }

    static class BakerySupervisor extends Supervisor {
        @Override
        protected Worker hire() {
            return new Baker();
        }
    }

    static class DeliverySupervisor extends Supervisor {
        @Override
        protected Worker hire() {
            return new Driver();
        }
    }

    public static void main(String[] args) {
        new BakerySupervisor().schedule();
        new DeliverySupervisor().schedule();
    }
}
