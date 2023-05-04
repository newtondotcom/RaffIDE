package theAssistantDesRaffinages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class ActionComplexeListener implements ActionListener{

	private VueEditionRaffinages vueEdition;
	private  VueListeRaffinages vueListe ;

	/** Creer un observateur de l'action */
	public ActionComplexeListener (VueEditionRaffinages vueEdition, VueListeRaffinages vueListe ) {
		this.vueListe = vueListe;
		this.vueEdition = vueEdition;

	}
	
	/**
	 * Action se declanchant lorsque l'on appuie sur le bouton
	 * @param e L'evenement (appuyer sur le bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("bouton action complexe clické \n");
		String titre = JOptionPane.showInputDialog("Entrez une action complexe");
		ActionComplexe action = new ActionComplexe(vueEdition);
		action.setTitre(titre);
		if (titre != null) {
			//action.toString();
			//action.afficher();
			// Recuperation du chemin
	        TreePath path = this.vueListe.getTree().getSelectionPath();
	        
	        // Recuperation du noeud courant et parent
	        DefaultMutableTreeNode courant = (DefaultMutableTreeNode) path.getLastPathComponent();
	        
	        // Recuperation du raffinage courant
	        ActionComplexe raffinageCourant = (ActionComplexe) courant.getUserObject();
			action.setNiveau(raffinageCourant.getNiveau() + 1);
            this.vueListe.AddRaffinage(action, courant);
            //this.vueEdition.getRaffCourant().addElement(action);
            //this.vueEdition.update();
			
		}
	}
	


}
