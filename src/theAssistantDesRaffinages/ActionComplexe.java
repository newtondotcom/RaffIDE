package theAssistantDesRaffinages;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * La classe ActionComplexe implémente Action 
 * et définit les méthodes pour gérer les raffinages à décomposer(formatage, couleur..)
 */
public class ActionComplexe implements Action {
	
	private int internalActionId;
	private int elementId;

    /* le niveau de raffinage de l'action. */
    private int niveau;
    
    /* les sous blocs de texte de l'action complexe (par exemple les structures de controle,
     *  les actions éléméntaires la décomposant..). */
    private HashMap<Integer, Element> elements;

    /* le titre de l'action. */
    private String titre;
    
    /* formats de texte à appliquer (gras, italique, souligné).*/
    private List<TextFormat> formats;
    
    /* la couleur du texte à appliquer. */
    private TextColor couleur;
    
    /* la couleur du surlignage */
    private Color surlignage;
    

    public ActionComplexe (VueEditionRaffinages textArea) {
        this.formats = new ArrayList<>();
        this.couleur = TextColor.BLACK;
        this.elements = new HashMap<>();


    }
    
    public ActionComplexe (String titre, int niveau) {
        this.formats = new ArrayList<>();
        this.titre = titre;
        this.couleur = TextColor.BLACK;
        this.elements = new HashMap<>();
        this.niveau = niveau;
        this.surlignage = Color.RED;

    }
    
    
    public ActionComplexe (String titre, int niveau,int id) {
        this.formats = new ArrayList<>();
        this.titre = titre;
        this.couleur = TextColor.BLACK;
        this.elements = new HashMap<>();
        this.niveau = niveau;
        this.surlignage = Color.RED;
        this.elementId = id;
    }
    
    
//gestion des niveaux
    @Override
    public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int incrementerNiveau (int niveau) {
		this.niveau += 1;
		return this.niveau;
	}
	


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	// gestion des elements
	public void addElement (Element newElement) {
		this.elements.put(this.getInternalActionId(), newElement);
	}

	public void removeElement (Element element) {
		this.elements.remove(element);
	}

	public HashMap<Integer, Element> getElements() {
		return elements;
	}

//gestion du format
	
	@Override
	public void addFormat(TextFormat format) {
        this.formats.add(format);
    }
	
	@Override
	public void removeFormat(TextFormat format) {
		 this.formats.remove(format);
	}

// gestion de la couleur
	
    @Override
	public void setCouleur(TextColor nouvelleCouleur) {
        this.couleur = nouvelleCouleur;
    }
    
	@Override
	public TextColor getCouleur() {
		return this.couleur;
	}
	
   
	public void setSurlignage(Color newSurlignage) {
        this.surlignage = newSurlignage;
 
    }
    

	public Color getSurlignage() {
		return this.surlignage;
	}
    
 // affichage
    
    @Override
	public String getTexteFormate() {
        StringBuilder formattedTitle = new StringBuilder();

        if (this.couleur != TextColor.BLACK) {
        	formattedTitle.append(this.couleur.getCode());
        }

        for (TextFormat format : this.formats) {
        	formattedTitle.append(format.getCode());
        }

        formattedTitle.append(this.titre);

        if (this.couleur != TextColor.BLACK || !this.formats.isEmpty()) {
        	formattedTitle.append(TextFormat.RESET.getCode());
        }

        return formattedTitle.toString();
    }

    private String surlignageToChar(Color color) {
    	if (color.equals(Color.GREEN)){
    		return "g";
    	} else if (color.equals(Color.ORANGE)){
    		return "o";
    	} else {
    		return "r";
    	}
    }

    @Override
	public void print() {
        System.out.println(this.getTexteFormate());
    }
    
    public String afficher() {
    	String titre;
    	titre = this.getTexteFormate() + "\n";
    	return titre;
    }
    
    public String getTitreEntier() {
        return "<0t>R" + this.niveau + " : Comment " + this.titre + " ?</0t>" ;
    }

    
    
  
    
    
    @Override
    public String toString() {
    	return toStringRecursif(this.getNiveau());
    }
    
    /**
     * Permet un traitement different de l'affichage d'une Action complexe, selon sa reference au niveau courant
     * @param niveau le niveau courant
     */
    public String toStringRecursif(int niveau) {
    	// Initialisation du string
    	String acString ="";
    	
    	// Si on est un raffinage plus profond, on affiche juste le titre de l'Action complexe
    	if (niveau == this.getNiveau() - 1) {
    		acString = "<" + this.elementId + "r" + surlignageToChar(this.surlignage) + ">" 
    				+ this.titre 
    				+ "</" + this.elementId + "r" + surlignageToChar(this.surlignage) + ">";
    	} else {
    		//Sinon, on affiche tout les elements contenu dans le raffinage
	    	for (Element element : this.elements.values()) {
	    		if (element instanceof ActionComplexe) {
	    			acString += ((ActionComplexe) element).toStringRecursif(niveau);
	    		} else {
	    			acString += element;
	    		}
	    	}
    	}
    	return acString;
    }
     
    
    public List<TextFormat> getFormats() {
    	return this.formats;
    }

	
	public boolean estVide() {
		return this.elements.isEmpty();
	}

	public void delElement(Element element) {
		elements.remove(element);
		
	}

	@Override
	public int getElementId() {
		return this.elementId;
	}

	@Override
	public void setElementId(int elt) {
		this.elementId = elt;
		
	}
	
	public int getInternalActionId() {
		return this.internalActionId++;
	}
	
	public void setInternalActionId(int id) {
		this.internalActionId = id;
	}

}
