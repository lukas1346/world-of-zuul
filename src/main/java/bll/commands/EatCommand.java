package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class EatCommand implements GameAction {

    private final Game game;

    public EatCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Eat what?");
            return;
        }

        String item = command.getSecondWord();
        System.out.println(game.getProtagonist().eat(item));
    }
}
