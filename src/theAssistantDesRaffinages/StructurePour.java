package theAssistantDesRaffinages;

public class StructurePour extends StructureDeControle {
	private VueEditionRaffinages aireTexte;

	public StructurePour(String nom,String var, String debut, String fin,VueEditionRaffinages textArea) {
		super(nom,var,debut,fin);
		this.aireTexte = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "Pour "+ this.getVar() + " De " + this.getDebut() + " À " + this.getFin() + " Faire" ;
		for (Structure struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\nFinPour\n";
		aireTexte.append(stringToAppend);
		System.out.println("Condition SI ajoutée!");
		
	}
}

