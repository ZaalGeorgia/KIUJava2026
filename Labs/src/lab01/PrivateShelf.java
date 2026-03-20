package lab01;

public class PrivateShelf {

    interface Archive {
        String fetch();
    }

    static class RealArchive implements Archive {
        @Override
        public String fetch() {
            return "Rare manuscript";
        }
    }

    static class CheckedArchive implements Archive {
        private final Archive inner;
        private final boolean allowed;

        CheckedArchive(Archive inner, boolean allowed) {
            this.inner = inner;
            this.allowed = allowed;
        }

        @Override
        public String fetch() {
            if (!allowed) {
                return "Access denied";
            }
            return inner.fetch();
        }
    }

    public static void main(String[] args) {
        Archive a = new CheckedArchive(new RealArchive(), false);
        Archive b = new CheckedArchive(new RealArchive(), true);
        System.out.println(a.fetch());
        System.out.println(b.fetch());
    }
}
