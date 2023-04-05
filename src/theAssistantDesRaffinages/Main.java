package theAssistantDesRaffinages;

import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
	public static void main(String[] args) throws Exception {
		// belle interface 
		
		UIManager.setLookAndFeel( new NimbusLookAndFeel() );
		
		System.out.println("Hello World!");
		JFrame frame = new JFrame("Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        //gère les affichages des raffinages en cours (lecture et modification)
        ZoneTexte principale = new ZoneTexte();
        	
        frame.add(principale.getPanel(), BorderLayout.WEST);
        
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setCursor(new Cursor(1));
        
        Menu Menuframe = new Menu();
        Menuframe.setVisible(true);
	}
}