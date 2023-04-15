package theAssistantDesRaffinages;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.metal.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    /**
     * 
     */
    public Main() {
    	
        // Appliquer le look and feel Nimbus
        try {
          //  UIManager.setLookAndFeel(new SystemLookAndFeel());
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        

        //Zone d'edition des raffinages
        VueEditionRaffinages vueEdition = new VueEditionRaffinages();
        JScrollPane scrollEdition = vueEdition.getScrollPane();
        
        
        //Zone d'affichage de l'ensemble des raffinages
        VueListeRaffinages VueListe = new VueListeRaffinages();
        JScrollPane scrollAffichage = VueListe.getScrollPane();
        
        //Créer le menu
        Menu Menuframe = new Menu(vueEdition);
        
        //Récupérer le menu
        JMenuBar menuBarreBar = Menuframe.getJMenuBar();
        
        // Ajout de la partie structures de controles
       
        	// Creation de la liste des structures de controles
        	List<StructureDeControle> sdcs = new ArrayList<StructureDeControle>();
        	
        	// Creation de la structure de controle "Si"
        	StructureDeControle Si = new StructureSi(" ","Si",vueEdition);
        	sdcs.add(Si);
        	
        	// Creation de la Vue
        	VueStructuresDeControles vueStructures = new VueStructuresDeControles(sdcs);
        	JPanel structuresPanel = vueStructures.getPanel();
        
        //Creation du premier JSplitPane
        JSplitPane splitPaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollEdition,structuresPanel);
        //Valeur initiale
        splitPaneLeft.setResizeWeight(0.5);
        
        
        // Création du deuxieme JSplitPane
        JSplitPane splitPaneMiddle = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneLeft, scrollAffichage);
        
        //Valeur initiale
        splitPaneMiddle.setResizeWeight(0.5);
        
        // Ajout du conteneur à la fenêtre JFrame
        add(splitPaneMiddle);
        
        //Ajouter le menu à la fenêtre
        setJMenuBar(menuBarreBar);
        
        // Construction et injection de la barre d'outils
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.add( Menuframe.createToolBar(), BorderLayout.NORTH );

        // Paramètres de la fenêtre
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Main fenetre = new Main();
    }
}
