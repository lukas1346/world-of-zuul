package bll;

import bll.commands.*;
import gui.Game;

public class Commands {
    private final Game game;

    public Commands(Game game) {
        this.game = game;
    }

    public GameAction create(CommandWord word) {
        return switch (word) {
            case GO -> new GoCommand(game);
            case EAT -> new EatCommand(game);
            case PICKUP -> new PickupCommand(game);
            case DROP -> new DropCommand(game);
            case USE -> new UseCommand(game);
            case HELP -> new HelpCommand(game);
            case LOOK -> new LookCommand(game);
            case SEARCH -> new SearchCommand(game);
            case BACK -> new BackCommand(game);
            case QUIT -> new QuitCommand(game);
            case UNKNOWN -> new UnknownCommand(game);
        };
    }
}