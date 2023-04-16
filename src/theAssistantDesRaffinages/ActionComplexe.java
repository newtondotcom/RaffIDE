package theAssistantDesRaffinages;

import java.util.ArrayList;
import java.util.List;

public class ActionComplexe implements Action {

    private int niveau;
    private List<Element> sousFils;

    /* le contenu du bloc de texte */
    private String contenu;
    /* formats de texte à appliquer (par exemple, gras, italique, souligné)*/
    private List<TextFormat> formats;
    /* la couleur du texte à appliquer */
    private TextColor couleur;

//    public ActionComplexe (String contenu) {
//        this.contenu = contenu;
//        this.formats = new ArrayList<>();
//        this.couleur = TextColor.BLACK;
//    }
    
    public ActionComplexe (String titre, int niveau) {
        this.niveau = niveau;
        this.contenu = "R" + this.niveau + " : Comment " + titre + " ?";
        this.formats = new ArrayList<>();
        this.couleur = TextColor.BLACK;
    }

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

	public void addSousFils (Element nouveauSousFils) {
		this.sousFils.add(nouveauSousFils);
	}

	public void removeSousFils (Element sousFils) {
		this.sousFils.remove(sousFils);
	}

	public List<Element> getSousFils() {
		return sousFils;
	}

	public void setSousFils(List<Element> sousFils) {
		this.sousFils = sousFils;
	}

	@Override
	public void addFormat(TextFormat format) {
        this.formats.add(format);
    }

    @Override
	public void setCouleur(TextColor color) {
        this.couleur = color;
    }

    @Override
	public String getContenu() {
        return this.contenu;
    }

    /* @Override
    public void setContent(String content) {
        this.textArea.setText(content);
    }
   */

    @Override
	public String getTexteFormate() {
        StringBuilder formattedContent = new StringBuilder();

        if (this.couleur != TextColor.BLACK) {
            formattedContent.append(this.couleur.getCode());
        }

        for (TextFormat format : this.formats) {
            formattedContent.append(format.getCode());
        }

        formattedContent.append(this.contenu);

        if (this.couleur != TextColor.BLACK || !this.formats.isEmpty()) {
            formattedContent.append(TextFormat.RESET.getCode());
        }

        return formattedContent.toString();
    }

    @Override
	public void print() {
        System.out.println(this.getTexteFormate());
    }

	@Override
	public void removeFormat(TextFormat format) {
		 this.formats.remove(format);
	}

	@Override
	public TextColor getCouleur() {
		return this.couleur;
	}


}
