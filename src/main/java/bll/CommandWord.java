package bll;

public enum CommandWord {
    GO("go"), DROP("drop"), PICKUP("pickup"),
    EAT("eat"), QUIT("quit"), HELP("help"),
    LOOK("look"), SEARCH("search"), BACK("back"),
    USE("use"),UNKNOWN(null);

    private String commandString;

    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    @Override
    public String toString() {
        return commandString;
    }
}
