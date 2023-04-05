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
	
	
	public void addStructure(JButton structure) {
		
	}
	
	
	
	
}
