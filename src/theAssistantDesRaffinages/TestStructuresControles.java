package theAssistantDesRaffinages;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestStructuresControles {
	 public static void main(String[] args) {
	        
	        // Création de la fenêtre
	        JFrame frame = new JFrame("Test StructuresControles");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 400);
	        
	        // Création de la classe StructuresControles
	        StructuresControles structuresControles = new StructuresControles();
	        
	        // Ajout de quelques boutons
	        JButton btn1 = new JButton("Bouton 1");
	        JButton btn2 = new JButton("Bouton 2");
	        JButton btn3 = new JButton("Bouton 3");
	        structuresControles.addStructure(btn1);
	        structuresControles.addStructure(btn2);
	        structuresControles.addStructure(btn3);
	        
	        // Récupération du JPanel avec les boutons
	        frame.add(structuresControles.getPanel());
	        
	        // Affichage de la fenêtre
	        frame.setVisible(true);
	    }
	}


