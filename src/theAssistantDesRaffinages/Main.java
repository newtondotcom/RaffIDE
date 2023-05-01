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
        VueListeRaffinages vueListe = new VueListeRaffinages();
        JScrollPane scrollAffichage = vueListe.getScrollPane();
        
        
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
        	
        	// Creation de la structure de controle "TantQue"
        	StructureDeControle Tq = new StructureTantque(" ","Tant que",vueEdition);
        	sdcs.add(Tq);
        	
        	// Creation de la structure de controle "Repeat"
        	StructureDeControle loop = new StructureRepeat(" ","Répéter",vueEdition);
        	sdcs.add(loop);
        	
        	// Creation de la structure de controle "Pour"
        	StructureDeControle pour = new StructurePour("Pour"," "," "," ",vueEdition);
        	sdcs.add(pour);
        	
        	// Creation de la Vue
        	VueStructuresDeControles vueStructures = new VueStructuresDeControles(sdcs);
        	JSplitPane structuresPanel = vueStructures.getPanel();
        	
        // Création des bouton pour les actions complexe/élémentaire
        VueAction vueActions = new VueAction(vueEdition, vueListe);
        JSplitPane actionPanel = vueActions.getPanel();
        
        //Séparation des deux fenetre action et structure de controle 
        	//Creation du premier JSplitPane
        	JSplitPane splitPanebouton = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,structuresPanel,actionPanel);
        	//Valeur initiale
        	splitPanebouton.setResizeWeight(0.5);
        
        //Creation du premier JSplitPane
        JSplitPane splitPaneLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT,scrollEdition,splitPanebouton);
        //Valeur initiale
        splitPaneLeft.setResizeWeight(0.8);
        
        
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
        
        String r0 = JOptionPane.showInputDialog("Entrez R0");
        vueListe.changeRoot(r0);
        //vueActions.changeRoot(r0);
        
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Main fenetre = new Main();
    }
}
