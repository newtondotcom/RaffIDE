package theAssistantDesRaffinages;
import theAssistantDesRaffinages.VueListeRaffinages;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class VueAction {

	/** Le Panel */
	private JSplitPane actionPanel;
	
	/** Le Label (Titre) */
	private JLabel titleLabel;
	
	/** La JTree contenant les raffinages */
	private JTree tree;
	
	
	
	
	/**
	 * Creer un UI Structure de Controle
	 * @param sdcs La liste de structures suportees
	 */
	public VueAction(VueEditionRaffinages vueEdition, VueListeRaffinages vueListe) {
		
		// Initialisation du Panel
		JPanel titlePanel = new JPanel();
		JPanel boutonPanel = new JPanel(new FlowLayout());
		//structuresPanel.setLayout(new FlowLayout());
		
		// Ajout d'un Label
	    titleLabel = new JLabel("  Action  ");
	    Border blackBorder = BorderFactory.createLineBorder(Color.black);
	    titleLabel.setBorder(blackBorder);
	    titlePanel.add(titleLabel);
    
	    // ajout du bouton elementaire
	    JButton Boutonelem = new JButton("action élémentaire");
		Boutonelem.addActionListener(new ActionElementaireListener(vueEdition));
		boutonPanel.add(Boutonelem);
		
		//ajout du bouton complexe
		// Initialisation de la JTree avec une racine vide
		//initTree("");
		JButton Boutoncompl = new JButton("action complexe");
		//AddRaffinage(ActionComplexe raffinage, DefaultMutableTreeNode precedent);
		Boutoncompl.addActionListener(new ActionComplexeListener(vueEdition, vueListe));
		boutonPanel.add(Boutoncompl);
		
		
	    
	    // Séparation entre le titre et les boutons
        actionPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT,titlePanel,boutonPanel);
        //Valeur initiale
        actionPanel.setResizeWeight(0.05);
  
 
	}
	/**
	 * Initialise la JTree avec la racine spécifiée.
	 * @param root La chaîne représentant la racine de la JTree.
	 */
	public void initTree(String root) {
		// Création de l'élément racine avec un ActionComplexe contenant la
		// chaîne spécifiée
		ActionComplexe raffdef = new ActionComplexe(root, 0);
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(raffdef);

		// Création de la JTree avec l'élément racine
		tree = new JTree(rootNode);

		// Assignation du menu contextuel à la JTree
		//tree.setComponentPopupMenu(popupMenu);

		// Initialisation de l'écouteur pour les événements du menu contextuel
		//initPopupListener(tree, popupMenu);

		// La JTree est initialement cachée
		tree.setVisible(false);
	}

	/**
	 * Changer la racine de la JTree.
	 * @param newname Le nouveau nom de la racine
	 */
	public void changeRoot(String newname) {
		// Creation de l'action complexe
		ActionComplexe r0 = new ActionComplexe(newname, 0);

		// Recuperation de la racine
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel()
				.getRoot();

		// Changement d'objet
		root.setUserObject(r0);

		// Mise a jour
		((DefaultTreeModel) tree.getModel()).nodeChanged(root);
		tree.setVisible(true);
	}
	
	/**
	 * Recuperer le Panel
	 * @return JPanel le panel
	 */
	public JSplitPane getPanel() {
		return this.actionPanel;
	}
	
}
