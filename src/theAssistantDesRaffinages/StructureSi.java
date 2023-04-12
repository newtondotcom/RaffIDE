package theAssistantDesRaffinages;



public class StructureSi extends StructureDeControle {
	private VueEditionRaffinages aireTexte;

	public StructureSi(String condition,String nom,VueEditionRaffinages textArea) {
		super(condition,nom);
		this.aireTexte = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "Si (" + this.getCondition() + ") Alors :" ;
		for (Structure struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\nFinSi\n";
		aireTexte.append(stringToAppend);
		System.out.println("Condition SI ajoutée!");
		
	}
}
