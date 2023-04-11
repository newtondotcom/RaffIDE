package theAssistantDesRaffinages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class StructureDeControleListener implements ActionListener {
	private StructureDeControle sdc;

	public StructureDeControleListener(StructureDeControle sdc) {
		this.sdc = sdc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String condition = JOptionPane.showInputDialog("Entrez une condition");
		sdc.setCondition(condition);
		sdc.afficher();
	}

}