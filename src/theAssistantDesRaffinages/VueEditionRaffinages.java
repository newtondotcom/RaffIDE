package theAssistantDesRaffinages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class VueEditionRaffinages {
	private HashSet<String> structKeywords;
	
	/** Zone d'édition du raffinage actif */
	JTextPane edition;
	StyledDocument doc;
	
	/** la taille de la police  ( par defaut à 14 ) */
	private int fontSize = 14;
	
	/** La police d'ecriture */
	private Font police;
	
	/** Permet de pouvoir descendre dans la colonne */
	JScrollPane scrollEdition;
	
	/** identifiant du mot en cours dans la zone d'affichage **/
	private int currentWordId = 0;
	
	
	/** Le Raffinage courant */
	private ActionComplexe raffCourant;
	
	/**
	 * Creer un UI d'edition de raffinage
	 */
	public VueEditionRaffinages() {
		
		fontSize = 14;
		police = new Font("Monospaced", Font.PLAIN, fontSize);
		edition = new JTextPane();
		StyledDocument doc = edition.getStyledDocument();
		this.updateFontSize();
		scrollEdition = new JScrollPane(edition);
		
		edition.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int offset = edition.viewToModel(e.getPoint());
                javax.swing.text.Element element = (javax.swing.text.Element) doc.getCharacterElement(offset);
                AttributeSet attributeSet = ((javax.swing.text.Element) element).getAttributes();
                if (attributeSet.containsAttribute("clickable", true)) {
                    String type = (String) attributeSet.getAttribute("type");
                    String mot = (String) attributeSet.getAttribute("keyword");
                    int id = (int) attributeSet.getAttribute("id");
                    System.out.println(
                            String.format("Vous avez clické sur '%s',\n qui est un mot-clé de type '%s',\n avec comme id %d.\n",mot,type,(id)));
                }
            }
        });
		
		structKeywords = new HashSet<String>();
		String[] words =  {"Si", "Alors", "Sinon", "FinSi",
							"SinonSi", "TantQue", "FinTantQue",
							"Répéter", "FinRépéter"};
		for (String word:words) {
			structKeywords.add(word);
		}		
		
		// Permet de revenir à la ligne quand la fin de la TextArea est atteinte
		
	}
	
	public ActionComplexe getRaffCourant() {
		return this.raffCourant;
	}
	
	public void setRaffCourant(ActionComplexe raffCourant) {
		this.raffCourant = raffCourant;
	}

	public JScrollPane getScrollPane() {
		return this.scrollEdition;
	}

	/**
	 * decremente la taille de la police
	 * 
	 * @param decrement de combien faut-il diminuer la taille
	 */
	public void decreaseFontSize(int decrement) {
		if (this.fontSize - decrement > 1) {
			this.fontSize -= decrement;
		}
		this.updateFontSize();
	}
	/*
	 * Lors d'un click decremente la taille de la police de 0,5 
	 */
	public void decFontSizeOnClick() {
		if (this.fontSize >= 1) {
			this.fontSize--;
			this.updateFontSize();
		}
	}
	
	/*
	 * Lors d'un click augmente la taille de la police de 0,5 
	 */
	public void incFontSizeOnClick() {

		this.fontSize++;
		this.updateFontSize();
		
	}

	/**
	 * incremente la taille de la police
	 * 
	 * @param increment de combien faut-il augmenter la taille
	 */
	public void increaseFontSize(int increment) {
		if (this.fontSize + increment < 40) {
			this.fontSize += increment;
		}
		this.updateFontSize();
	}

	public void updateFontSize() {
		this.police = new Font("Monospaced", Font.PLAIN, fontSize);
		edition.setFont(police);
	}
	
	public void updateFontSize(int new_size) {
		this.police = new Font("Monospaced", Font.PLAIN, new_size);
		edition.setFont(police);
	}
	
	public JTextPane getTextArea() {
		return this.edition;
	}
	
	public void updatePolice(Font newPolice) {
		this.police = newPolice;
		edition.setFont(police);
	}
	
	public Font getPolice() {
		return this.police;
	}
	
	public int getFontSize() {
		return this.fontSize;
	}
	
	public void setFontSize(int newSize) {
		this.fontSize = newSize;
	}

	/**
	 * Ajoute un String à la zone de texte.
	 * @param stringToAppend
	 */
	public void append(String stringToAppend) {
		
		try{
		doc = edition.getStyledDocument();
		String[] mots = stringToAppend.split(" ");
		
		for (String mot:mots) {
			System.out.println(mot);
			String type = this.structKeywords.contains(mot.replaceAll("\n", "")) ? "structure" : "condition";
			doc.insertString(doc.getLength(), mot, createStyle(mot, type, currentWordId++));
		}
		
		}catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	private SimpleAttributeSet createStyle(String mot, String type, int id) {
        SimpleAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("clickable", true);
        switch(type) {
        case "structure":
        	style.addAttribute(StyleConstants.Foreground, Color.RED);
            style.addAttribute("emphasis", TextAttribute.WEIGHT_BOLD);
            break;
        default:
        	style.addAttribute(StyleConstants.Foreground, Color.BLUE);
            style.addAttribute("emphasis", TextAttribute.WEIGHT_LIGHT);
            break;
        }
        
        style.addAttribute("keyword", mot);
        style.addAttribute("type", type);
        style.addAttribute("id", id);
        return style;
    }

	public void update() {
		edition.setText(raffCourant.getTitreEntier() + '\n');
		this.append(raffCourant.toString());

		
	}
}
