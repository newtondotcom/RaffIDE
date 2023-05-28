package theAssistantDesRaffinages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionElementaireListener implements ActionListener {
	
	/** L'action élémentaire */
	//private ActionElementaire action;
	private VueEditionRaffinages vueEdition;

	/** Creer un observateur de l'action */
	public ActionElementaireListener(VueEditionRaffinages vueEdition) {
		//this.action = new ActionElementaire(vueEdition);
		this.vueEdition = vueEdition;
	}
	
	/**
	 * Action se declanchant lorsque l'on appuie sur le bouton
	 * @param e L'evenement (appuyer sur le bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("bouton action élémentaire clické \n");
		String titre = JOptionPane.showInputDialog("Entrez une action élémentaire");
		ActionElementaire action = new ActionElementaire(vueEdition);
		action.setTitre(titre);
		action.setElementId(this.vueEdition.incrementerEltCourant());
		if (titre != null) {
			//action.toString();
			this.vueEdition.getRaffCourant().addElement(action);
            this.vueEdition.update();
		}
		
	}

}
