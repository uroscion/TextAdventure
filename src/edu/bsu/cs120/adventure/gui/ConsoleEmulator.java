package edu.bsu.cs120.adventure.gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.bsu.cs120.adventure.TextAdventure;

/** A GUI to emulate an old style console with an input textbox and a return 
 * textarea
 * @author Uroscion, based off of design by Paul Gestwicki.
 */
public class ConsoleEmulator extends JPanel 
{
    /** The command text field, where the player types. */
    private JTextField tbxPlayerEntry;

    /** The text area where output is described.*/
    private JTextArea responseTextArea;

    /** The particular set of rules and maps (adventure) being run.*/
    private TextAdventure adventure;

    /** Whether commands are echoed.*/
    private boolean commandEcho = true;

    /** Default constructor, takes in adventure to play.
     * @param adventure
     *            the adventure game object
     */
    public ConsoleEmulator(TextAdventure adventure) {
        this.adventure = adventure;
        buildGUI();
    }

    /** Create the GUI and display it.  */
    private void buildGUI() {
        tbxPlayerEntry = new JTextField();
        tbxPlayerEntry.requestFocusInWindow();
        responseTextArea = new JTextArea(24, 40);
        //24 and 40 are number of rows and columns for a good size textArea
        //these are only used once and are never reset.
        responseTextArea.setEditable(false);
        responseTextArea.setWrapStyleWord(true);
        responseTextArea.setLineWrap(true);
        responseTextArea.setText(adventure.getWelcomeMessage());
        responseTextArea.append(adventure.getPrompt());

        final JScrollPane scrollpane = new JScrollPane(responseTextArea);
        scrollpane
          .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane
          .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollpane);
        add(Box.createVerticalStrut(6));
        add(tbxPlayerEntry);

        //Set up action listener for keyboard input and enter key.
        tbxPlayerEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // If blank line or spaces ignore them.
                if (tbxPlayerEntry.getText().trim().equals(""))
                    return;

                // If echo is turned on, echo it back (with an end line).
                if (commandEcho)
                    responseTextArea.append(tbxPlayerEntry.getText() + "\n \n");

                // Execute the input command into adventure.
                String result = adventure.execute(tbxPlayerEntry.getText());

                // Reset the text area to show result.
                tbxPlayerEntry.setText("");
                responseTextArea.append(result);

                // If the game is over, close the textbox.
                if (adventure.isGameOver())
                    tbxPlayerEntry.setEditable(false);
                else
                    responseTextArea.append(adventure.getPrompt());

                // Force the scrollpane to scroll to the bottom of its text.
                // (From Neal Coleman)
                responseTextArea.setCaretPosition(responseTextArea.getDocument()
                        .getLength());
            }
        });
    }
}
