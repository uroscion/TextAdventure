package edu.bsu.cs120.adventure;

import java.util.LinkedList;
import java.util.List;

/**
 * A location in the game.
 * 
 * @author Uroscion
 * @author mfleming
 * 
 */
public class Location {
    /**The name of the location*/
    private String name;

    /**A long description of the location*/
    private String descriptionLong;

    /**A brief description of the location*/
    private String descriptionShort;

    /**A list of items present of this location.*/
    private List<Item> itemsAtLocation = new LinkedList<Item>();

    /**A sentinel variable that checks to see if the character has been
     * to this location before. */
    private boolean hasBeenHere = false;

    /*------------------------Constructor----------------------------------------*/
    /**
     * Creates a new location.
     * @param name
     *      The name of the location.
     * @param dLong
     *      A long description of the location.
     * @param sLong
     *      A brief description of the location.
     *      
     */
    public Location(String name, String dLong, String dShort) {
        this.name = name;
        this.descriptionLong = dLong;
        this.descriptionShort = dShort;
    }

    /*-----------------------Methods---------------------------------------------*/
    /**
     * Returns the name of the location.
     * @return
     *      Returns the name of the location.
     */
    public String name() {
        return name;
    }

    /**
     * Returns the description a character receives the first time the character
     * enters a location.
     * @return
     *      The long description of the location.
     */
    public String describeOnEntrance() {
        if (hasBeenHere == false) {
            hasBeenHere = true;
            return describeInFull();
        } else
            return name + "\n";

    }

    /**
     * Returns the long description of the location.
     * @return
     *      The long description of the location.
     */
    public String describeInFull() {
        if (itemsAtLocation.size() > 0)
        {
        String listOfItems = "";
        
        for (int i = 0; i<itemsAtLocation.size(); i++)
        {
            listOfItems = listOfItems.concat(itemsAtLocation.get(i).name()+ "\n");
               }
        
        return descriptionLong + "  There are these items here: \n" +
                "" + listOfItems;
        }
        else return descriptionLong;
    }

    /**
     * Returns the brief description of the location.
     * @return
     *      The brief description of the locations.
     */
    public String describeInShort() {
        return descriptionShort;
    }

    /**
     * Removes a given item from this location
     * @param item
     *      The item to be removed.
     */
    public void takeFromLocation(Item item) {
        itemsAtLocation.remove(item);
    }

    /**
     * Adds a given number of an item to this location
     * @param item
     *      The item to be added.
     * @param number
     *      The number of instances of the item to add.
     */
    public void addToLocation(Item item) {
           itemsAtLocation.add(item);
        }
    
    /**
     * Check to see if the given string of an item name is at the place, and if it is
     * return the Item so that the Colossal Mounds Adventure command processer can call the 
     * takeFromLocation() method and remove it.
     * @param itemName the string that the player typed in after the take command
     * @return the Item that matches the name
     */
    public Item isItemHere(String itemName)
            {
        //for every item here
                for (int i = 0; i < itemsAtLocation.size(); i++)
                   {
                    //see if the string itemName matches the item's name
                    if (itemsAtLocation.get(i).name().equals(itemName))
                       return itemsAtLocation.get(i);
                    }
                //if not, return null.
                return null;
                
            }
    }

