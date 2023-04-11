package theAssistantDesRaffinages;
import java.util.ArrayList;
import java.util.List;


public class ActionElementaire implements Action {

	 	/* le contenu du bloc de texte */
	    private String contenu;
	    /* formats de texte à appliquer (par exemple, gras, italique, souligné)*/
	    private List<TextFormat> formats;
	    /* la couleur du texte à appliquer */
	    private TextColor couleur;

	    public ActionElementaire (String contenu) {
	        this.contenu = contenu;
	        this.formats = new ArrayList<>();
	        this.couleur = TextColor.BLACK;
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

	  /*  @Override
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

