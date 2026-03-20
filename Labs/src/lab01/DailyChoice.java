package lab01;

public class DailyChoice {

    interface FeeRule {
        double apply(double amount);
    }

    static class RegularRule implements FeeRule {
        @Override
        public double apply(double amount) {
            return amount;
        }
    }

    static class WeekendRule implements FeeRule {
        @Override
        public double apply(double amount) {
            return amount * 0.90;
        }
    }

    static class MemberRule implements FeeRule {
        @Override
        public double apply(double amount) {
            return amount * 0.85;
        }
    }

    static class CheckoutDesk {
        private FeeRule rule;

        CheckoutDesk(FeeRule rule) {
            this.rule = rule;
        }

        void changeRule(FeeRule rule) {
            this.rule = rule;
        }

        double total(double amount) {
            return rule.apply(amount);
        }
    }

    public static void main(String[] args) {
        CheckoutDesk desk = new CheckoutDesk(new RegularRule());
        System.out.println(desk.total(100));
        desk.changeRule(new WeekendRule());
        System.out.println(desk.total(100));
    }
}
