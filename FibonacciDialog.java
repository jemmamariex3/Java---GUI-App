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

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class FibonacciDialog extends JInternalFrame {
   
   private static FibonacciDialog instance = null;
   
   private JTextField tf;
   private JButton btn;
   private JLabel lbl, lbl2;
   private JPanel upperPanel, lowerPanel;
   
   public static FibonacciDialog getInstance() {
      if (instance == null) {
         instance = new FibonacciDialog();
      }
      return instance;
   }
   public int fibonacci(int val){
      if(val <= 1){
         return 1;
      }
      return fibonacci(val-1) + fibonacci(val-2);
   }
   private void fibActionPerformed(){
      int input = 0;
      try{
         input = Integer.parseInt(tf.getText());
         lbl.setText("Answer: " +fibonacci(input));
      }
      catch(Exception e) {
         JOptionPane.showMessageDialog(this, "Bad input! Try again.");
      }
      
   }
   // private constructor
   private FibonacciDialog() {
      
      // call constructor of JInternalFrame
      // Arguments: title, resizability, closability,
      //               maximizability, and iconifiability
      super("Fibonacci", false, true, false, false);
      
      tf = new JTextField(10);
      btn = new JButton("Fibonacci?");
      lbl = new JLabel("Enter Integer");
      lbl2 = new JLabel(" ");
      upperPanel = new JPanel();
      lowerPanel = new JPanel();
      
      upperPanel.setLayout(new FlowLayout());
      upperPanel.setLayout(new FlowLayout());
      
      upperPanel.add(tf);
      upperPanel.add(btn);
      
      lowerPanel.add(lbl);
      lowerPanel.add(lbl2);
      
      add(upperPanel, BorderLayout.NORTH);
      add(lowerPanel, BorderLayout.SOUTH);
      
      // add button listener
      btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            fibActionPerformed();
         }
      });
      
      setBounds(25, 25, 250, 120);
      setLocation(100, 100);
      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      
   }
   
}