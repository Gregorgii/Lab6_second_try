import things.StudyGroup;
import util.workingWithServer.ClientSocketWorker;

import java.util.Scanner;

public class Client {
    public void startClient() {
        try (Scanner scanner = new Scanner(System.in)) {
            GeneratorClientSocketWorker generatorClientSocketWorker = new GeneratorClientSocketWorker(scanner);
            ClientSocketWorker clientSocketWorker = generatorClientSocketWorker.getClientSocketWorker();
            StudyGroup.getStudyGroupGenerator().changeCondition(new Console);
            CommandManager.runConsoleCycle(scanner, clientSocketWorker);
        }
    }
}
