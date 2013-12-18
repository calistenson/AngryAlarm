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
  
  
  
  /*
   * INSTANCE VARIABLES
   * CodeCracker game
   * ContentGraph graph
   * JLabel headerLabel, levelsLabel, instructLabel, messageLabel, detectiveLabel
   * ImagePanel leftPanel, rightPanel
   * JPanel labelPane, l1Pane, l2Pane, l3Pane, l4Pane, instructPane, messagePane, imagePane, submitPane
   * JButton romeButton, tuscanyButton, veniceButton, quadButton, tupeloButton, hoopButton, tunnelsButton, clappButton, submitButton
   * JScrollPane storyPane
   * JTextField submitText
   * JTextArea storyText
   * BufferedImage detectiveImage
   */
  private CodeCracker game;
  private ContentGraph graph;
  // for top
  private JLabel headerLabel;
  // for left panel
  private ImagePanel leftPanel;
  private JPanel labelPane, l1Pane, l2Pane, l3Pane, l4Pane;
  private JLabel levelsLabel;
  private JButton romeButton, tuscanyButton, veniceButton, quadButton, tupeloButton, hoopButton, tunnelsButton, clappButton;
  // for right panel
  private ImagePanel rightPanel;
  private JPanel instructPane, messagePane, imagePane, submitPane;
  private JScrollPane storyPane;
  private JLabel instructLabel, messageLabel;
  private JTextField submitText;
  private JTextArea storyText;
  private JButton submitButton;
  private BufferedImage detectiveImage;
  private JLabel detectiveLabel;
  // preferred sizes
  private final int WIDTH = 950, HEIGHT = 750;
  
  /* CONSTRUCTOR
   * @param c - instance of CodeCracker game
   * @param l - instance of ContentGraph of levels of game
   */
  public CodeCrackerGamePanel (CodeCracker c, ContentGraph l) {
    
    game = c;
    graph = l;
    
    // sets up visuals
    setLayout(new BorderLayout()); // sets layout to Border Layout
    
    this.setBackground(new Color(76, 168, 194)); // sets background color
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // sets the size of the panel
    
    // starts with the top panel
    headerLabel = new JLabel("Welcome to Wendy Wellesley: Code Cracker!");
    headerLabel.setFont(new Font("Sans Serif", Font.PLAIN, 40));
    
    // creates left panel
    // nests Box Layout within panes of Flow Layout
    leftPanel = new ImagePanel(new ImageIcon("Images/map.png").getImage());
    leftPanel.setPreferredSize(new Dimension(423, 700));
    leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    leftPanel.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 4));
    leftPanel.setBackground(new Color(76, 168, 194));
    
    // creates panes
    l1Pane = new JPanel();
    l1Pane.setOpaque(false);
    l2Pane = new JPanel();
    l2Pane.setOpaque(false);
    l3Pane = new JPanel();
    l3Pane.setOpaque(false);
    l4Pane = new JPanel();
    l4Pane.setOpaque(false);
    

    // creates componenets for left panel
    levelsLabel = new JLabel(" ");
    levelsLabel.setPreferredSize(new Dimension(415, 60));
    levelsLabel.setFont(new Font("Sans Serif", Font.PLAIN, 60));
    levelsLabel.setForeground(new Color(76, 168, 194));
    
    // creates buttons and sets formatting for buttons
    romeButton = new JButton("Ancient Rome");
    romeButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    romeButton.setPreferredSize(new Dimension(200, 100));
    tuscanyButton = new JButton("Tuscany");
    tuscanyButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    tuscanyButton.setPreferredSize(new Dimension(150, 100));
    veniceButton = new JButton("Venice");
    veniceButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    veniceButton.setPreferredSize(new Dimension(150, 100));
    quadButton = new JButton("<html>The Quad</html>");
    quadButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    quadButton.setPreferredSize(new Dimension(90, 100));
    tupeloButton = new JButton("<html>Tupelo Lane</html>");
    tupeloButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    tupeloButton.setPreferredSize(new Dimension(90, 100));
    hoopButton = new JButton("<html>Cafe Hoop</html>");
    hoopButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    hoopButton.setPreferredSize(new Dimension(90, 100));
    tunnelsButton = new JButton("<html>The Tunnels</html>");
    tunnelsButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    tunnelsButton.setPreferredSize(new Dimension(90, 100));
    clappButton = new JButton("Clapp Library");
    clappButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    clappButton.setPreferredSize(new Dimension(200, 100));
    
    // creates array list of buttons and adds all the buttons to the array list
    ArrayList<JButton> levelButtons = new ArrayList<JButton>();
    levelButtons.add(romeButton);
    levelButtons.add(tuscanyButton);
    levelButtons.add(veniceButton);
    levelButtons.add(quadButton);
    levelButtons.add(tupeloButton);
    levelButtons.add(hoopButton);
    levelButtons.add(tunnelsButton);
    levelButtons.add(clappButton);
    
    // loops through arraylist levelButtons and makes them all invisible
    for (JButton j : levelButtons) {
      j.setOpaque(false);
      j.setContentAreaFilled(false);
      j.setBorderPainted(false);
      j.setText(" ");
    }
    
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
    
    // adds panes
    l1Pane.add(romeButton);
    l2Pane.add(tuscanyButton);
    l2Pane.add(veniceButton);
    l3Pane.add(quadButton);
    l3Pane.add(tupeloButton);
    l3Pane.add(hoopButton);
    l3Pane.add(tunnelsButton);
    l4Pane.add(clappButton);
    // add all to right panel
    leftPanel.add(levelsLabel);
    leftPanel.add(l1Pane);
    leftPanel.add(l2Pane);
    leftPanel.add(l3Pane);
    leftPanel.add(l4Pane);
    
    
    // creates right panel
    // nests Box Layout within panes of Flow Layout
   
    rightPanel = new ImagePanel(new ImageIcon("Images/Submit.png").getImage());
    rightPanel.setPreferredSize(new Dimension(523, 700));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    rightPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for right panel
    instructPane = new JPanel();
    
    //creates label for instructions
    instructLabel = new JLabel("<html><strong>Current level: " + game.getCurrent().getName() + "</strong>. Read the storyline and click on the " 
                                 + game.getCurrent().getCipher().getType() + " button in the instructions pane " 
                                 + "for more info on how to decrypt the cipher.</html>");
    instructLabel.setPreferredSize(new Dimension(509, 50));
    instructPane.add(instructLabel);
    
    storyText = new JTextArea(7, 42);
    
    // gets story text from appropriate text file
    try {
      String content = new Scanner(graph.getRome().getStoryLine()).useDelimiter("\\A").next();
      storyText.setText(content);
      storyText.setLineWrap(true);
      storyText.setWrapStyleWord(true);
    } catch (IOException e) { //catches IOException
      System.out.println("***ALERT***  Could not find or read from file! Error: " + e);
    }
    
    // sets the storypane to a JScrollPane of the story text
    storyPane = new JScrollPane(storyText);
    storyText.setEditable(false);
    storyText.setBackground(new Color(76, 168, 194));
    storyPane.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 3));
    
    // creates the messge pane with the specific encrypted message
    messagePane = new JPanel();
    messageLabel = new JLabel("<html><strong>Encrypted message</strong>:<br>" + graph.getRome().getCipher().encrypt(graph.getRome().getMessage()) + "</html>");
    messagePane.add(messageLabel);
      
    // creates the submit pane, in which the user can type in and submit the decrypted message
    submitPane = new JPanel();
    submitText = new JTextField(40);
    submitText.addKeyListener(listener);
    submitButton = new JButton("Submit");
    submitButton.addActionListener(listener);
    submitPane.add(submitText);
    submitPane.add(submitButton);
    
    // sets all the individual pane so everything except the componenets are see through
    instructPane.setOpaque(false);
    storyPane.setOpaque(false);
    messagePane.setOpaque(false);
    imagePane.setOpaque(false);
    submitPane.setOpaque(false);
    
    // sets the dimensions of the story pane
    storyPane.setSize(new Dimension(509, 150));
       
    //adds the individual panes to the right panel
    rightPanel.add(instructPane);
    rightPanel.add(storyPane);
    rightPanel.add(messagePane);
    rightPanel.add(Box.createRigidArea(new Dimension(0,240)));
    rightPanel.add(submitPane);
    rightPanel.add(Box.createRigidArea(new Dimension(0,80)));
    
    
    // adds everything to GUI
    this.add(headerLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(rightPanel, BorderLayout.CENTER);
  }
  
  
  private class CodeCrackerGamePanelListener implements ActionListener, KeyListener {
    
    public void actionPerformed(ActionEvent event) {
      JButton b = new JButton();
      b = (JButton)event.getSource(); //just for easier readability
      if (b == submitButton) {
        if (game.playLevel(submitText.getText()) && game.getCurrent().getName().equals("Clapp Library")) {
          JOptionPane.showMessageDialog(null, "Congrats! You have completed the game!");
        }
        else if (game.playLevel(submitText.getText())) {
          JOptionPane.showMessageDialog(null, "Congrats! You have completed this level!");
        }
        else JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
      } else if (b == romeButton) {
        changeLevel(graph.getRome());
        System.out.println("Okay, you may now begin! You are now in ancient Rome");
      } else {
        String message = (String)JOptionPane.showInputDialog("Please input the decrypted message from the previous level");
        if (b == tuscanyButton) {
          if (game.chooseNewLevel(graph.getTuscany())) {
              changeLevel(graph.getTuscany());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
            }
           else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == veniceButton) {
          if (game.chooseNewLevel(graph.getVenice())) {
              changeLevel(graph.getVenice());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
            
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == quadButton) {
          if (game.chooseNewLevel(graph.getQuad())) {
              changeLevel(graph.getQuad());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tupeloButton) {
          if (game.chooseNewLevel(graph.getTupelo())) {
              changeLevel(graph.getTupelo());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == hoopButton) {
          if (game.chooseNewLevel(graph.getHoop())) {
              changeLevel(graph.getHoop());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tunnelsButton) {
          if (game.chooseNewLevel(graph.getTunnels())) {
              changeLevel(graph.getTunnels());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }  
        } else if (b == clappButton) {
          if (game.chooseNewLevel(graph.getClapp())) {
              changeLevel(graph.getClapp());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed the past level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } 
      }
      this.updateMap(); //makes it so it looks like the "button" (artificially create through an image) is chosen
    }
    
    /* public void method updateMap
     * method updates the map image in order to make it appear 
     * as though the current level is selected as a button
     */
    public void updateMap() {
      String s = game.getCurrent().getName();
      if (s.equals("Ancient Rome")) leftPanel.setImage("Images/mapRome.png");
      else if (s.equals("Tuscany")) leftPanel.setImage("Images/mapTuscany.png");
      else if (s.equals("Venice")) leftPanel.setImage("Images/mapVenice.png");
      else if (s.equals("Academic Quad 1940")) leftPanel.setImage("Images/mapQuad.png");
      else if (s.equals("Tupelo Lane May 1 1940")) leftPanel.setImage("Images/mapTupelo.png");
      else if (s.equals("Cafè Hoop 1981")) leftPanel.setImage("Images/mapHoop.png");
      else if (s.equals("Wellesley Tunnels 1990")) leftPanel.setImage("Images/mapTunnels.png");
      else if (s.equals("Clapp Library")) leftPanel.setImage("Images/mapClapp.png");
      else leftPanel.setImage("Images/map.png");
    }
    
    /* public void method keyPressed
     * @param e KeyEvent - a key event from user's keyboard
     * makes it so that user can press "enter" key when submitting the decrypted message 
     * and it will act the same as clicking "submit" button
     */
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode()==KeyEvent.VK_ENTER){
        //System.out.println("Wooh! You submitted!");
        if (game.playLevel(submitText.getText()) && game.getCurrent().getName().equals("Clapp Library")) {
          JOptionPane.showMessageDialog(null, "Congrats! You have completed the game!");
        }
        else if (game.playLevel(submitText.getText())) {
          JOptionPane.showMessageDialog(null, "Congrats! You have completed this level!");
        }
        else JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
      }   
    }
    
    /* neccessary to overrid when implementing KeyListener
     * taken care of in keyPressed() method
     */
    public void keyReleased(KeyEvent e) {
    }
    
    /* neccessary to overrid when implementing KeyListener
     * taken care of in keyPressed() method
     */
    public void keyTyped(KeyEvent e) {
    }
    
    
    /* public void method changeLevel
     * @param l Level - level to change information to
     * sets center panel to Level l's info
     */
    public void changeLevel(Level l) {
      System.out.println("Setting center (viewed as right) panel to next level's info.");
      try {
        String content = new Scanner (l.getStoryLine()).useDelimiter("\\A").next();
        storyText.setText(content);
        storyText.setBackground(new Color(76, 168, 194));
        instructLabel.setText("<html><strong>Current level: " + game.getCurrent().getName() + "</strong>. Read the storyline and click on the " 
                                 + game.getCurrent().getCipher().getType() + " button in the instructions pane " 
                                 + "for more info on how to decrypt the cipher.</html>");
        messageLabel.setText("<html><strong>Encrypted message</strong>:<br>" + game.codedMessage(game.getCurrent()) + "</html>");
        System.out.println("Current level: " + game.getCurrent() + "\n" + "Encrypted message: " + game.codedMessage(game.getCurrent()));
      } catch (IOException e) {
        System.out.print("***ATTENTION***: COULD NOT READ NEXT LEVEL'S STORY LINE FROM FILE. \n ERROR: " + e);
      }
      submitText.setText("");
    }
    
    
  }
  
}