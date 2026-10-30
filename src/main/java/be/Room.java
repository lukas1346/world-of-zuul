package be;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Class be.Room - a room in an adventure game.
 *
 * This class is part of the "World of gui.Zuul" application.
 * "World of gui.Zuul" is a very simple, text based adventure game.
 *
 * A "be.Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Item item;
    private List<Item> items;

        /**
         * Create a room described "description". Initially, it has
         * no exits. "description" is something like "a kitchen" or
         * "an open court yard".
         * @param description The room's description.
         */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getItemDescription() {
        if (items.isEmpty()) {
            return "Nothing found.";
        }

        StringBuilder roomDescription = new StringBuilder();
        for(Item i : items) {
            roomDescription.append(i.getItemDescription()).append("\n");
        }
        return String.valueOf(roomDescription);
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    public String getExitString() {
        String returnString = "Exits: ";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void addItem(Item item) {
        assert items != null;
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        return getLongDescription();
    }
}
