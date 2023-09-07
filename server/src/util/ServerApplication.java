package util;

import util.workingWithClient.ServerSocketWorker;
import util.workingWithCommand.CommandManager;

import java.io.IOException;

public class ServerApplication {
    private final ServerSocketWorker serverSocketWorker;
    private final CommandManager commandManager;

    public ServerApplication(ServerSocketWorker serverSocketWorker, CommandManager commandManager) {
        this.serverSocketWorker = serverSocketWorker;
        this.commandManager = commandManager;
    }

    public void start() {
        try {
            while (commandManager.getStatusOfCommandListening()) {
                Request acceptedRequest = serverSocketWorker.receiveRequest();
                Response responseToSend = commandManager.executeClientCommand(acceptedRequest);
                serverSocketWorker.sendResponse(responseToSend);
            }
        } catch ( IOException e) {
            System.out.println("Ошибка при обработке запроса от клиента");
        } catch (ClassNotFoundException e) {
            System.out.println("Пришел некорректный запрос от клиента");
        } finally {
            serverSocketWorker.stopServer();
        }
    }
}
