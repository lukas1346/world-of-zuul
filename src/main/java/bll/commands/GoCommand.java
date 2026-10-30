package bll.commands;

import be.Room;
import bll.Command;
import bll.GameAction;
import gui.Game;

public class GoCommand implements GameAction {

    private final Game game;

    public GoCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = game.getProtagonist()
                .getCurrentRoom()
                .getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            game.getPreviousRooms().push(
                    game.getProtagonist().getCurrentRoom()
            );

            game.getProtagonist().setCurrentRoom(nextRoom);

            System.out.println(nextRoom.getLongDescription());
        }
    }
}
