package theAssistantDesRaffinages;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * La classe ActionComplexe implémente Action 
 * et définit les méthodes pour gérer les raffinages à décomposer(formatage, couleur..)
 */
public class ActionComplexe implements Action {
	
    /* le niveau de raffinage de l'action. */
    private int niveau;
    /* les sous blocs de texte de l'action complexe (par exemple les structures de controle,
     *  les actions éléméntaires la décomposant..). */
    private LinkedList<Element> elements;

    /* le titre de l'action. */
    private String titre;
    /* formats de texte à appliquer (gras, italique, souligné).*/
    private List<TextFormat> formats;
    /* la couleur du texte à appliquer. */
    private TextColor couleur;
    

    public ActionComplexe (VueEditionRaffinages textArea) {
        this.formats = new ArrayList<>();
        this.couleur = TextColor.BLACK;
        this.elements = new LinkedList<>();


    }
    
    public ActionComplexe (String titre, int niveau) {
        this.formats = new ArrayList<>();
        this.titre = titre;
        this.couleur = TextColor.BLACK;
        this.elements = new LinkedList<>();
        this.niveau = niveau;

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
		this.elements.add(newElement);
	}

	public void removeElement (Element element) {
		this.elements.remove(element);
	}

	public LinkedList<Element> getElements() {
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
        return "R" + this.niveau + "  :  Comment " + this.titre + " ?" ;
    }

    @Override
    public String toString() {
    	return toStringRecursif(this.getNiveau());
    }
    
    public String toStringRecursif(int niveau) {
    	String acString ="";
    	if (niveau == this.getNiveau() - 1) acString += this.titre + "\n";
    	for (Element element : this.elements) {
    		if (element instanceof ActionComplexe) {
    			acString += ((ActionComplexe) element).toStringRecursif(niveau);
    		} else {
    			acString += element;
    		}
    	}
    	return acString;
    }



}
