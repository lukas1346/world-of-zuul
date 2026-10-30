package be;

public class EdibleItem extends Item{

    private int hungerRestore;
    public EdibleItem(String name, String description, double weight, int hungerRestore) {
        super(name, description, weight);
        this.hungerRestore = hungerRestore;
    }

    public int getHungerRestore() {
        return hungerRestore;
    }
}
