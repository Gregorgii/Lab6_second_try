package commands.clientCommands;

public abstract class AbstractClientCommand {
    private final String name; // Имя
    private final int quantityOfArgs; // Количество аргументов
    private final String description; // Описание
    private final String descriptionOfArgs; // Описание аргументов
    private final boolean generatesStudentGroup;

    public AbstractClientCommand(AbstractCommandBuilder builder, boolean generatesStudentGroup) {
        this.name = builder.name;
        this.quantityOfArgs = builder.quantityOfArgs;
        this.description = builder.description;
        this.descriptionOfArgs = builder.descriptionOfArgs;
        this.generatesStudentGroup = generatesStudentGroup;
    }

    public abstract Response executeCommand(Request request);

    public String getName() {
        return name;
    }

    public int getQuantityOfArgs() {
        return quantityOfArgs;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionOfArgs() {
        return descriptionOfArgs;
    }
    public boolean getGeneratesStudentGroup() { return generatesStudentGroup;}

    @Override
    public String toString() {
        if (quantityOfArgs == 0) {
            return name + " - " + description;
        } else {
            return name + " - " + description
                    + "\n     Arguments: " + descriptionOfArgs;
        }
    }

    public static class AbstractCommandBuilder {
        private String name; // Имя
        private int quantityOfArgs; // Количество аргументов
        private String description; // Описание
        private String descriptionOfArgs = ""; // Описание аргументов

        public AbstractCommandBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AbstractCommandBuilder withQuantityOfArgs(int quantityOfArgs) {
            this.quantityOfArgs = quantityOfArgs;
            return this;
        }

        public AbstractCommandBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public AbstractCommandBuilder withDescriptionOfArgs(String descriptionOfArgs) {
            this.descriptionOfArgs = descriptionOfArgs;
            return this;
        }

        public AbstractCommandBuilder withGeneratesStudentGroup(boolean generatesStudentGroup) {
            return this;
        }
    }
}
