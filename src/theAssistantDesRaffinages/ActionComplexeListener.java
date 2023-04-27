package theAssistantDesRaffinages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionComplexeListener implements ActionListener{

	/** L'action complexe */
	private ActionComplexe action;
	private VueEditionRaffinages vueEdition;

	/** Creer un observateur de l'action */
	public ActionComplexeListener (VueEditionRaffinages vueEdition) {
		this.action = new ActionComplexe(vueEdition);
	}
	
	/**
	 * Action se declanchant lorsque l'on appuie sur le bouton
	 * @param e L'evenement (appuyer sur le bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("bouton action complexe clické \n");
		String titre = JOptionPane.showInputDialog("Entrez une action complexe");
		this.action.setTitre(titre);
		if (titre != null) {
			this.action.afficher();
		}
	}

}
