package theAssistantDesRaffinages;

import javax.swing.*;

public class ZoneTexte {
	
	private JTextArea textArea;
	private JButton boutonValider;
	private JButton boutonSupprimer;
	
	private JPanel panel;
	
	public ZoneTexte() {
		textArea = new JTextArea(100,100);
		boutonValider = new JButton("V");
		boutonSupprimer = new JButton("X");
		panel = new JPanel();
		panel.add(textArea);
		panel.add(boutonValider);
		panel.add(boutonSupprimer);
		
		
	}
	
	/**
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @return the boutonValider
	 */
	public JButton getBoutonValider() {
		return boutonValider;
	}

	/**
	 * @return the boutonSupprimer
	 */
	public JButton getBoutonSupprimer() {
		return boutonSupprimer;
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

}
