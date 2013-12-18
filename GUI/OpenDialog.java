
// http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com
// /javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/CustomDialog.java


import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.beans.*; //property change stuff
import java.awt.*;
import java.awt.event.*;


public class OpenDialog extends JDialog {
  
  private JTextField textField;
  private JOptionPane optionPane;
  private String okayString = "okay";
  
  
  public OpenDialog(Frame f, String s) {
    super(f, true);
    setTitle("Instructions");
    
    optionPane = new JOptionPane(s, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
    
    setContentPane(optionPane);
    
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
   
  }
    
 
  
}