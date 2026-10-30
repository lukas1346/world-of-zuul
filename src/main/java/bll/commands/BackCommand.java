package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class BackCommand implements GameAction {

    private final Game game;

    public BackCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        if (game.getPreviousRooms().isEmpty()) {
            System.out.println("You cannot go back any further!");
            return;
        }

        game.getProtagonist().setCurrentRoom(
                game.getPreviousRooms().pop()
        );

        System.out.println(
                game.getProtagonist().getCurrentRoom().getLongDescription()
        );
    }
}