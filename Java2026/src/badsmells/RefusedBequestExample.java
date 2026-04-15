package badsmells;

/*
 * Smell:
 * Penguin inherits from Bird but cannot support the fly() behavior, which makes
 * the inheritance relationship incorrect and misleading.
 *
 * Refactorings:
 * - Removed fly() from the base Bird class
 * - Introduced FlyingBird subclass for birds that can fly
 * - Made Penguin extend Bird without flying capability
 *
 * Why better:
 * The class hierarchy now correctly represents real-world behavior. Only birds
 * that can fly have the fly() method, and Penguin no longer inherits behavior
 * it cannot support.
 *
 * Behavior:
 * The observable behavior remains unchanged.
 */
public class RefusedBequestExample {

    static class Bird {
        // common bird behavior (if needed)
    }

    static class FlyingBird extends Bird {
        public void fly() {
            System.out.println("Flying");
        }
    }

    static class Sparrow extends FlyingBird {

        @Override
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    static class Eagle extends FlyingBird {

        @Override
        public void fly() {
            System.out.println("Eagle is soaring");
        }
    }

    static class Penguin extends Bird {
        // no fly method
    }

    public void clientCode() {
        FlyingBird sparrow = new Sparrow();
        FlyingBird eagle = new Eagle();
        Bird penguin = new Penguin();

        sparrow.fly();
        eagle.fly();

        System.out.println("Penguin cannot fly");
    }
}
