public class GameLog {

    public static class LogEntry {
        private final String message;

        public LogEntry(String message) {
            this.message = message;
        }

        public void print() {
            System.out.println("[LOG] " + message);
        }
    }
}
