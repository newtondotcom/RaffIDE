package theAssistantDesRaffinages;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class StructuresControles {
	private List<JButton> structures;
	private JPanel panel;
	
	public StructuresControles() {
		structures = new ArrayList<JButton>();
		panel = new JPanel();
		for (JButton structure : structures) {
			panel.add(structure);
		}
	}
	// m�thode pour ajouter une structure au panel
	public void addStructure(JButton structure) {
		structures.add(structure); // ajoute la structure � la liste
		panel.add(structure); // ajoute la structure au panel
	}

	// m�thode pour obtenir le panel avec toutes les structures ajout�es
	public JPanel getPanel() {
		return panel;
	}

	// m�thode pour obtenir la liste de structures ajout�es
	public List<JButton> getStructures() {
		return structures;
	}
	
		
	}
	
	
	

