import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rebound {
  public static void main (String[] args) {
    JFrame frame = new JFrame("Rebound");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(950, 150));
    frame.getContentPane().add(new ReboundPanel());
    
    frame.pack();
    frame.setVisible(true);
  }
}