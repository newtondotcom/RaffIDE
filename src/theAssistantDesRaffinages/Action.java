package theAssistantDesRaffinages;

public interface Action extends Element {
	
	/**
	 * Ajouter un format de texte à l'action.
	 * @param format TextFormat
	 */
    public void addFormat(TextFormat format);
    
	/**
	 * Enlever le format de texte existant de l'action.
	 * @param format TextFormat
	 */
    public void removeFormat(TextFormat format);
    
	/**
	 * Obtenir la couleur de texte de l'action.
	 * @return  couleur de texte
	 */
    public TextColor getCouleur();
    
	/**
	 * Changer la couleur de texte de l'action.
	 * @param nouvelle couleur de texte
	 */
    public void setCouleur(TextColor nouvelleCouleur);
    
	/**
	 * Obtenir le titre de l'action.
	 * @return titre de l'action
	 */
    public String getTitre();
    
	/**
	 * Obtenir le titre de l'action formaté(Application des couleurs et formats au texte).
	 * @return titre formaté de l'action
	 */
    public String getTexteFormate();
    
	/**
	 * Afficher le titre formaté de l'action dans la console.
	 */
    public void print();
    
    public String toString();
}

