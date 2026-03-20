package lab01;

public class KitchenPlan {

    static abstract class Meal {
        public final void prepare() {
            wash();
            cook();
            serve();
        }

        protected void wash() {
            System.out.println("Wash ingredients");
        }

        protected abstract void cook();

        protected void serve() {
            System.out.println("Serve meal");
        }
    }

    static class SoupMeal extends Meal {
        @Override
        protected void cook() {
            System.out.println("Boil soup");
        }
    }

    static class GrillMeal extends Meal {
        @Override
        protected void cook() {
            System.out.println("Grill meat");
        }
    }

    public static void main(String[] args) {
        new SoupMeal().prepare();
        new GrillMeal().prepare();
    }
}
