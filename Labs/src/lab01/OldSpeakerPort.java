package lab01;

public class OldSpeakerPort {

    interface SoundSource {
        void playTrack(String name);
    }

    static class LegacyPlayer {
        void startSong(String fileName) {
            System.out.println("Legacy player starts " + fileName);
        }
    }

    static class Wire implements SoundSource {
        private final LegacyPlayer legacyPlayer;

        Wire(LegacyPlayer legacyPlayer) {
            this.legacyPlayer = legacyPlayer;
        }

        @Override
        public void playTrack(String name) {
            legacyPlayer.startSong(name);
        }
    }

    static class ConferenceRoom {
        void test(SoundSource source) {
            source.playTrack("intro.mp3");
        }
    }

    public static void main(String[] args) {
        ConferenceRoom room = new ConferenceRoom();
        room.test(new Wire(new LegacyPlayer()));
    }
}
