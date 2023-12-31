package util.workingWithCommand;

import commands.ExecuteScriptCommand;
import commands.ExitCommand;
import util.workingWithServer.ClientSocketWorker;
import util.workingWithServer.ReceiveResponse;
import util.workingWithServer.SendRequest;

import java.util.Locale;
import java.util.Scanner;

public final class CommandManager {
    private static final CommandListener COMMAND_LISTENER = new CommandListener();
    private static boolean statusOfCommandListening = true;

    private CommandManager() {
    }

    public static void runConsoleCycle(Scanner scanner, ClientSocketWorker clientSocketWorker) {
        while (statusOfCommandListening) {
            CommandToSend command = COMMAND_LISTENER.readCommandFromConsole(scanner);
            performCommand(command, clientSocketWorker);
        }
    }

    public static void performCommand(CommandToSend command, ClientSocketWorker clientSocketWorker) {
        String name = command.getCommandName();
        if ("exit".equals(command.getCommandName().toLowerCase(Locale.ROOT))) {
            ExitCommand.executeCommand(command.getCommandArgs());
        } else if ("execute_script".equals(command.getCommandName())) {
            ExecuteScriptCommand.executeCommand(command.getCommandArgs(), clientSocketWorker);
        } else if (SendRequest.sendRequest(command, clientSocketWorker)) {
            ReceiveResponse.receiveResponse(clientSocketWorker);
        }
    }

    public static void changeStatus() {
        statusOfCommandListening = !statusOfCommandListening;
    }

    public static CommandListener getCommandListener() {
        return COMMAND_LISTENER;
    }
}