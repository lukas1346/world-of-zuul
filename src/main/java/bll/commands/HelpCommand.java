package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class HelpCommand implements GameAction {

    private final Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        game.getParser().showCommands();
    }
}