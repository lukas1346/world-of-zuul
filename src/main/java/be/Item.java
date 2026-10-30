package be;

public class Item {
    private String name;
    private String description;
    private double weight;
    private Room currentRoom = null;

    public Item(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }


    public String getItemDescription() {
        return name + ": " +description + " Weight: " + weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        Room placeholder = currentRoom;
        currentRoom = null;
        return placeholder;
    }
}
