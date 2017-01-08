package edu.bsu.cs120.adventure;
/**
 * This is the renewable item class that extends Item, inheriting all of item's 
 * methods, but overrides the take method to not remove it from the location, so 
 * renewable items are always there.
 * 
 * @author Uroscion
 * @author mfleming
 *
 */
public class RenewableItem extends Item {
    
    
    /**
     * Contsructor
     * @param name takes a name as a String
     * @param description takes a description as a String
     */
    public RenewableItem(String name, String description)
    {
        super(name, description);
    }
    /**
     * This is the implementation for an item to take itself and give it to
     * a hero h
     * @param h the Hero that will add this item to its inventory
     */
    public void take(Hero h) {
        h.addToInventory(this);
        
}
}
