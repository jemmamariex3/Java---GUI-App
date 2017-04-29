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
import javax.swing.SwingUtilities;

class Driver{
   public static void main (String [] args){
      //build and show app using event dispatching thread
      SwingUtilities.invokeLater(new Runnable(){
         public void run(){
            GUIApp gui = new GUIApp();
         }
      });
   }
}