/*
Jemma Tiongson
Section #16031
App: Driver.java (GUI App)
Purpose: Demonstrate GUI pt 2,3,4
-------------------------------------------------------------------------

Terminal:
   Compile: javac Driver.java GUIApp.java OddDialog.java EvenDialog.java AreaCircleDialog.java
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

class GCDDialog extends JInternalFrame {
   
   private static GCDDialog instance = null;
   
   private JTextField tf;
   private JTextField tf2;
   private JButton btn;
   private JLabel lbl;
   private JPanel upperPanel, lowerPanel;
   
   public static GCDDialog getInstance() {
      if (instance == null) {
         instance = new GCDDialog();
      }
      return instance;
   }
   public int GCD(int val1, int val2){
      if(val2 == 0){
         return val1;
      }
      return GCD(val2, (val1%val2));
   }
   private void gcdActionPerformed() {
      
      int input1 = 0;
      int input2 = 0;
      try {
         input1 = Integer.parseInt(tf.getText());
         input2 = Integer.parseInt(tf2.getText());
         lbl.setText("Answer: " +GCD(input1,input2));
      }
      catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Bad input! Try again.");
      }
      
      
   }
   // private constructor
   private GCDDialog() {
      
      // call constructor of JInternalFrame
      // Arguments: title, resizability, closability,
      //               maximizability, and iconifiability
      super("GCD", false, true, false, false);
      
      tf = new JTextField(10);
      tf2 = new JTextField(10);
      btn = new JButton("GCD?");
      lbl = new JLabel();
      lbl.setText("Enter integers.");
      upperPanel = new JPanel();
      lowerPanel = new JPanel();
      
      upperPanel.setLayout(new FlowLayout());
      upperPanel.setLayout(new FlowLayout());
      
      upperPanel.add(tf);
      upperPanel.add(tf2);
      upperPanel.add(btn);
      
      lowerPanel.add(lbl);
      
      add(upperPanel, BorderLayout.NORTH);
      add(lowerPanel, BorderLayout.SOUTH);
      
      // add button listener
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            gcdActionPerformed();
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