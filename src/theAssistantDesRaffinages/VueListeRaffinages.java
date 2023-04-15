package theAssistantDesRaffinages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;



public class VueListeRaffinages {

		
	
	  public static void main(String[] args) {
	      JTree tree = new JTree(new Hashtable<>(createTreeData()));

	      JPopupMenu popupMenu = new JPopupMenu();
	      JMenuItem ajouter = new JMenuItem("Ajouter");
	      JMenuItem supprimer = new JMenuItem("Supprimer");
	      popupMenu.add(ajouter);
	      popupMenu.add(supprimer);
	      ActionListener actionListener = new PopupActionListener();
	      ajouter.addActionListener(new PopupActionListener());
	      supprimer.addActionListener(new PopupActionListener());
	      tree.setComponentPopupMenu(popupMenu);

	      initPopupListener(tree, popupMenu);
	     

	      JFrame frame = createFrame();
	      tree.setPreferredSize(new Dimension(200, tree.getPreferredSize().height));
	      frame.add(new JScrollPane(tree), BorderLayout.WEST);
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	  }

	  private static void initPopupListener(JTree tree, JPopupMenu popupMenu) {
	      popupMenu.addPopupMenuListener(new PopupMenuListener() {
	          @Override
	          public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	              //get selected node's rectangle
	              Rectangle rect = tree.getPathBounds(tree.getSelectionPath());
	              Arrays.stream(popupMenu.getComponents()).forEach(c -> c.setEnabled(rect != null));
	              if (rect == null) {
	                  return;
	              }

	              Point p = new Point(rect.x + rect.width / 2, rect.y + rect.height);
	              SwingUtilities.convertPointToScreen(p, tree);
	              popupMenu.setLocation(p.x, p.y);
	          }

	          @Override
	          public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

	          }

	          @Override
	          public void popupMenuCanceled(PopupMenuEvent e) {

	          }
	      });
	  }

	  private static Map<?, ?> createTreeData() {
	      return Map.of("Sports",
	              new String[]{"Mustang", "Corvette", "Ferrari"},
	              "Luxury",
	              new String[]{"BMW", "Mercedes-Benz", "Rolls-Royce"});
	  }

	  private static JFrame createFrame() {
	      JFrame frame = new JFrame("Popup On Shift + F10 Press");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(new Dimension(500, 400));
	      return frame;
	  }

	public JScrollPane getScrollPane() {
		// TODO Auto-generated method stub
		return null;
	}
	}

 class PopupActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent actionEvent) {
	    System.out.println("trace: " + actionEvent.getActionCommand());
	  }
	}