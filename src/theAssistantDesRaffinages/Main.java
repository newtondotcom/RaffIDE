package theAssistantDesRaffinages;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main extends JFrame {

    public Main() {
    	
        // Appliquer le look and feel Nimbus
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        //Créer le menu
        Menu Menuframe = new Menu();
        
        //Récupére le menu
        JMenuBar menuBarreBar = Menuframe.getJMenuBar();

        // Création du conteneur
        JPanel conteneur = new JPanel();

        // Ajout des zones de texte au conteneur
        //Zone d'édition du raffinage actif
        JTextArea edition = new JTextArea();
        //Permet de pouvoir descendre dans la colonne
        JScrollPane scrollEdition = new JScrollPane(edition);
        //Permet de revenir à la ligne quand la fin de la TextArea est atteinte
        edition.setWrapStyleWord(true);
        edition.setLineWrap(true);
        
        //Zone d'affichage de l'ensemble des raffinages
        JTextArea affichage = new JTextArea();
        JScrollPane scrollAffichage = new JScrollPane(affichage);
        affichage.setWrapStyleWord(true);
        affichage.setLineWrap(true);
        
        // Création du JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollEdition, scrollAffichage);
        //Valeur initiale
        splitPane.setResizeWeight(0.5);

        // Ajout du conteneur à la fenêtre JFrame
        add(splitPane);
        
        //Ajouter le menu à la fenêtre
        setJMenuBar(menuBarreBar);

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
