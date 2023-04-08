package theAssistantDesRaffinages;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestStructuresControles {
	 public static void main(String[] args) {
	        
	        // Cr�ation de la fen�tre
	        JFrame frame = new JFrame("Test StructuresControles");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 400);
	        
	        // Cr�ation de la classe StructuresControles
	        StructuresControles structuresControles = new StructuresControles();
	        
	        // Ajout de quelques boutons
	        JButton btn1 = new JButton("Bouton 1");
	        JButton btn2 = new JButton("Bouton 2");
	        JButton btn3 = new JButton("Bouton 3");
	        structuresControles.addStructure(btn1);
	        structuresControles.addStructure(btn2);
	        structuresControles.addStructure(btn3);
	        
	        // R�cup�ration du JPanel avec les boutons
	        frame.add(structuresControles.getPanel());
	        
	        // Affichage de la fen�tre
	        frame.setVisible(true);
	    }
	}


