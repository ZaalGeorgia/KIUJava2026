package lab01;

import java.util.ArrayList;
import java.util.List;

public class WatchTower {

    interface Screen {
        void refresh(int value);
    }

    static class WindowA implements Screen {
        @Override
        public void refresh(int value) {
            System.out.println("WindowA sees " + value);
        }
    }

    static class WindowB implements Screen {
        @Override
        public void refresh(int value) {
            System.out.println("WindowB sees " + value);
        }
    }

    static class WeatherCenter {
        private final List<Screen> screens = new ArrayList<>();
        private int level;

        void attach(Screen screen) {
            screens.add(screen);
        }

        void setLevel(int level) {
            this.level = level;
            for (Screen screen : screens) {
                screen.refresh(this.level);
            }
        }
    }

    public static void main(String[] args) {
        WeatherCenter center = new WeatherCenter();
        center.attach(new WindowA());
        center.attach(new WindowB());
        center.setLevel(23);
    }
}
