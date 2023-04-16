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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

// TEST COMMENTAIRE

public class VueListeRaffinages {
	private JPopupMenu popupMenu;
	private JMenuItem ajouter, supprimer;
	private JTree tree;
	private static String ADD_COMMAND = "add";
	private static String REMOVE_COMMAND = "remove";
	
	
	public VueListeRaffinages() {
		popupMenu = new JPopupMenu();
		ajouter = new JMenuItem("Ajouter");
		supprimer = new JMenuItem("Supprimer");
		ajouter.setActionCommand(ADD_COMMAND);
		supprimer.setActionCommand(REMOVE_COMMAND);
		popupMenu.add(ajouter);
		popupMenu.add(supprimer);
		ActionListener actionListener = new PopupActionListener();
		ajouter.addActionListener(actionListener);
		supprimer.addActionListener(actionListener);
		initTree("");
		
	}
	
	public void initTree(String root) {
		ActionComplexe raffdef = new ActionComplexe(root,0);
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(raffdef);
		tree = new JTree(rootNode);
		tree.setComponentPopupMenu(popupMenu);
		initPopupListener(tree, popupMenu);
		tree.setVisible(false);
	}
	
	public void renameRoot(String newname) {
		ActionComplexe r0 = new ActionComplexe(newname,0);
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		root.setUserObject(r0);
		((DefaultTreeModel)tree.getModel()).nodeChanged(root);
		tree.setVisible(true);
	}
	

	private static void initPopupListener(JTree tree, JPopupMenu popupMenu) {
		popupMenu.addPopupMenuListener(new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// get selected node's rectangle
				Rectangle rect = tree.getPathBounds(tree.getSelectionPath());
				Arrays.stream(popupMenu.getComponents())
						.forEach(c -> c.setEnabled(rect != null));
				if (rect == null) {
					return;
				}

				Point p = new Point(rect.x + rect.width / 2,
						rect.y + rect.height);
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


	public JScrollPane getScrollPane() {
		return new JScrollPane(this.tree);
	}

	public void AddRaffinage(ActionComplexe raffinage,DefaultMutableTreeNode precedent) {
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		//DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(raffinage);
		model.insertNodeInto(child, precedent, precedent.getChildCount());
		tree.scrollPathToVisible(new TreePath(child.getPath()));
	}
	class PopupActionListener implements ActionListener {

		public PopupActionListener() {
			
		}

		public void actionPerformed(ActionEvent actionEvent) {
//			final Font currentFont = arbre.getFont();
//			final Font bigFont = new Font(currentFont.getName(),
//					currentFont.getStyle(), currentFont.getSize() + 2);
			// arbre.setFont(bigFont);
			
			String command = actionEvent.getActionCommand();
			
			TreePath path = tree.getSelectionPath();
			
			DefaultMutableTreeNode precedent = (DefaultMutableTreeNode) path.getLastPathComponent();
			ActionComplexe rprec = (ActionComplexe) precedent.getUserObject();
			if (ADD_COMMAND.equals(command)) {
				String titre = JOptionPane.showInputDialog("Entrez le Raffinage");
				ActionComplexe newRaff  = new ActionComplexe(titre,rprec.getNiveau()+1);
				AddRaffinage(newRaff,precedent);
			}
		}
	}

}

