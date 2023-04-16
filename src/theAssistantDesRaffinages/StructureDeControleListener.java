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
		if (sdc instanceof StructurePour) {
			/* À changer */
			String var = JOptionPane.showInputDialog("Entrez un nom de variable");
			sdc.setVar(var);
			String Debut = JOptionPane.showInputDialog("Entrez le début de la boucle");
			sdc.setDebut(Debut);
			String Fin = JOptionPane.showInputDialog("Entrez la fin de la boucle");
			sdc.setFin(Fin);
			sdc.afficher();
		}
		
		else {
			String condition = JOptionPane.showInputDialog("Entrez une condition");
			sdc.setCondition(condition);
			sdc.afficher();
		}
	}

}