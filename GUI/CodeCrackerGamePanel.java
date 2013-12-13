/**
 * FILE: CodeCrackerGamePanel.java
 * AUTHORS: Clara Smith and Cali Stenson
 * DATE: Dec 3 2013
 * MODIFIED: Dec 3 2013
 * 
 * CodeCrackerGamePanel creates the panel from which the user will play the game.
 */

// import declarations
import java.util.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.image.BufferedImage; 
import java.io.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;
import javax.imageio.ImageIO;


public class CodeCrackerGamePanel extends JPanel {
  
  // instance vars
  private CodeCracker game;
  private Levels graph;
  // for top
  private JLabel headerLabel;
  // for left panel
  private JPanel leftPanel;
  private JLabel levelsLabel;
  private JButton romeButton, tuscanyButton, veniceButton, quadButton, tupeloButton, hoopButton, tunnelsButton, clappButton;
  // for right panel
  private JPanel rightPanel;
  private JLabel instructLabel, imageLabel, submitLabel;
  private JTextField submitText, storyText;
  private JButton submitButton;
  private ImageIcon detectiveIcon;
  // preferred sizes
  private final int WIDTH = 850, HEIGHT = 750;
  
  // constructor
  public CodeCrackerGamePanel (CodeCracker c, Levels l) {
    
    game = c;
    graph = l;
    
    // sets up visuals
    setLayout(new BorderLayout()); // sets layout to Border Layout
    
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    // starts with the top panel
    headerLabel = new JLabel("<html><center>Welcome to Wendy Wellesley: Code Cracker!</center></html>");
    headerLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
    headerLabel.setPreferredSize(new Dimension(850, 50));
    
    // creates left panel
    // nests Box Layout within panes of Flow Layout
    leftPanel = new JPanel();
    leftPanel.setPreferredSize(new Dimension(423, 700));
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 4));
    leftPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for left panel
    levelsLabel = new JLabel("Levels");
    romeButton = new JButton("Ancient Rome");
    tuscanyButton = new JButton("Tuscany");
    veniceButton = new JButton("Venice");
    quadButton = new JButton("Academic Quad");
    tupeloButton = new JButton("Tupelo Lane");
    hoopButton = new JButton("Cafe Hoop");
    tunnelsButton = new JButton("Wellesley Tunnels");
    clappButton = new JButton("Clapp Library");
    // creates and adds listener to buttons
    CodeCrackerGamePanelListener listener = new CodeCrackerGamePanelListener();
    romeButton.addActionListener(listener);
    tuscanyButton.addActionListener(listener);
    veniceButton.addActionListener(listener);
    quadButton.addActionListener(listener);
    tupeloButton.addActionListener(listener);
    hoopButton.addActionListener(listener);
    tunnelsButton.addActionListener(listener);
    clappButton.addActionListener(listener);
    // adds components to panel
    leftPanel.add(levelsLabel);
    leftPanel.add(romeButton);
    leftPanel.add(tuscanyButton);
    leftPanel.add(veniceButton);
    leftPanel.add(quadButton);
    leftPanel.add(tupeloButton);
    leftPanel.add(hoopButton);
    leftPanel.add(tunnelsButton);
    leftPanel.add(clappButton);
    
    // creates right panel
    // nests Box Layout within panes of Flow Layout    
    rightPanel = new JPanel();
    rightPanel.setPreferredSize(new Dimension(423, 700));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    rightPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for right panel
    instructLabel = new JLabel("Current level: " + game.getCurrentLevel().getName() + ". Read the storyline and click on the " 
                                 + game.getCurrentLevel().getCipher().getType() + " button in the instructions pane " 
                              + "for more info on how to decrypt the cipher.");
    storyText = new JTextField("story here", 40);
    imageLabel = new JLabel("image here");
    submitLabel = new JLabel("Submit the decoded message here when you are done.");
    submitText = new JTextField(40);
    submitButton = new JButton("Submit");
    detectiveIcon = new ImageIcon("Images/woman-final.gif");
    // adds listener to button
    submitButton.addActionListener(listener);
    // adds components to panel
    rightPanel.add(instructLabel);
    rightPanel.add(storyText);
    rightPanel.add(imageLabel);
    rightPanel.add(submitLabel);
    rightPanel.add(submitText);
    rightPanel.add(submitButton);
    
    // adds everything to GUI
    this.add(headerLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(rightPanel, BorderLayout.CENTER);
    
  }
  
  public void paintComponent (Graphics page) {
    super.paintComponent(page);
    detectiveIcon.paintIcon(this, page, 0, 0);
  }
  
  private class CodeCrackerGamePanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      JButton b = new JButton();
      b = (JButton)event.getSource();
      if (b == submitButton) {
        System.out.println("Wooh! You submitted!");
        if (game.playLevel(submitText.getText())) {
          nextLevel(game.current);
          JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                        game.current.getName());
        }
        else JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
      } else if (b == romeButton) {
        System.out.println("Okay, you may now begin! You are now in ancient Rome");
      } else {
        String message = (String)JOptionPane.showInputDialog("Please input the decrypted message from the previous level");
        if (b == tuscanyButton) {
          if (checkMessage(message, graph.getRome())) {
            if (game.chooseLevelFromPause(graph.getRome(), graph.getTuscany(), message)) {
              nextLevel(graph.getTuscany());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == veniceButton) {
          if (checkMessage(message, graph.getTuscany())) {
            if (game.chooseLevelFromPause(graph.getTuscany(), graph.getVenice(), message)) {
              nextLevel(graph.getVenice());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == quadButton) {
          if (checkMessage(message, graph.getVenice())) {
            if (game.chooseLevelFromPause(graph.getVenice(), graph.getQuad(), message)) {
              nextLevel(graph.getQuad());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tupeloButton) {
          if (checkMessage(message, graph.getQuad())) {
            if (game.chooseLevelFromPause(graph.getQuad(), graph.getTupelo(), message)) {
              nextLevel(graph.getTupelo());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == hoopButton) {
          if (checkMessage(message, graph.getTupelo())) {
            if (game.chooseLevelFromPause(graph.getTupelo(), graph.getHoop(), message)) {
              nextLevel(graph.getHoop());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tunnelsButton) {
          if (checkMessage(message, graph.getHoop())) {
            if (game.chooseLevelFromPause(graph.getHoop(), graph.getTunnels(), message)) {
              nextLevel(graph.getTunnels());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }  
        } else if (b == clappButton) {
          if (checkMessage(message, graph.getTunnels())) {
            if (game.chooseLevelFromPause(graph.getTunnels(), graph.getClapp(), message)) {
              nextLevel(graph.getClapp());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level: " +
                                            game.current.getName());
            }
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } 
      }
      
    }
    
    // checks message to make sure it's correct
    // returns true if so, false if not
    public boolean checkMessage(String message) {
      return (message.equals(game.getCurrentLevel().getMessage()));
    }
    
    public boolean checkMessage(String message, Level l) {
      return (message.equals(l.getMessage()));
    }
    
    
    // sets center panel to next level's info
    public void nextLevel(Level l) {
      System.out.println("Setting center (viewed as right) panel to next level's info.");
      try {
        storyText.read(l.getStoryLine(), null);
      } catch (IOException e) {
        System.out.print("***ATTENTION***: COULD NOT READ NEXT LEVEL'S STORY LINE FROM FILE. \n ERROR: " + e);
      }
      submitText.setText("");
    }
    
    
  }
  
}