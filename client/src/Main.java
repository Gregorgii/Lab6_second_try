public class Main {
    private Main() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startClient();
    }
}
