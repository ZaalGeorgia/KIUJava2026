package lab01;

public class MorningCoffee {

    interface Cup {
        String label();
        double price();
    }

    static class PlainCup implements Cup {
        @Override
        public String label() {
            return "Coffee";
        }

        @Override
        public double price() {
            return 3.00;
        }
    }

    static abstract class ExtraCup implements Cup {
        protected final Cup inner;

        ExtraCup(Cup inner) {
            this.inner = inner;
        }
    }

    static class MilkLayer extends ExtraCup {
        MilkLayer(Cup inner) {
            super(inner);
        }

        @Override
        public String label() {
            return inner.label() + ", milk";
        }

        @Override
        public double price() {
            return inner.price() + 0.50;
        }
    }

    static class SugarLayer extends ExtraCup {
        SugarLayer(Cup inner) {
            super(inner);
        }

        @Override
        public String label() {
            return inner.label() + ", sugar";
        }

        @Override
        public double price() {
            return inner.price() + 0.20;
        }
    }

    public static void main(String[] args) {
        Cup order = new SugarLayer(new MilkLayer(new PlainCup()));
        System.out.println(order.label() + " = " + order.price());
    }
}
