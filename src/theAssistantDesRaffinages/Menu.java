package theAssistantDesRaffinages;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.io.File;
import java.io.IOException;
 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;



@SuppressWarnings("serial")
public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private VueEditionRaffinages vueEdition;
    
    private JLabel fontSizeLabel;
    
	/* Construction de l'interface graphique */
    public Menu(VueEditionRaffinages vueEdition) {
        super( "Ra77ineur" );
        this.vueEdition = vueEdition;
        this.setSize(600,400);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
   
        // Construction et injection de la barre de menu
        this.setJMenuBar( this.createMenuBar() );

        // Construction et injection de la barre d'outils
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.add( this.createToolBar(), BorderLayout.NORTH );
        
       
      
    }

    /* Methode de construction de la barre de menu */
    public JMenuBar createMenuBar() {

        // La barre de menu à proprement parler
        JMenuBar menuBar = new JMenuBar();

        // Définition du menu déroulant "File" et de son contenu
        JMenu mnuFile = new JMenu( "File" );
        mnuFile.setMnemonic( 'F' );

        /*JMenuItem mnuNewFile =*/ 
        mnuFile.add( actNew );
        mnuFile.addSeparator();
        mnuFile.add( actOpen );
        mnuFile.add( actSave );
        mnuFile.add( actSaveAs );
        mnuFile.addSeparator();
        mnuFile.add( actExit );
       
        
        menuBar.add(mnuFile);
        
        // Définition du menu déroulant "Edit" et de son contenu
        JMenu mnuEdit = new JMenu( "Edit" );
        mnuEdit.setMnemonic( 'E' );
        
        mnuEdit.add( actUndo );
        mnuEdit.add( actRedo );
        mnuEdit.addSeparator();
        mnuEdit.add( actCopy );
        mnuEdit.add( actCut );
        mnuEdit.add( actPaste );

        menuBar.add(mnuEdit);

        // Définition du menu déroulant "Help" et de son contenu
        JMenu mnuHelp = new JMenu( "Help" );
        mnuHelp.setMnemonic( 'H' );
        
        menuBar.add( mnuHelp );
        
        return menuBar;
    }

    /* Methode de construction de la barre d'outils */
    public JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        toolBar.add( actNew ).setHideActionText( true );
        toolBar.addSeparator();
        toolBar.add( actOpen ).setHideActionText( true );
        toolBar.add( actSave ).setHideActionText( true );
        toolBar.add( actSaveAs ).setHideActionText( true );
        
        
       

        /* Ajout pour pouvoir changer police d'ecriture */
        
        // Créer une liste de noms de police disponibles
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        // Créer la JComboBox pour sélectionner une police
        JComboBox<String> police = new JComboBox<>(fonts);
        police.setMaximumSize(new Dimension(150, police.getPreferredSize().height)); // ajuster la taille de la JComboBox
        police.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fontName = (String) police.getSelectedItem();
                Font font = new Font(fontName, Font.PLAIN, vueEdition.getFontSize());
                vueEdition.updatePolice(font);
            }
        });

        // Ajouter la JComboBox à la JToolBar
        toolBar.add(police);

        
     // Créer un JLabel pour afficher la taille de police courante
        
        toolBar.add(incFontSizeButton).setHideActionText(true);;
        toolBar.add(decFontSizeButton).setHideActionText(true);;
        //toolBar.add(fontSizeLabel);

     
        
        
        toolBar.add(actZoomIn).setHideActionText(true);
        toolBar.add(actZoomOut).setHideActionText(true);
        toolBar.addSeparator();
        toolBar.add( actExit ).setHideActionText( true );
       
        return toolBar;
    }

    
    
    /* Nos diverses actions */
    private AbstractAction actNew = new AbstractAction() {  
        {
            putValue( Action.NAME, "New File..." );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/new.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_N );
            putValue( Action.SHORT_DESCRIPTION, "New file (CTRL+N)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "New" );
        }
    };

    private AbstractAction actOpen = new AbstractAction() {  
        {
            putValue( Action.NAME, "Open File..." );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/open.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_O );
            putValue( Action.SHORT_DESCRIPTION, "Open file (CTRL+O)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Open" );
        }
    };

    private AbstractAction actSave = new AbstractAction() {  
        {
            putValue( Action.NAME, "Save File" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/save.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_S );
            putValue( Action.SHORT_DESCRIPTION, "Save file (CTRL+S)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Save" );
            
        }
    };
   
    private AbstractAction actSaveAs = new AbstractAction() {  
        {
            putValue( Action.NAME, "Save As..." );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/save_as.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_A );
            putValue( Action.SHORT_DESCRIPTION, "Save file" );
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Save as" );
            // Créer un objet JFileChooser pour permettre à l'utilisateur de sélectionner un emplacement et un nom de fichier
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save as"); // Titre de la boîte de dialogue
            fileChooser.setFileFilter(new FileNameExtensionFilter("JSON Files", "json")); // Filtrer les fichiers pour afficher uniquement les fichiers .json
            
            // Afficher la boîte de dialogue pour que l'utilisateur sélectionne l'emplacement et le nom du fichier à enregistrer
            int userSelection = fileChooser.showSaveDialog(null); 
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Si l'utilisateur a sélectionné un emplacement et un nom de fichier, récupérer le fichier sélectionné
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".json")) {
                    // Si le nom de fichier ne se termine pas par .json, ajouter l'extension .json
                    fileToSave = new File(filePath + ".json");
                }
            }
            // TODO enregistrer le fichier qu'on veut ( en .json ) 
            
            
        }
    };
   
    private AbstractAction actExit = new AbstractAction() {  
        {
            putValue( Action.NAME, "Exit" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/exit.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_X );
            putValue( Action.SHORT_DESCRIPTION, "Exit (ALT+F4)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Exit" );
            dispose();
        }
    };

    private AbstractAction actUndo = new AbstractAction() {  
        {
            putValue( Action.NAME, "Undo" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/undo.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_U );
            putValue( Action.SHORT_DESCRIPTION, "Undo (CTRL+Z)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Undo" );
        }
    };

    private AbstractAction actRedo = new AbstractAction() {  
        {
            putValue( Action.NAME, "Redo" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/redo.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_R );
            putValue( Action.SHORT_DESCRIPTION, "Redo (CTRL+U)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Redo" );
        }
    };
    
    private AbstractAction actZoomIn = new AbstractAction() {  
        {
            putValue( Action.NAME, "Bigger" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/ZoomIn.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_C );
            putValue( Action.SHORT_DESCRIPTION, "Zoom In" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.VK_PLUS ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            vueEdition.increaseFontSize(2);
        }
    };
    
    private AbstractAction actZoomOut = new AbstractAction() {  
        {
            putValue( Action.NAME, "Smaller" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/ZoomOut.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_C );
            putValue( Action.SHORT_DESCRIPTION, "Zoom Out" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.VK_MINUS ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	vueEdition.decreaseFontSize(2);
        }
    };
    
    private AbstractAction actCopy = new AbstractAction() {  
        {
            putValue( Action.NAME, "Copy" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/copy.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_C );
            putValue( Action.SHORT_DESCRIPTION, "Copy (CTRL+C)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Copy" );
        }
    };

    private AbstractAction actCut = new AbstractAction() {  
        {
            putValue( Action.NAME, "Cut" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/cut.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_T );
            putValue( Action.SHORT_DESCRIPTION, "Cut (CTRL+X)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Cut" );
        }
    };

	private AbstractAction actPaste = new AbstractAction() {  
        {
            putValue( Action.NAME, "Paste" );
            putValue( Action.SMALL_ICON, new ImageIcon( "icons/paste.png" ) );
            putValue( Action.MNEMONIC_KEY, KeyEvent.VK_P );
            putValue( Action.SHORT_DESCRIPTION, "Paste (CTRL+V)" );
            putValue( Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK ) ); 
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
            System.out.println( "Paste" );
        }
   
    
    };
    
    
    

	
    
    private AbstractAction actPoliceTimes = new AbstractAction() {  
        {
            putValue( Action.NAME, "Times New Roman" );
           
           
     
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	int taille = vueEdition.getFontSize();
        	Font police = new Font("Times New Roman", Font.PLAIN, taille);
        	vueEdition.updatePolice(police);
        }

		
    
    };
    
    private AbstractAction actPoliceArial = new AbstractAction() {  
        {
            putValue( Action.NAME, "Arial" );
           
           
     
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	int taille = vueEdition.getFontSize();
        	Font police = new Font("Arial", Font.PLAIN, taille);
        	vueEdition.updatePolice(police);
        }

		
    
    };
    
    private AbstractAction actPoliceCourier = new AbstractAction() {  
        {
            putValue( Action.NAME, "Courier New" );
           
           
     
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	int taille = vueEdition.getFontSize();
        	Font police = new Font("Courier New", Font.PLAIN, taille);
        	vueEdition.updatePolice(police);
        }

		
    
    };
    
    
    private AbstractAction incFontSizeButton = new AbstractAction() {  
        {
            putValue( Action.NAME, "+" );
           
           
     
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	vueEdition.incFontSizeOnClick();
        	fontSizeLabel = new JLabel("Taille : " + vueEdition.getFontSize());
        }

		
    
    };
   
    private AbstractAction decFontSizeButton = new AbstractAction() {  
        {
            putValue( Action.NAME, "-" );
           
           
     
        }
        
        @Override public void actionPerformed( ActionEvent e ) {
        	vueEdition.decFontSizeOnClick();
        	fontSizeLabel = new JLabel("Taille : " + vueEdition.getFontSize());
        }

		
    
    };


    
    public void mnuNewListener( ActionEvent event ) {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }
}
    