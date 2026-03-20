package lab01;

public class OnlyOneMic {

    static class Mixer {
        private static final Mixer INSTANCE = new Mixer();

        private Mixer() {
        }

        static Mixer get() {
            return INSTANCE;
        }

        void speak(String text) {
            System.out.println("Mixer: " + text);
        }
    }

    public static void main(String[] args) {
        Mixer a = Mixer.get();
        Mixer b = Mixer.get();
        System.out.println(a == b);
    }
}
