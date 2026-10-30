package bll.commands;

import bll.Command;
import bll.GameAction;
import gui.Game;

public class QuitCommand implements GameAction {

    private final Game game;

    public QuitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return;
        }

        game.setWantToQuit(true);
    }
}