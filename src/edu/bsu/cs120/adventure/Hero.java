package edu.bsu.cs120.adventure;

import java.util.LinkedList;
import java.util.List;

/**
 * Any character in the game.
 * 
 * @author Uroscion
 * @author mfleming
 * 
 */
public class Hero {
    /*----------------Member--Variables--------------------------------------*/
    /** Stores the name of the character */
    private String name;

    // private String gender;

    /** A list of items currently held by the character */
    private List<Item> inventory = new LinkedList<Item>();

    /** The current location of the character */
    private Location currentLocation;

    /*---------------Constructor--------------------------------------------*/

    /**
     * Constructs a new hero
     * @param name
     *          The name of the character.
     * @param location
     *          The beginning location of the character
     *          
     */
    public Hero(String name, /* String gender, */Location location) {
        this.name = name;
        // this.gender = gender;
        this.currentLocation = location;
    }

    /*----------------Methods----------------------------------------------*/
    
    /**
     * Returns the name of the character
     */
    public String name() {
        return name;
    }

    /**
     * Desribes the character.
     * @return
     *      The description of the character.
     */
    public String describeHero() {
        return "Your name is " + name + ".  You are a suave and debonair "
                + "adventurer.  " + currentLocation.describeInShort();
    }

    /**
     * Reports the character's current location.
     * @return
     *      The character's current location.
     */
    public Location currentLocation() {
        return currentLocation;
    }

    /**
     * Registers that the character has changed location.
     * @param location
     *          The new location.
     * @return
     *          The new current location.
     */
    public Location changeLocation(Location location) {
        this.currentLocation = location;
        return currentLocation;
    }

    /**
     * Adds an item to the character's inventory.
     * @param item
     *      The item to be added.
     */
    public void addToInventory(Item item) {
              inventory.add(item);
       }

    /**
     * Allows the character to drop an item at a specific location.
     * @param item
     *      The item to be dropped.
     */
    public void drop(Item item) {
        currentLocation.addToLocation(item);
        inventory.remove(item);
    }

    /**
     * Sets the name of the character.
     * @param name
     *       The new name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * List the items in the player's inventory.
     * @return descriptions of the inventory
     */
    public String listInventory()
    {
        String listOfItems = "";
        if (inventory.size()>0)
        {
        for (int i = 0; i<inventory.size(); i++)
        {
            listOfItems = listOfItems.concat(inventory.get(i).name()+ "\n");
               }
        return "You have these items in your Inventory: \n" + listOfItems;
        }
        else return "You have nothing in your Inventory. \n";
    }
    
    /**
     * Checks to see if the given name of an item is in the players inventory
     * @param s
     * @return the description of the item or say its not in the inventory
     */
    public String examineItem(String s)
    {
        //for every thing in the inventory
        for (int i = 0; i < inventory.size(); i++)
        {
            //if the string name equals the name of the item, return its description
         if (inventory.get(i).name().equals(s))
            return inventory.get(i).describe();
         }
     return "That is not in your inventory!";
     
    }
    
    /**
     * Check to see if the required items are in the inventory and give points for 
     * each.  This is called when a player picks things up and when they exit the game.
     * @return an int of the points added.
     */
    public int score(){
        int score = 0;
        //for each item in the inventory, see if it is any of the listed things.
        for (int i = 0; i < inventory.size(); i++)
        {
         if (inventory.get(i).name().equals("pamphlet"))
             score += 10;
         else if (inventory.get(i).name().equals("smooth rocks"))
             score += 10;
         else if (inventory.get(i).name().equals("chestnuts"))
             score += 10;
         else if (inventory.get(i).name().equals("feather"))
             score += 10;
         else if (inventory.get(i).name().equals("Maple leaf"))
             score += 10;
         }
        return score;
    }
    

}
