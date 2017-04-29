/*
Jemma Tiongson
Section #16031
App: Driver.java (GUI App)
Purpose: Demonstrate GUI pt 2,3,4
-------------------------------------------------------------------------

Terminal:
   Compile: javac Driver.java GUIApp.java OddDialog.java EvenDialog.java F2CCircleDialog.java
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

class C2FDialog extends JInternalFrame {
   
   private static C2FDialog instance = null;
   
   private JTextField tf;
   private JButton btn;
   private JLabel lbl;
   private JPanel upperPanel, lowerPanel;
   
   public static C2FDialog getInstance() {
      if (instance == null) {
         instance = new C2FDialog();
      }
      return instance;
   }
   private void c2fActionPerformed() {
      
      int input = 0;
      try {
         input = Integer.parseInt(tf.getText());
         int constant = 32;
         double fraction = 1.8; //decimal version of 9/5
         double result = (input * fraction) + constant;
         int newResult = (int) result;
         lbl.setText("C to F is " +newResult);
      }
      catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Bad input! Try again.");
      }
      
   }
   // private constructor
   private C2FDialog() {
      
      // call constructor of JInternalFrame
      // Arguments: title, resizability, closability,
      //               maximizability, and iconifiability
      super("C2F", false, true, false, false);
      
      tf = new JTextField(10);
      btn = new JButton("C to F?");
      lbl = new JLabel("Enter Celcius");
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
            c2fActionPerformed();
         }
      });
      
      setBounds(25, 25, 250, 120);
      setLocation(100, 100);
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
   }
   
}