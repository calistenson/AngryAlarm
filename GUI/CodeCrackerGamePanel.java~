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
  private ContentGraph graph;
  // for top
  private JLabel headerLabel;
  // for left panel
  private ImagePanel leftPanel;
  private JPanel labelPane, l1Pane, l2Pane, l3Pane, l4Pane;
  private JLabel levelsLabel;
  private JButton romeButton, tuscanyButton, veniceButton, quadButton, tupeloButton, hoopButton, tunnelsButton, clappButton;
  // for right panel
  private JPanel rightPanel, instructPane, messagePane, imagePane, submitPane;
  private JScrollPane storyPane;
  private JLabel instructLabel, messageLabel;
  private JTextField submitText;
  private JTextArea storyText;
  private JButton submitButton;
  private BufferedImage detectiveImage;
  private JLabel detectiveLabel;
  // preferred sizes
  private final int WIDTH = 950, HEIGHT = 750;
  
  // constructor
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
    //labelPane = new JPanel();
    //labelPane.setOpaque(false);
    //labelPane.setSize(new Dimension(415, 40));
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
    //System.out.println("LEVELS LABEL: " + levelsLabel.toString());
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
    
    ArrayList<JButton> levelButtons = new ArrayList<JButton>();
    levelButtons.add(romeButton);
    levelButtons.add(tuscanyButton);
    levelButtons.add(veniceButton);
    levelButtons.add(quadButton);
    levelButtons.add(tupeloButton);
    levelButtons.add(hoopButton);
    levelButtons.add(tunnelsButton);
    levelButtons.add(clappButton);
    
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
    //labelPane.add(levelsLabel);
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
   
    rightPanel = new JPanel();
    rightPanel.setPreferredSize(new Dimension(523, 700));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createLineBorder(new Color(186, 186, 186), 4));
    rightPanel.setBackground(new Color(76, 168, 194));
    // creates componenets for right panel
    instructPane = new JPanel();
    
    
    instructLabel = new JLabel("<html><strong>Current level: " + game.getCurrent().getName() + "</strong>. Read the storyline and click on the " 
                                 + game.getCurrent().getCipher().getType() + " button in the instructions pane " 
                                 + "for more info on how to decrypt the cipher.</html>");
    instructLabel.setPreferredSize(new Dimension(509, 50));
    instructPane.add(instructLabel);
    
    storyText = new JTextArea(7, 42);
    try {
      String content = new Scanner(graph.getRome().getStoryLine()).useDelimiter("\\A").next();
      storyText.setText(content);
      storyText.setLineWrap(true);
    } catch (IOException e) {
      System.out.println("***ALERT***  Could not find or read from file! Error: " + e);
    }
    storyPane = new JScrollPane(storyText);
    storyText.setEditable(false);
    storyText.setBackground(new Color(76, 168, 194));
    storyPane.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 3));
    
    messagePane = new JPanel();
    messageLabel = new JLabel("<html><strong>Encrypted message</strong>: " + graph.getRome().getCipher().encrypt(graph.getRome().getMessage()) + "</html>");
    messagePane.add(messageLabel);
    
    imagePane = new JPanel();
    try {
      detectiveImage = ImageIO.read(new File("Images/submitwoman.png"));
      detectiveLabel = new JLabel(new ImageIcon(detectiveImage));
      imagePane.add(detectiveLabel);
    } catch (IOException e) {
      System.out.println("***ALERT***  Could not read or display image! Error: " + e);
    }
      
    submitPane = new JPanel();
    submitText = new JTextField(40);
    submitButton = new JButton("Submit");
    submitButton.addActionListener(listener);
    submitPane.add(submitText);
    submitPane.add(submitButton);
    
    instructPane.setOpaque(false);
    storyPane.setOpaque(false);
    messagePane.setOpaque(false);
    imagePane.setOpaque(false);
    submitPane.setOpaque(false);
    
    //instructPane.setPreferredSize(new Dimension(509, 70));
    storyPane.setSize(new Dimension(509, 150));
    //messagePane.setPreferredSize(new Dimension(509, 20));
        
    rightPanel.add(instructPane);
    rightPanel.add(storyPane);
    rightPanel.add(messagePane);
    rightPanel.add(imagePane);
    rightPanel.add(submitPane);
    
    
    // adds everything to GUI
    this.add(headerLabel, BorderLayout.PAGE_START);
    this.add(leftPanel, BorderLayout.LINE_START);
    this.add(rightPanel, BorderLayout.CENTER);
  }
  
  
  private class CodeCrackerGamePanelListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      JButton b = new JButton();
      b = (JButton)event.getSource();
      if (b == submitButton) {
        System.out.println("Wooh! You submitted!");
        if (game.playLevel(submitText.getText())) {
          nextLevel(game.getCurrent());
          JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
        }
        else JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
      } else if (b == romeButton) {
        System.out.println("Okay, you may now begin! You are now in ancient Rome");
      } else {
        String message = (String)JOptionPane.showInputDialog("Please input the decrypted message from the previous level");
        if (b == tuscanyButton) {
          if (game.chooseNewLevel(graph.getTuscany())) {
              nextLevel(graph.getTuscany());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
            }
           else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == veniceButton) {
          if (game.chooseNewLevel(graph.getVenice())) {
              nextLevel(graph.getVenice());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
            
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }
        } else if (b == quadButton) {
          if (game.chooseNewLevel(graph.getQuad())) {
              nextLevel(graph.getQuad());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tupeloButton) {
          if (game.chooseNewLevel(graph.getTupelo())) {
              nextLevel(graph.getTupelo());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == hoopButton) {
          if (game.chooseNewLevel(graph.getHoop())) {
              nextLevel(graph.getHoop());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } else if (b == tunnelsButton) {
          if (game.chooseNewLevel(graph.getTunnels())) {
              nextLevel(graph.getTunnels());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          }  
        } else if (b == clappButton) {
          if (game.chooseNewLevel(graph.getClapp())) {
              nextLevel(graph.getClapp());
              JOptionPane.showMessageDialog(null, "Congrats! You have completed this level and can now continue onto the next level.");
          } else {
            JOptionPane.showMessageDialog(null, "Sorry, your message was incorrect. Please try again.");
          } 
        } 
      }
      this.updateMap();
    }
    
    
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
    
    
    // sets center panel to next level's info
    public void nextLevel(Level l) {
      System.out.println("Setting center (viewed as right) panel to next level's info.");
      try {
        String content = new Scanner (l.getStoryLine()).useDelimiter("\\A").next();
        storyText.setText(content);
        storyText.setBackground(new Color(76, 168, 194));
        instructLabel.setText("<html><strong>Current level: " + game.getCurrent().getName() + "</strong>. Read the storyline and click on the " 
                                 + game.getCurrent().getCipher().getType() + " button in the instructions pane " 
                                 + "for more info on how to decrypt the cipher.</html>");
        messageLabel.setText("<html><strong>Encrypted message</strong>: " + game.codedMessage(game.getCurrent()) + "</html>");
      } catch (IOException e) {
        System.out.print("***ATTENTION***: COULD NOT READ NEXT LEVEL'S STORY LINE FROM FILE. \n ERROR: " + e);
      }
      submitText.setText("");
    }
    
    
  }
  
}