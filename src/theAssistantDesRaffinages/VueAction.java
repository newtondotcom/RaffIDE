package theAssistantDesRaffinages;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

public class VueAction {

	/** Le Panel */
	private JSplitPane actionPanel;
	
	/** Le Label (Titre) */
	private JLabel titleLabel;
	
	/** Reference a la zone d'edition des raffinages */
	private VueEditionRaffinages aireTexte;
	
	
	
	
	/**
	 * Creer un UI Structure de Controle
	 * @param sdcs La liste de structures suportees
	 */
	public VueAction(VueEditionRaffinages aireTexte) {
		
		this.aireTexte = aireTexte;
			
		// Initialisation du Panel
		JPanel titlePanel = new JPanel();
		JPanel boutonPanel = new JPanel(new FlowLayout());
		//structuresPanel.setLayout(new FlowLayout());
		
		// Ajout d'un Label
	    titleLabel = new JLabel("  Action  ");
	    Border blackBorder = BorderFactory.createLineBorder(Color.black);
	    titleLabel.setBorder(blackBorder);
	    titlePanel.add(titleLabel);
    
	    // ajout du bouton elementaire
	    JButton Boutonelem = new JButton("action élémentaire");
		Boutonelem.addActionListener(new ActionElementaireListener(aireTexte));
		boutonPanel.add(Boutonelem);
		
		//ajout du bouton complexe
		JButton Boutoncompl = new JButton("action complexe");
		Boutoncompl.addActionListener(new ActionComplexeListener());
		boutonPanel.add(Boutoncompl);
		
	    
	    // Séparation entre le titre et les boutons
        actionPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT,titlePanel,boutonPanel);
        //Valeur initiale
        actionPanel.setResizeWeight(0.05);
        
	    
 
	}
	
	/**
	 * Recuperer le Panel
	 * @return JPanel le panel
	 */
	public JSplitPane getPanel() {
		return this.actionPanel;
	}
	
}
