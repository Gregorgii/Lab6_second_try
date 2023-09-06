package commands.clientCommands;

import com.sun.net.httpserver.Request;
import managers.CollectionManager;


public class AddCommand extends AbstractClientCommand {
    private final CollectionManager collectionManager;


    public AddCommand(CollectionManager collectionManager) {
        super(new AbstractCommandBuilder()
                .withName("add")
                .withQuantityOfArgs(0)
                .withDescription("Add new elem to collection")
                .withGeneratesStudentGroup(true));
        this.collectionManager = collectionManager;
    }

    @Override
    public Response executeCommand(Request request){
        return new Respose(new ResponseBuilder)
    }

}