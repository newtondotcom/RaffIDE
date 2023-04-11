package theAssistantDesRaffinages;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class VueStructuresDeControles {
	
	/** Le Panel */
	private JPanel structuresPanel;
	
	/** Le Label (Titre) */
	private JLabel structuresLabel;
	
	/** La liste de structure de controle */
	private List<StructureDeControle> sdcs;
	
	/** La liste de boutons*/
	private List<JButton> boutonsSdc;
	
	/**
	 * Creer un UI Structure de Controle
	 * @param sdcs La liste de structures suportees
	 */
	public VueStructuresDeControles(List<StructureDeControle> sdcs) {
	
		// Initialisations des Listes
		this.sdcs = sdcs;
		this.boutonsSdc = new ArrayList<JButton>();
		
		// Initialisation du Panel
		structuresPanel = new JPanel();
		
		// Ajout d'un Label
	    structuresLabel = new JLabel("  Structures De Controles  ");
	    Border blackBorder = BorderFactory.createLineBorder(Color.black);
	    structuresLabel.setBorder(blackBorder);
	    structuresPanel.add(structuresLabel);
    
	    // Creer un Bouton pour chaque structure de controle
	    for (StructureDeControle sdc : this.sdcs) {
		   JButton newBouton = new JButton(sdc.getNom());
		   newBouton.addActionListener(new StructureDeControleListener(sdc));
		   boutonsSdc.add(newBouton);
		   structuresPanel.add(newBouton);
	    }	
 
	}
	
	/**
	 * Recuperer le Panel
	 * @return JPanel le panel
	 */
	public JPanel getPanel() {
		return this.structuresPanel;
	}
	
}
