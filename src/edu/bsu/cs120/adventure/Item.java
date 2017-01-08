package edu.bsu.cs120.adventure;

/**
 * An item in the game.
 * 
 * @author Uroscion
 * @author mfleming
 * 
 */
public class Item {

    /**The name of the item.*/
    private String name;

    /**A brief description of the item.*/
    private String description;

    /*-------------------Constructor---------------------------------------------*/
    /**
     * Creates an item.
     * @param name
     *     The name of the item.
     * @param description
     *      A brief description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /*------------------Methods--------------------------------------------------*/
    
    /**
     * Returns the name of the item.
     * @return
     *      The name of the item.
     *      
     */
    public String name() {
        return name;
    }

    /**
     * Returns a brief description of the item.
     * @return
     *      A brief description of the item.
     */
    public String describe() {
        return description;
    }

    /**
     * Allows a character to take an item from a location
     * @param h
     *      The character taking the item.
     * @param l
     *      The location containing the item.
     */
    public void take(Hero h) {
        h.addToInventory(this);
        h.currentLocation().takeFromLocation(this);
    }
}
