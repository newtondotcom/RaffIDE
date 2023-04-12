package theAssistantDesRaffinages;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VueListeRaffinages {
	private JTextArea affichage; 
	private JScrollPane scrollAffichage; 
	
	public VueListeRaffinages() {
		affichage = new JTextArea();
	    scrollAffichage = new JScrollPane(affichage);
	    affichage.setWrapStyleWord(true);
	    affichage.setLineWrap(true);
	}
	
	public JScrollPane getScrollPane() {
		return this.scrollAffichage;
	}

}
