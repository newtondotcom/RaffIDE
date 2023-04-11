package theAssistantDesRaffinages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class VueStructuresDeControles {
	private JPanel structuresPanel;
	private JLabel structuresLabel;
	private List<StructureDeControle> sdcs;
	private List<JButton> boutonsSdc;
	
	
	public VueStructuresDeControles(List<StructureDeControle> sdcs) {
		this.sdcs = sdcs;
		this.boutonsSdc = new ArrayList<JButton>();
		structuresPanel = new JPanel();
	    structuresLabel = new JLabel("  Structures De Controles  ");
	    Border blackBorder = BorderFactory.createLineBorder(Color.black);
	    structuresLabel.setBorder(blackBorder);
	   
	    structuresPanel.add(structuresLabel);
    
	    for (StructureDeControle sdc : this.sdcs) {
		   JButton newBouton = new JButton("Si");
		   newBouton.addActionListener(new StructureDeControleListener(sdc));
		   boutonsSdc.add(newBouton);
		   structuresPanel.add(newBouton);
	    }	
 
	}
	
	
	public JPanel getPanel() {
		return this.structuresPanel;
	}
	
}
