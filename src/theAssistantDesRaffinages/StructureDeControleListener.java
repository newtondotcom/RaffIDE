package theAssistantDesRaffinages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class StructureDeControleListener implements ActionListener {
	
	/** La structure de controle a observer */
	private StructureDeControle sdc;

	/** Creer un observateur de structure de controle */
	public StructureDeControleListener(StructureDeControle sdc) {
		this.sdc = sdc;
	}
	
	/**
	 * Action se declanchant lorsque l'on appuie sur le bouton
	 * @param e L'evenement (appuyer sur le bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String condition = JOptionPane.showInputDialog("Entrez une condition");
		sdc.setCondition(condition);
		sdc.afficher();
	}

}