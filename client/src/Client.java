import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 6500);

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));


            writer.write("mtfk");
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println(response);

            writer.close();
            reader.close();
            clientSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
