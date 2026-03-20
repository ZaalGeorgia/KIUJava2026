package lab01;

import java.util.ArrayList;
import java.util.List;

public class BoxPuzzle {

    interface Unit {
        int size();
    }

    static class Item implements Unit {
        private final int value;

        Item(int value) {
            this.value = value;
        }

        @Override
        public int size() {
            return value;
        }
    }

    static class Crate implements Unit {
        private final List<Unit> parts = new ArrayList<>();

        void add(Unit unit) {
            parts.add(unit);
        }

        @Override
        public int size() {
            int sum = 0;
            for (Unit unit : parts) {
                sum += unit.size();
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Crate small = new Crate();
        small.add(new Item(2));
        small.add(new Item(3));

        Crate big = new Crate();
        big.add(small);
        big.add(new Item(5));

        System.out.println(big.size());
    }
}
