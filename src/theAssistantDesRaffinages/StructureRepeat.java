package theAssistantDesRaffinages;

public class StructureRepeat extends StructureDeControle {
	private VueEditionRaffinages aireTexte;

	public StructureRepeat(String condition,String nom,VueEditionRaffinages textArea) {
		super(condition,nom);
		this.aireTexte = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "Faire :" ;
		for (Structure struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\nJusqu'À (" + this.getCondition() + ") \n";
		aireTexte.append(stringToAppend);
		System.out.println("Condition Répéter ajoutée!");

	}
}

