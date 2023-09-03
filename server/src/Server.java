import managers.CollectionManager;
import util.ServerApplication;
import util.workingWithClient.GeneratorServerSocketWorker;
import util.workingWithClient.ServerSocketWorker;
import util.workingWithCommand.ServerCommandListener;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Server {
    private final String fileName;
    private final ServerCommandListener serverCommandListener = new ServerCommandListener();
    public Server(String fileName){ this.fileName = fileName; }

    public void startServer() throws IOException {
        try{
            CollectionManager collectionManager = new CollectionManager(Path.of(fileName));
            collectionManager.fillCollectionFromFile();
            Scanner scanner = new Scanner(System.in);
            GeneratorServerSocketWorker generatorServerSocketWorker = new GeneratorServerSocketWorker(scanner);
            ServerSocketWorker serverSocketWorker = generatorServerSocketWorker.getServerSocketWorker();
            ServerApplication serverApplication = new ServerApplication(serverSocketWorker, )




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
