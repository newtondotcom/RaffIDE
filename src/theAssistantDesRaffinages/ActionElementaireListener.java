package theAssistantDesRaffinages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionElementaireListener implements ActionListener {
	
	private VueEditionRaffinages aireTexte;
	
	public ActionElementaireListener (VueEditionRaffinages aireTexte) {
		this.aireTexte = aireTexte;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = JOptionPane.showInputDialog("Entrez l'action elementaire");
		// TODO Prendre le niveau en compte
		ActionElementaire actionElem = new ActionElementaire(text,0);
		aireTexte.append(text);
		
		
		
	}

}
