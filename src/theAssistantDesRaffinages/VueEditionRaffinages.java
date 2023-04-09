package theAssistantDesRaffinages;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VueEditionRaffinages {
    //Zone d'édition du raffinage actif
	JTextArea edition;
	
	//Permet de pouvoir descendre dans la colonne
    JScrollPane scrollEdition;
	
	public VueEditionRaffinages() {
	    edition = new JTextArea();
	    scrollEdition = new JScrollPane(edition);
	    edition.addFocusListener(new BasicEditorListener());
	    
	    //Permet de revenir à la ligne quand la fin de la TextArea est atteinte
	    edition.setWrapStyleWord(true);
	    edition.setLineWrap(true);
	}
	
	public JScrollPane getScrollPane() {
		return this.scrollEdition;
	}
}
