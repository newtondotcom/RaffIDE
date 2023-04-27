package theAssistantDesRaffinages;

public class StructurePour extends StructureDeControle {
	private VueEditionRaffinages aireTexte;

	public StructurePour(String nom, String var, String debut, String fin, VueEditionRaffinages textArea) {
		super(nom, var, debut, fin);
		this.aireTexte = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "Pour " + this.getVar() + "  De " + this.getDebut() + " À " + this.getFin() + " Faire :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct.toString();
		}
		stringToAppend += "\nFinPour\n";
		aireTexte.append(stringToAppend);
		System.out.println("Structure Pour ajoutée !");
	}
}