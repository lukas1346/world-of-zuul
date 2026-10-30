package be;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private double carryLimit;
    private List<Item> inventory;
    private Room currentRoom;
    private double currentCarryWeight = 0;
    private int turnsLeft;

    public Player(Room currentRoom, double carryLimit, int turnsLeft) {
        this.currentRoom = currentRoom;
        this.carryLimit = carryLimit;
        inventory = new ArrayList<>();
        this.turnsLeft = turnsLeft;
    }

    public void increaseCarryLimit(double amount) {
        carryLimit = carryLimit + amount;
    }

    public String eat(String itemName) {
        for(Item i : inventory) {
            if(i.getName().equals(itemName) && i instanceof EdibleItem) {
                double weight = i.getWeight();
                currentCarryWeight = currentCarryWeight-weight;
                increaseCarryLimit(weight);
                turnsLeft = turnsLeft + ((EdibleItem) i).getHungerRestore();
                String name = i.getName();
                inventory.remove(i);
                return "You ate " + name + ", you feel more powerful.";
            }
        }
        return "What?";
    }

    public String use(String itemName) {
        for(Item i : inventory) {
            if(i.getName().equals(itemName) && i.getName().equals("Beamer")) {
                Room PlaceholdercurrentRoom = i.getCurrentRoom();
                if(PlaceholdercurrentRoom == null) {
                    i.setCurrentRoom(currentRoom);
                    return "The beamer made a strange noise";
                }
                else {
                    setCurrentRoom(PlaceholdercurrentRoom);
                    return "Teleported: " + PlaceholdercurrentRoom + ". You feel unwell now.";
                }
            }
        }
        return "What?";
    }


    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void reduceTurnsLeft() {
        turnsLeft = turnsLeft-1;
    }

    public String dropItem(String itemName) {
        for(Item i : inventory) {
            if(i.getName().equals(itemName)) {
                if(inventory.contains(i)) {
                    double weight = i.getWeight();
                    currentCarryWeight = currentCarryWeight-weight;
                    currentRoom.addItem(i);
                    String name = i.getName();
                    inventory.remove(i);
                    return name + " has been dropped.";
                }
            }
        }
        return "You don't have that item buddy.";
    }

    public String pickUpItem(String itemName) {
        List<Item> roomItems = currentRoom.getItems();
        for(Item i : roomItems) {
            if(i.getName().equals(itemName)) {
                double weight = i.getWeight();
                if((weight + currentCarryWeight)>carryLimit) {
                    return "be.Item is too heavy to pick up.";
                }
                currentCarryWeight = currentCarryWeight+weight;
                inventory.add(i);
                String name = i.getName();
                currentRoom.removeItem(i);
                return name + " picked up.";
            }
        }
        return "You picked up nothing.";
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
