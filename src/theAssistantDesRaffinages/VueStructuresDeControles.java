package theAssistantDesRaffinages;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VueStructuresDeControles {
	private JPanel structuresPanel;
	private JLabel structuresLabel;
	
	public VueStructuresDeControles() {
	structuresPanel = new JPanel();
    structuresLabel = new JLabel("  Structures De Controles  ");
    Border blackBorder = BorderFactory.createLineBorder(Color.black);
    structuresLabel.setBorder(blackBorder);
    
    structuresPanel.add(structuresLabel);
    
    //Ajout des boutons
    //TODO
    
	}
	
	public JPanel getPanel() {
		return this.structuresPanel;
	}

}
