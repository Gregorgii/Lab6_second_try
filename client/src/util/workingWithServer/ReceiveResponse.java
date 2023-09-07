package util.workingWithServer;


import util.Response;

import java.io.IOException;

public final class ReceiveResponse {
    private ReceiveResponse() {
    }

    public static void receiveResponse(ClientSocketWorker clientSocketWorker) {
        try {
            Response response = null;
            for (int i = 0; i < 50 && response == null; i++) {
                try {
                    System.out.println("Waiting answer from server...");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                response = clientSocketWorker.receiveResponse();
            }
            if (response == null) {
                System.out.println("Server time out");
                return;
            }
            System.out.println(response);
        } catch (IOException e) {
            System.out.println(("Something went wrong at getting info from server"));
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(("Incorrect answer from server"));
        }
    }
}
