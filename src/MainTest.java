public class MainTest {
    public static void main(String[] args) {

        MultithreadedWebServer server = new MultithreadedWebServer(8080);
        Thread serverThread = new Thread(server::startServer);
        serverThread.start();
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
