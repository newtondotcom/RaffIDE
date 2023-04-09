package theAssistantDesRaffinages;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VueEditionRaffinages {
	// Zone d'édition du raffinage actif
	JTextArea edition;
	private int fontSize;
	private Font police;
	// Permet de pouvoir descendre dans la colonne
	JScrollPane scrollEdition;

	public VueEditionRaffinages() {
		fontSize = 14;
		police = new Font("Monospaced", Font.PLAIN, fontSize);
		edition = new JTextArea();
		this.updateFontSize();
		scrollEdition = new JScrollPane(edition);
		edition.addFocusListener(new BasicEditorListener());
		
		// Permet de revenir à la ligne quand la fin de la TextArea est atteinte
		edition.setWrapStyleWord(true);
		edition.setLineWrap(true);
	}

	public JScrollPane getScrollPane() {
		return this.scrollEdition;
	}

	/**
	 * decremente la taille de la police
	 * 
	 * @param decrement de combien faut-il diminuer la taille
	 */
	public void decreaseFontSize(int decrement) {
		if (this.fontSize - decrement > 1) {
			this.fontSize -= decrement;
		}
		this.updateFontSize();
	}

	/**
	 * incremente la taille de la police
	 * 
	 * @param increment de combien faut-il augmenter la taille
	 */
	public void increaseFontSize(int increment) {
		if (this.fontSize + increment < 40) {
			this.fontSize += increment;
		}
		this.updateFontSize();
	}

	public void updateFontSize() {
		edition.setFont(police);
	}
}
