/**
 * ReboundPanel.java
 * Authors: Clara Smith and Cali Stenson
 * Date: December 8, 2013
 *
 * MODIFIED VERSION OF REBOUNDPANEL as found in CS 230 textbook
 * 
 * This class creates a specific type of JPanel in which image
 * moves around panel and, when clicked, creates a message dialog
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class ReboundPanel extends JPanel {
  
  private final int WIDTH = 770, HEIGHT = 150;
  private final int DELAY = 60, IMAGE_SIZE = 120;
  
  private ImageIcon image, background;
  private Timer timer;
  private int x, y, moveX, moveY;
  private JButton xButton;
  
  
  public ReboundPanel() {
    ReboundListener listener = new ReboundListener();
    timer = new Timer(DELAY, listener);
    
    image = new ImageIcon ("Images/sigs.png");
    background = new ImageIcon ("Images/AboutBottom.png");
    
    xButton = new JButton("        ");
    xButton.setFont(new Font("Sans Serif", Font.PLAIN, 70));
    xButton.setOpaque(false);
    xButton.setContentAreaFilled(false);
    xButton.setBorderPainted(false);
    xButton.addActionListener(listener);
    this.add(xButton);
    
    x = 0;
    y = 0;
    moveX = 3;
    moveY = 3;
    
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setOpaque(false);
    timer.start();
  }
  
  public void paintComponent(Graphics page) {
    page.drawImage(background.getImage(), 0, 0, null);
    super.paintComponent(page);
    image.paintIcon(this, page, x, y);
    xButton.setLocation(x, y + 20);
  }
  
  private class ReboundListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      x += moveX;
      y += moveY;
      
      if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
        moveX = moveX * -1;
      
      if (y <= 0 || y >= HEIGHT-IMAGE_SIZE)
        moveY = moveY * -1;
      
      repaint();
      setOpaque(false);
      
      if (event.getSource() == xButton) {
        JOptionPane.showMessageDialog(null, "<html><strong>Clara Smith</strong>, Wellesley College '17"
                                        + "<br>Computer Science, Cinema and Media Studies<br>csmith6@wellesley.edu"
                                        + "<br><br><strong>Cali Stenson</strong>, Wellesley College '17"
                                        + "<br>Computer Science, Mathematics<br>cstenson@wellesley.edu</html>");
      }
    }
  }
}

