/*
Jemma Tiongson
Section #16031
App: Driver.java (GUI App)
Purpose: Demonstrate GUI pt 2,3,4
-------------------------------------------------------------------------

Terminal:
   Compile: javac Driver.java GUIApp.java OddDialog.java EvenDialog.java CircumferenceDialog.java
   C2FDialog.java CircumferenceDialog.java F2CDialog.java FactorialDialog.java FibonacciDialog.java GCDDialog.java
   MaxDialog.java MinDialog.java RecursiveDialog.java ReadDialog.java
   Run: java Driver
_________________________________________________________________________
*/

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class CircumferenceDialog extends JInternalFrame {
   
   private static CircumferenceDialog instance = null;
   
   private JTextField tf;
   private JButton btn;
   private JLabel lbl;
   private JPanel upperPanel, lowerPanel;
   
   public static CircumferenceDialog getInstance() {
      if (instance == null) {
         instance = new CircumferenceDialog();
      }
      return instance;
   }
   private void circActionPerformed() {
      
      int input = 0;
      try {
         input = Integer.parseInt(tf.getText());
         double val = 2*Math.PI *input;
         int circ = (int) val;
         lbl.setText("Circumference of circle is " +circ);
      }
      catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Bad input! Try again.");
      }
      
   }
   // private constructor
   private CircumferenceDialog() {
      
      // call constructor of JInternalFrame
      // Arguments: title, resizability, closability,
      //               maximizability, and iconifiability
      super("Circumference", false, true, false, false);
      
      tf = new JTextField(10);
      btn = new JButton("Circumference?");
      lbl = new JLabel("Enter Radius");
      upperPanel = new JPanel();
      lowerPanel = new JPanel();
      
      upperPanel.setLayout(new FlowLayout());
      upperPanel.setLayout(new FlowLayout());
      
      upperPanel.add(tf);
      upperPanel.add(btn);
      
      lowerPanel.add(lbl);
      
      add(upperPanel, BorderLayout.NORTH);
      add(lowerPanel, BorderLayout.SOUTH);
      
      // add button listener
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            circActionPerformed();
         }
      });
      
      btn.setBorder(BorderFactory.createCompoundBorder(
            btn.getBorder(),
            BorderFactory.createEmptyBorder(0, 0, 20, 0)));
      setBounds(25, 25, 250, 120);
      setLocation(100, 100);
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
   }
   
}