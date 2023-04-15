package theAssistantDesRaffinages;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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

import javax.swing.tree.TreePath;


// TEST COMMENTAIRE

public class VueListeRaffinages {
	private JTree tree;
	private JPopupMenu popupMenu;
	private JMenuItem ajouter, supprimer;
	 public VueListeRaffinages(){
	      this.tree = new JTree(new Hashtable<>(createTreeData()));

	      popupMenu = new JPopupMenu();
	      ajouter = new JMenuItem("Ajouter");
	      supprimer = new JMenuItem("Supprimer");
	      popupMenu.add(ajouter);
	      popupMenu.add(supprimer);
	      ActionListener actionListener = new PopupActionListener(tree);
	      ajouter.addActionListener(actionListener);
	      supprimer.addActionListener(actionListener);
	      tree.setComponentPopupMenu(popupMenu);

	      initPopupListener(tree, popupMenu);
	     

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
	      return Map.of("R1: Comment machin?",
	              new String[]{"R2: Faire truc1", "R2 :Manger des pates"},
	              "R1: Comment truc?",
	              new String[]{"BMW", "R2: Faire truc3", "Rolls-Royce"});
	  }

	  private static JFrame createFrame() {
	      JFrame frame = new JFrame("Popup On Shift + F10 Press");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setSize(new Dimension(500, 400));
	      return frame;
	  }

	public JScrollPane getScrollPane() {
		return new JScrollPane(this.tree);
	}
	}

 class PopupActionListener implements ActionListener {
	 private JTree arbre;
	 
		public PopupActionListener(JTree arb) {
			this.arbre = arb;
		}
	  public void actionPerformed(ActionEvent actionEvent) {
		  final Font currentFont = arbre.getFont();
		  final Font bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 2);
		  //arbre.setFont(bigFont);
		  TreePath path = arbre.getSelectionPath();
	    System.out.println("trace: " + path);
	  }
	}