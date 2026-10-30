package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class DropCommand implements GameAction {

    private final Game game;

    public DropCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Drop what?");
            return;
        }
        String item = command.getSecondWord();
        System.out.println(game.getProtagonist().dropItem(item));
    }
}