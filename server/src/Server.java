import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6500);
            int count = 0;

            while (true){
                Socket clientSocket = serverSocket.accept();

                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(clientSocket.getOutputStream()));


                BufferedReader reader =
                        new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String request = reader.readLine();
                writer.write("Client # " + (count++) + " ur msg is  " +
                        request + " and len of ur msg is " + request.length());
                writer.newLine();
                writer.flush();


                writer.close();
                reader.close();
                clientSocket.close();
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
