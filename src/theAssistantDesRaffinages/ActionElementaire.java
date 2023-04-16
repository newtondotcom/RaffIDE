package theAssistantDesRaffinages;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe ActionElementaire implémente Action 
 * et définit les méthodes pour gérer les actions simples qui ne seront pas à raffiner après.
 */

public class ActionElementaire implements Action {

		/* le titre de l'action. */
	    private String titre;
	    /* le niveau de raffinage de l'action. */
	    private int niveau;
	    /* formats de texte à appliquer (gras, italique, souligné).*/
	    private List<TextFormat> formats;
	    /* la couleur du texte à appliquer. */
	    private TextColor couleur;

	    public ActionElementaire (String titre) {
	        this.titre = titre;
	        this.formats = new ArrayList<>();
	        this.couleur = TextColor.BLACK;
	    }

	    @Override
		public void addFormat(TextFormat format) {
	        this.formats.add(format);
	    }

	    @Override
		public void setCouleur(TextColor nouvelleCouleur) {
	        this.couleur = nouvelleCouleur;
	    }

	    @Override
		public String getTitre() {
	        return this.titre;
	    }

	  /*  @Override
	    public void setContent(String content) {
	        this.textArea.setText(content);
	    }
	   */
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

	    @Override
	    public String toString() {
	        return "R" + this.niveau + "  :  Comment " + this.titre + " ?" ;
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

