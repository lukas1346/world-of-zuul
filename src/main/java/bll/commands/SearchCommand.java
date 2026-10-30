package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class SearchCommand implements GameAction {

    private final Game game;

    public SearchCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        System.out.println(game.getProtagonist().getCurrentRoom().getItemDescription());
    }
}