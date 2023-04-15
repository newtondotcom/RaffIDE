package theAssistantDesRaffinages;

public class StructureTantque extends StructureDeControle {
	private VueEditionRaffinages aireTexte;

	public StructureTantque(String condition,String nom,VueEditionRaffinages textArea) {
		super(condition,nom);
		this.aireTexte = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "TantQue (" + this.getCondition() + ") Faire :" ;
		for (Structure struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\nFinTQ\n";
		aireTexte.append(stringToAppend);
		System.out.println("Condition TQ ajoutée!");
		
	}
}


