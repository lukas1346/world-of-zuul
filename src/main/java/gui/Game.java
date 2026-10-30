package gui;

import be.EdibleItem;
import be.Item;
import be.Player;
import be.Room;
import bll.Command;
import bll.CommandExecutor;
import bll.CommandWord;
import bll.Parser;

import java.util.HashMap;
import java.util.Stack;

/**
 *  This class is the main class of the "World of gui.Zuul" application.
 *  "World of gui.Zuul" is a very simple, text based adventure game.  Users
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Player protagonist;
    private Stack<Room> previousRooms = new Stack<>();
    boolean wantToQuit = false;
    private CommandExecutor commandExecutor;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        commandExecutor = new CommandExecutor(this);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, cellar, attic;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        cellar = new Room("You are in a dim cellar");
        attic = new Room("The ladder broke while you climbed up, you need another way to leave.");

        theater.addItem(new Item("Beans","A can of beans.", 0.5));
        pub.addItem(new Item("Beer", "It looks old", 0.5));
        lab.addItem(new EdibleItem("Rat","A dead rat.", 2, 50));
        lab.addItem(new Item("Beamer", "A weird look gun", 2));
        office.addItem(new Item("Lighter","A working lighter.", 0.1));
        office.addItem(new Item("Broken glasses", "A broken pair of glasses.", 0.2));
        attic.addItem(new Item("Rope", "5 meters of sturdy rope.", 4));


        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("down", cellar);
        office.setExit("west", lab);
        office.setExit("up", attic);
        cellar.setExit("up", lab);

        Room currentRoom = outside;  // start game outside
        protagonist = new Player(currentRoom, 2, 100);

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of gui.Zuul!");
        System.out.println("World of gui.Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP.toString() + "' if you need help.");
        System.out.println();
        System.out.println(protagonist.getCurrentRoom().getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        protagonist.reduceTurnsLeft();
        System.out.println("Turns left: " + protagonist.getTurnsLeft());
        commandExecutor.execute(command);
        return wantToQuit;
    }

    public Parser getParser() {
        return parser;
    }


    public Player getProtagonist() {
        return protagonist;
    }

    public Stack<Room> getPreviousRooms() {
        return previousRooms;
    }

    public void setWantToQuit(boolean wantToQuit) {
        this.wantToQuit = wantToQuit;
    }
}
