package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class LookCommand implements GameAction {

    private final Game game;

    public LookCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        System.out.println(game.getProtagonist().getCurrentRoom().getLongDescription());
    }
}