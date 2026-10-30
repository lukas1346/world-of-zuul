package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class UnknownCommand implements GameAction {

    private final Game game;

    public UnknownCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        System.out.println("Unknown command.");
    }
}