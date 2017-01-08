package edu.bsu.cs120.adventure;

import javax.swing.JFrame;

import edu.bsu.cs120.adventure.gui.ConsoleEmulator;
/**
 * A text-based adventure set in Mounds State Park.
 * @author uroscion
 * @author mfleming
 *
 */
public class ColossalMoundsAdventureGame implements TextAdventure {
    /** A map of the game world. */
    private Map gameMap = new Map();

    /** The player's character in the game. */
    private Hero hero;

    /**
     * Constructs a new game and creates the player's avatar.
     */
    public ColossalMoundsAdventureGame() {
        this.hero = new Hero("currently not known to you", gameMap.get(0));
    }

    /*---------------------------------Methods-----------------------------*/

    /** Indicates if the game is over or not */
    private boolean gameOver = false;

    /**
     * Get the welcome message from this adventure game.
     * 
     * @return welcome message
     */
    public String getWelcomeMessage() {
        //welcomes the player to the game and describes their current location
        return "Welcome to the Colossal Mounds Adventure Game!\n" + "\n"
                + gameMap.get(0).describeOnEntrance();
    }

    /**
     * Get the command prompt. This is used to prompt the player for a command.
     * A common prompt is "Command >" or simply "> ".
     * 
     * @return prompt
     */
    public String getPrompt() {
        return "\n Your command>";
    }

    /**
     * Execute a command.
     * 
     * @param cmd
     *            the command, a single string
     * @return the message that should be shown to the client upon termination
     *         of the command.
     */
    public String execute(String cmd) {
        //allows user to exit game
        if (cmd.equalsIgnoreCase("exit")) {
            gameOver = true;
            //if score is fifty and exit from parking lot, say player won
            if(hero.currentLocation().name().equalsIgnoreCase("Parking Lot")
                    && hero.score() == 50)
                {return "Congratulations!  You were the first to return with" +
                        " all of the required items.  You've won the" +
                        " scavenger hunt with a total of 60 points!";}
            //if not say player didn't win
            return "In the game of life, there are no such things as winners "
                    + "and losers.";
        //displays a helpful list of recognized commands
        } else if (cmd.equalsIgnoreCase("help")) {
            return "n - move north \n" + "s - move south \n"
                    + "e - move east \n" + "w - move west \n" +
                    // "get (item) - pick up item \n" +
                    "look - repeat long form of location description \n"
                    + "exploreSelf - learn more about yourself \n"
                    + "setName (name) - change your character's name \n"
                    + "inventory - see your inventory \n"
                    + "examine (item name) - take a close look at items in your inventory \n"
                    + "take (item name) - pick up an item that is present \n"
                    + "score - check your current game score. \n"
                    + "help - list these helpful commands again \n"
                    + "exit - terminate the game \n";

        //allows the character to move between locations    
        } else if (cmd.equalsIgnoreCase("n") || cmd.equalsIgnoreCase("s")
                || cmd.equalsIgnoreCase("e") || cmd.equalsIgnoreCase("w")) {
            if (hero.currentLocation() != hero.changeLocation(gameMap.goTo(cmd
                    .toString(), (hero.currentLocation())))) {
                return (hero.currentLocation().describeOnEntrance());
            } else
                return "There is a hedge obstructing your path. \n";

        //repeats the long form of a location description    
        } else if (cmd.equalsIgnoreCase("look")) {
            return hero.currentLocation().describeInFull();

        //provides a description of the character
        } else if (cmd.equalsIgnoreCase("exploreSelf")){
            return hero.describeHero() + "\n";
        
            //list inventory item
        } else if (cmd.equalsIgnoreCase("inventory")){
            return hero.listInventory();
            
        //sets the player's avatar's name
        } else if (cmd.startsWith("setName")){
            hero.setName(cmd.substring(8));
            return hero.describeHero() + "\n";
            
            //describe items in inventory
        } else if (cmd.startsWith("examine")){
            return hero.examineItem(cmd.substring(8)) + "\n";
        //give score
        }else if (cmd.equalsIgnoreCase("score")){
            return "You have " + hero.score() + " points.\n";
         
            //take items
        } else if (cmd.startsWith("take")){
            
            //if hero has it already say so
            if (hero.listInventory().contains((cmd.substring(5))))
                    return "You already have that in your inventory.\n";
            //if hero doesn't have item, check to see if the item is at location
            else if (hero.currentLocation().isItemHere(cmd.substring(5)) != null)
            {
                //if so take it
             String tempItemString = hero.currentLocation().isItemHere(cmd.substring(5)).name();
             hero.currentLocation().isItemHere(cmd.substring(5)).take(hero);
             //if the hero's score is fifty now with the new item, tell them so
             if (hero.score() == 50)
             {
                 return "You picked up " + tempItemString + ".\n" +
                 "You have collected all of the required items.  Please " +
                 "return to the parking lot and exit the game to win.\n";
             }
             //if score not fifty, just say they picked it up
             else return "You picked up " + tempItemString + ".\n";
            }
            //if the item's not there, say so
            else return "There is no " + cmd.substring(5) + " here. \n";
            
        //if the command isn't recognized, this tells the player to type 'help'  
        } else
            return "Type 'help' for a list of useful commands.\n";

    }

    /**
     * Checks to see if the game is over.
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Run the sample game.
     * 
     * @param args
     *            ignored
     */
    public static void main(String[] args) {
        TextAdventure game = new ColossalMoundsAdventureGame();
        JFrame frame = new JFrame("Colossal Mounds Adventure Game");
        ConsoleEmulator console = new ConsoleEmulator(game);
        frame.getContentPane().add(console);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

}
