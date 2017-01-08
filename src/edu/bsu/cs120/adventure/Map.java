package edu.bsu.cs120.adventure;
import java.util.LinkedList;
/**
 * A list of locations in the game world.
 * @author Uroscion
 * @author mfleming
 *
 */
public class Map extends LinkedList<Location> {
    static final long serialVersionUID = 0000000004;

    /*private List<Location> locations = new LinkedList<Location>();*/

/**
 * Adds a bunch of pre-defined locations to the game world.  (Also adds a 
 * couple of items to some locations.)
 */    
public Map(){
    //Adds eight locations to the game world.
    this.add(new Location(
                    "Parking Lot",
                    "You are standing in a parking lot.  You are surrounded " +
                    "by cars of all makes and sizes.  The bus stands behind " +
                    "you.  The door to the bus is locked and the bus driver " +
                    "is gone.  To the north you see a picnic shelter, to the" +
                    " west you see a pavilion.  To the south you see the" +
                    " visitor center.", "You are standing in Mounds State Park" +
                    " with the cars. "));
    this.add(new Location(
                    "Visitor Center",
                    "You are in the Visitor Center.  All around you are " +
                    "educational exhibits and ranger offices.  You see a " +
                    "bird-watcher's room as well. To the north is the " +
                    "parking lot.  To the west you see a large mound of dirt.",
                    "You are in the Visitor Center."));
    this.add(new Location(
                    "The Great Mound",
                    "You see a large toroidal mound in front of you.  You " +
                    "wonder what toroidal means as you gaze upon it.  To the " +
                    "east lies the Visitor Center, to the west you see" + 
                    "another mound of dirt resembling a figure eight.  " +
                    "Interesting...  To the north is a raised wooden walkway " +
                    "over a creek.",
                    "You are at the Great Toroidal Mound.  It is essentially " +
                    "a large lump of dirt. "));
    this.add(new Location(
                    "Boardwalk",
                    "You are standing on a raised wooden walkway over a " +
                    "small, lazy creek.  The water flows swiftly below your" +
                    " feet.  To the south lies the Great Mound, and to the " +
                    "north is a pavilion.",
                    "You are standing on a boardwalk over a creek."));
    this.add(new Location(
                    "White River Riverbed",
                    "You are standing on the banks of a dirty, brown river.  " +
                    "All about you are stones and clumps of mud.  You see a " +
                    "muddy boot sticking out of a pile of sticks to your " +
                    "left.  There are several duck's floating on the river.  " +
                    "To the east is a pavilion.  To the south is a " +
                    "figure-eight shaped mound.",
                    "You are standing next to the white river."));
    this.add(new Location(
                    "Fiddle Back Mound",
                    "You are standing near a large, figure-eight shaped " +
                    "mound.  Standing here you can almost hear drums in the" +
                    " distance and feel the presence of ghostly warriors." + 
                    "you shiver slightly with the power and mystery of " +
                    "this place.  To the north is a river, to the east a " +
                    "great mound.",
                    "You are standing" + "near the fiddle-back mound."));
    this.add(new Location(
                    "Pavilion",
                    "You are standing beneath a medium sized pavilion.  You" +
                    " are unsure of the exact purpose of this pavilion or " +
                    "even of its general shape.  Things seem to be rather " +
                    "fuzzy and out of focus here.  Perhaps the mystical " +
                    "spirits of the mounds are confusing your senses. You " +
                    "sense something is out of place here. You cannot tell " +
                    "which direction you're looking in anymore.",
                    "You're not sure where you are, but your instincts" +
                    " tell you it is a pavilion."));
    this.add(new Location(
                    "Locust Grove Shelter",
                    "You are standing in a picnic shelter, surrounded by " +
                    "picnic tables.  There is grafitti on the tables and a" +
                    "piece of dried gum beneath a bench.  You see a pop-can" +
                    " left on the cement to your right.  All around the " +
                    "shelther are locust trees.  You can see the parking lot " +
                    "to the south, but hedges block your view in all other " +
                    "directions.",
                    "You are in a picnic shelter north of the parking lot."));
    //Adds all the items to the game world.
   
    this.get(1).addToLocation(new Item("pamphlet", "The Pamphlet says: \n Mounds State Park, " +
            "features 10 unique 'earthworks' built " +
                    "by a group of prehistoric Indians known as the " +
                    "Adena-Hopewell people. The largest earthwork, the " +
                    "'Great Mound', is believed to have been constructed around " +
                    "160 B.C. Archaeological surveys seem to indicate it was " +
                    "used as a gathering place for religious ceremonies. Be sure " +
                    "to include time to visit the new Nature Center. The new " +
                    "building includes a bird viewing room, small animal displays " +
                    "and much more. (Information found online on 12/04/06 at " +
                    "http://www.in.gov/dnr/parklake/properties/park_mounds.html)"));
    this.get(6).addToLocation(new RenewableItem("chestnuts", "A small, hard nut."));
    this.get(3).addToLocation(new RenewableItem("Maple leaf", "Red, of the Sugar-Maple"));
    this.get(4).addToLocation(new Item("boot", "An old muddy boot."));
    this.get(7).addToLocation(new Item("gum", "Some ABC gum..."));
    this.get(7).addToLocation(new Item("empty pop-can", "It was pepsi, now its rather rusty."));
    this.get(((int)((Math.random()* 6) + 2))).addToLocation(new Item("feather", "A red Cardinal feather."));
    this.get(0).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(2).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(3).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(5).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(6).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(7).addToLocation(new RenewableItem("rocks", "A rough, unpolished rock."));
    this.get(4).addToLocation(new RenewableItem("smooth rocks", "A round, smooth, river rock."));
    this.get(6).addToLocation(new Item("King Graham's crown", "A shiny crown from a King's Quest, long long ago."));
    
}

/**
 * Given a current location and a direction, determines what location a 
 * character will move to.  If the character cannot move in the specified
 * direction, returns the current location.
 * @param direction
 *          The direction the character would like to move.
 * @param currentLocation
 *          The current location of the character.
 * @return
 *          The location the character will move to.
 */  
public Location goTo(String direction, Location currentLocation)
{
    if (currentLocation.name().equalsIgnoreCase("Parking Lot"))
    {
        if (direction.equalsIgnoreCase("n")) return this.get(7);
        if (direction.equalsIgnoreCase("w")) return this.get(6);
        if (direction.equalsIgnoreCase("s")) return this.get(1);
        else return currentLocation;
    }
    else if (currentLocation.name().equalsIgnoreCase("Visitor Center"))
    {
        if (direction.equalsIgnoreCase("n")) return this.get(0);
        if (direction.equalsIgnoreCase("w")) return this.get(2);
        else return currentLocation; 
    }
    else if (currentLocation.name().equalsIgnoreCase("The Great Mound"))
    {
        if (direction.equalsIgnoreCase("n")) return this.get(3);
        if (direction.equalsIgnoreCase("w")) return this.get(5);
        if (direction.equalsIgnoreCase("e")) return this.get(1);
        else return currentLocation; 
    }
    else if (currentLocation.name().equalsIgnoreCase("Boardwalk"))
    {
        if (direction.equalsIgnoreCase("n")) return this.get(6);
        if (direction.equalsIgnoreCase("s")) return this.get(2);
        else return currentLocation; 
    }
    else if (currentLocation.name().equalsIgnoreCase("White River Riverbed"))
    {
        if (direction.equalsIgnoreCase("e")) return this.get(6);
        if (direction.equalsIgnoreCase("s")) return this.get(5);
        else return currentLocation; 
    }
    else if (currentLocation.name().equalsIgnoreCase("Fiddle Back Mound"))
    {
        if (direction.equalsIgnoreCase("n")) return this.get(4);
        if (direction.equalsIgnoreCase("e")) return this.get(2);
        else return currentLocation; 
    }
    else if (currentLocation.name().equalsIgnoreCase("Pavilion"))
    {
        if (direction.equalsIgnoreCase("w")) return this.get(4);
        if (direction.equalsIgnoreCase("s")) return this.get(3);
        if (direction.equalsIgnoreCase("e")) return this.get(0);
        else return currentLocation; 
    }
    else /*(currentLocation.name()== "Locust Grove Shelter")*/
    {
        if (direction.equalsIgnoreCase("s")) return this.get(0);
        else return currentLocation; 
    }
}

}
