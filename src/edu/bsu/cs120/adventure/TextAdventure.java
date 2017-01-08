package edu.bsu.cs120.adventure;

/** Every game should have these abilities for input and execution
 * 
 * @author Uroscion, based on design by Paul Gestwicki
 */
public interface TextAdventure 
{
    /** Take in a string command, execute it and return a string response 
     * (to the ConsoleEmulator).
     * @param cmd the command to take in.          
     * @return the response message.
     */
    public String execute(String cmd);

    /** Get the  welcome response, each game should have a welcome message.
     * @return the welcome response
     */
    public String getWelcomeMessage();

    /** outputs a character to let the user know they are at a command prompt.
     * usually > or $.
     * 
     * @return the prompt string
     */
    public String getPrompt();

    /** Every game should know if it is running or over.
     * @return is game over or not.
     */
    public boolean isGameOver();
}