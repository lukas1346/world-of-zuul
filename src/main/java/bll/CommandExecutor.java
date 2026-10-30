package bll;

import gui.Game;
import java.util.EnumMap;
import java.util.Map;

public class CommandExecutor {

    private final Map<CommandWord, GameAction> commandMap;

    public CommandExecutor(Game game) {
        Commands commands = new Commands(game);

        commandMap = new EnumMap<>(CommandWord.class);

        for (CommandWord word : CommandWord.values()) {
            GameAction action = commands.create(word);

            if (action != null) {
                commandMap.put(word, action);
            }
        }
    }

    public void execute(Command command) {
        GameAction action = commandMap.get(command.getCommandWord());

        if (action != null) {
            action.execute(command);
        }
    }
}