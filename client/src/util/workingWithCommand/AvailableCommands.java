package util.workingWithCommand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AvailableCommands {

    public static final Set<String> COMMANDS_WITHOUT_ARGS = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_ID_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_STUDY_GROUP_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_STUDY_GROUP_AND_ID_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_TRANSFERRED_ARG = new HashSet<>();
    public static final Set<String> COMMANDS_WITH_EXPELLED_ARG = new HashSet<>();


    static {
        Collections.addAll(
                COMMANDS_WITHOUT_ARGS,
                "help",
                "info",
                "show",
                "clear",
                "exit",
                "remove first",
                "print field descending semester");
        Collections.addAll(COMMANDS_WITH_STUDY_GROUP_ARG,
                "add",
                "remove greater",
                "add if max");
        Collections.addAll(COMMANDS_WITH_ID_ARG,
                "remove by id");
        Collections.addAll(COMMANDS_WITH_STUDY_GROUP_AND_ID_ARG,
                "update");
        Collections.addAll(COMMANDS_WITH_TRANSFERRED_ARG,
                "count greater than transferred");
        Collections.addAll(COMMANDS_WITH_EXPELLED_ARG,
                "remove any by should be expelled");

    }

    private AvailableCommands(){
    }
}
