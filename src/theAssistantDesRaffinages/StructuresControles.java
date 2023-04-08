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
	// méthode pour ajouter une structure au panel
	public void addStructure(JButton structure) {
		structures.add(structure); // ajoute la structure à la liste
		panel.add(structure); // ajoute la structure au panel
	}

	// méthode pour obtenir le panel avec toutes les structures ajoutées
	public JPanel getPanel() {
		return panel;
	}

	// méthode pour obtenir la liste de structures ajoutées
	public List<JButton> getStructures() {
		return structures;
	}
	
		
	}
	
	
	

