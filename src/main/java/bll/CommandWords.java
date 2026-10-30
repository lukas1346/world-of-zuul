package bll;

import java.util.HashMap;

/**
 * This class is part of the "World of gui.Zuul" application.
 * "World of gui.Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    private static HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }


    public void showAll()
    {
        for(String key : validCommands.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    public CommandWord getCommand(String aString) {
        if(aString != null) {
            for (CommandWord key : validCommands.values()) {
                if (key.toString().equals(aString.trim().toLowerCase())) {
                    return key;
                }
            }
        }
        return CommandWord.UNKNOWN;
    }
}
