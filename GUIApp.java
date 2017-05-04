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
//swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTree;
import javax.swing.JOptionPane;

//swing event
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

//swingtree
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

//abstract window toolkit (awt)
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Cursor;

//awt events
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GUIApp {
   //member variables
   private JFrame frame;
   private JPanel panel;
   private JScrollPane scrollPane;
   private JDesktopPane desktop;
   private JSplitPane splitPane;
   private JPanel labelPanel;
   private JLabel statusLabel;
   private JMenuBar menuBar;
   private JMenu fileMenu;
   private JMenu helpMenu;
   private JMenuItem exitItem;
   private JMenuItem aboutItem;
   private JTree tree;
   private JOptionPane pane;
   
   //constructor
   public GUIApp() {
      initComponents();
      statusLabel.setText("Initialization Complete.");
      JOptionPane pane = new JOptionPane();
   }
   
   //create GUI and make it visible to user
   private void initComponents() {
      setLookAndFeel();
      buildDesktop();
      buildTree();
      addTreeListeners();
      buildMenu();
      addMenuListeners();
      buildPanel();
      buildFrame();
   }
   
   //setLookAndFeel
   private void setLookAndFeel() {
      try {
         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   //buildDesktop()
   private void buildDesktop() {
      desktop = new JDesktopPane(){
         @Override
         protected void paintComponent(Graphics g)
         {
            ImageIcon icon = new ImageIcon("images/csun_logo.png");
            Image image = icon.getImage();
      
            int x=0, y=0;
            double imageWidth = image.getWidth(null);
            double imageHeight = image.getHeight(null);
            double screenWidth = getWidth();
            double screenHeight = getHeight();
            if(screenWidth != 0) {
               x = (int)screenWidth  / 2 - (int)imageWidth  / 2;
            }
   
            if(screenHeight != 0) {
               y = (int)screenHeight / 2 - (int)imageHeight / 2;
            }
   
            g.drawImage(image, x, y, this);
         }
      };
   
   }
   //buildMenu()
   private void buildMenu() {
      menuBar = new JMenuBar();
      fileMenu = new JMenu("File");
      helpMenu = new JMenu("Help");
      exitItem = new JMenuItem("Exit");
      aboutItem = new JMenuItem("About");
      fileMenu.add(exitItem);
      helpMenu.add(aboutItem);
      menuBar.add(fileMenu);
      menuBar.add(helpMenu);
   }
   
   //addMenuListeners()
   private void addMenuListeners() {
      // listener for exit menu item
      exitItem.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  exitActionPerformed();
               }
            }
      );
      // add listener for about menu item
      aboutItem.addActionListener(
            new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  aboutActionPerformed();
               }
            }
      );
   }
   
   public void exitActionPerformed(){
      frame.dispose();
   }
   
   public void aboutActionPerformed(){
      pane = new JOptionPane();
      pane.showMessageDialog(null, "thanks for using app!");
   }
   //buildPanel
   private void buildPanel() {
      panel = new JPanel();
      splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      scrollPane = new JScrollPane();
      labelPanel = new JPanel();
      statusLabel = new JLabel();
   
      scrollPane.getViewport().add(tree);
   
      statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
      statusLabel.setMinimumSize(new Dimension(0, 18));
      statusLabel.setPreferredSize(new Dimension(0, 18));
      
      splitPane.setOneTouchExpandable(true);
      splitPane.setDividerLocation(200);
      splitPane.setContinuousLayout(true);
      splitPane.add(desktop, JSplitPane.RIGHT);
      splitPane.add(scrollPane, JSplitPane.LEFT);
      
      panel.setLayout(new BorderLayout());
      panel.add(splitPane, BorderLayout.CENTER);
      
      labelPanel.setLayout(new BorderLayout());
      labelPanel.add(statusLabel, BorderLayout.CENTER);
   }
   
   //buildFrame()
   private void buildFrame() {
      frame.setDefaultLookAndFeelDecorated(true);
      frame = new JFrame("Jemma's GUI Application");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/csun.gif"));
      
      // add label panel
      frame.getContentPane().add(labelPanel, BorderLayout.SOUTH);
      // add main panel
      frame.getContentPane().add(panel, BorderLayout.CENTER);
      // add menu bar
      frame.setJMenuBar(menuBar);
      frame.setSize(1280, 800);
      frame.setVisible(true);
   }
   
   //buildTree()
   private void buildTree() {
      // data for the tree
      DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tools");
      DefaultMutableTreeNode alg = new DefaultMutableTreeNode("Algorithms");
      DefaultMutableTreeNode itr = new DefaultMutableTreeNode("Iterative");
      DefaultMutableTreeNode odd = new DefaultMutableTreeNode("Odd"); //done
      DefaultMutableTreeNode even = new DefaultMutableTreeNode("Even"); //done
      DefaultMutableTreeNode min = new DefaultMutableTreeNode("Min"); //done
      DefaultMutableTreeNode max = new DefaultMutableTreeNode("Max"); //done
      DefaultMutableTreeNode area = new DefaultMutableTreeNode("AreaCircle"); //done
      DefaultMutableTreeNode circ = new DefaultMutableTreeNode("CircumferenceCircle");//done
      DefaultMutableTreeNode f2c = new DefaultMutableTreeNode("F2C");//done
      DefaultMutableTreeNode c2f = new DefaultMutableTreeNode("C2F");//done
      DefaultMutableTreeNode rec = new DefaultMutableTreeNode("Recursive");
      DefaultMutableTreeNode gcd = new DefaultMutableTreeNode("GCD");
      DefaultMutableTreeNode fib = new DefaultMutableTreeNode("Fibonacci");
      DefaultMutableTreeNode fac = new DefaultMutableTreeNode("Factorial");
      DefaultMutableTreeNode io = new DefaultMutableTreeNode("IO");
      DefaultMutableTreeNode fileInfo = new DefaultMutableTreeNode("File Info");
      
      itr.add(odd);
      itr.add(even);
      itr.add(min);
      itr.add(max);
      itr.add(area);
      itr.add(circ);
      itr.add(f2c);
      itr.add(c2f);
   
      rec.add(gcd);
      rec.add(fib);
      rec.add(fac);
   
      alg.add(itr);
      alg.add(rec);
   
      io.add(fileInfo);
      root.add(alg);
      root.add(io);
   
      // create a new tree
      DefaultTreeModel treeModel = new DefaultTreeModel(root);
      tree = new JTree(treeModel);
      
   }
   //tree listeners
   private void addTreeListeners() {
      tree.addMouseListener(
            new MouseAdapter() {
               @Override
               public void mousePressed(MouseEvent e) {
                  int selRow = tree.getRowForLocation(e.getX(), e.getY());
                  if(selRow != -1) {
                     treeClicked();
                  }
               }
            }
      );
   }
   //treeclicked
   private void treeClicked() {
      // get the last selected tree node
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)
            tree.getLastSelectedPathComponent();
      // if the node is a leaf (no children, keep going)
      if (node != null && node.isLeaf()) {
         statusLabel.setText(node.toString() + " clicked.");
      }
      
      //algorithms
      if(node.toString().equals("Odd")) {
         OddDialog od = OddDialog.getInstance();
         if(!od.isVisible()) {
            od.setVisible(true);
            desktop.add(od);
         }
      }
      else if(node.toString().equals("Even")) {
         EvenDialog ed = EvenDialog.getInstance();
         if(!ed.isVisible()) {
            ed.setVisible(true);
            desktop.add(ed);
         }
      }
      else if(node.toString().equals("Min")) {
         MinDialog minD = MinDialog.getInstance();
         if(!minD.isVisible()) {
            minD.setVisible(true);
            desktop.add(minD);
         }
      }
      else if(node.toString().equals("Max")) {
         MaxDialog maxD = MaxDialog.getInstance();
         if(!maxD.isVisible()) {
            maxD.setVisible(true);
            desktop.add(maxD);
         }
      }
      else if(node.toString().equals("AreaCircle")) {
         AreaCircleDialog areaD = AreaCircleDialog.getInstance();
         if(!areaD.isVisible()) {
            areaD.setVisible(true);
            desktop.add(areaD);
         }
      }
      else if(node.toString().equals("CircumferenceCircle")) {
         CircumferenceDialog circD = CircumferenceDialog.getInstance();
         if(!circD.isVisible()) {
            circD.setVisible(true);
            desktop.add(circD);
         }
      }
      else if(node.toString().equals("F2C")) {
         F2CDialog f2cD = F2CDialog.getInstance();
         if(!f2cD.isVisible()) {
            f2cD.setVisible(true);
            desktop.add(f2cD);
         }
      }
      else if(node.toString().equals("C2F")) {
         C2FDialog c2fD = C2FDialog.getInstance();
         if(!c2fD.isVisible()) {
            c2fD.setVisible(true);
            desktop.add(c2fD);
         }
      }
      
      //recursive
      else if(node.toString().equals("GCD")) {
         GCDDialog gcdD = GCDDialog.getInstance();
         if(!gcdD.isVisible()) {
            gcdD.setVisible(true);
            desktop.add(gcdD);
         }
      }
      else if(node.toString().equals("Fibonacci")) {
         FibonacciDialog fibD = FibonacciDialog.getInstance();
         if(!fibD.isVisible()) {
            fibD.setVisible(true);
            desktop.add(fibD);
         }
      }
      else if(node.toString().equals("Factorial")) {
         FactorialDialog factD = FactorialDialog.getInstance();
         if(!factD.isVisible()) {
            factD.setVisible(true);
            desktop.add(factD);
         }
      }
      //IO
      else if(node.toString().equals("File Info")) {
         ReadDialog rd = ReadDialog.getInstance();
         if(!rd.isVisible()) {
            rd.setVisible(true);
           desktop.add(rd);
         }
      }
   }
}