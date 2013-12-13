/**
 * FILE: CodeCrackerGUI.java
 * AUTHORS: Clara Smith and Cali Stenson
 * DATE: Dec 3 2013
 * MODIFIED: Dec 3 2013
 * 
 * CodeCrackerGUI sets up the GUI for the CodeCracker class.
 */

// import declarations
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class CodeCrackerGUI {
  
  
  public static void main (String[] args) {
    
    
    // creates a frame, sets default close to soft close to catch crash
    JFrame frame = new JFrame("Code Cracker");
    frame.setSize(new Dimension(850, 750));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // creates an instance of CodeCracker
    // CodeCracker game = new CodeCracker(); //edit this once CodeCracker class is written
    
    // creates panels
    CodeCrackerAboutPanel aboutPanel = new CodeCrackerAboutPanel();
    CodeCrackerInstructionsPanel instructionsPanel = new CodeCrackerInstructionsPanel();
    Levels graph = new Levels();
    CodeCracker game = new CodeCracker(graph.getGameGraph());
    CodeCrackerGamePanel gamePanel = new CodeCrackerGamePanel(game, graph);
    
    // creates tabbed pane and
    // adds tabbed panels to frame
    JTabbedPane codecracker = new JTabbedPane();
    codecracker.addTab("About", aboutPanel);
    codecracker.addTab("Instructions", instructionsPanel);
    codecracker.addTab("Game", gamePanel);
    
    // misc
    frame.getContentPane().add(codecracker);
    
    frame.pack();
    frame.setVisible(true);
    
  }
  
}