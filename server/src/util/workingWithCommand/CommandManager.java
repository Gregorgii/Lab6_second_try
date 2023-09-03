package util.workingWithCommand;

import com.sun.net.httpserver.Request;

import java.time.format.DateTimeFormatter;

public class CommandManager {
    private static boolean statusOfCommandListening = true;
    private final AvailableCommands availableCommands;


    public CommandManager(CollectionManager collectionManager) {
        availableCommands = new AvailableCommands(collectionManager);
    }

    public Response executeClientCommand(Request request) {
        commandHistory.pushCommand(request.getCurrentTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                + " " + request.getClientInfo() + ": " + request.getCommandName());
        return AvailableCommands.CLIENT_AVAILABLE_COMMANDS.get(request.getCommandName()).executeCommand(request);
    }

    public String executeServerCommand(String commandName) {
        if (AvailableCommands.SERVER_AVAILABLE_COMMANDS.containsKey(commandName)) {
            return AvailableCommands.SERVER_AVAILABLE_COMMANDS.get(commandName).executeCommand();
        } else {
            return ("Command isn't exist, print HELP to see available commands");
        }
    }

    public static void changeStatus() {
        statusOfCommandListening = !statusOfCommandListening;
    }

    public boolean getStatusOfCommandListening() {
        return statusOfCommandListening;
    }

    public static void setStatusOfCommandListening(boolean statusOfCommandListening) {
        CommandManager.statusOfCommandListening = statusOfCommandListening;
    }


    public static boolean isStatusOfCommandListening() {
        return statusOfCommandListening;
    }

    public AvailableCommands getAvailableCommands() {
        return availableCommands;
    }
}

