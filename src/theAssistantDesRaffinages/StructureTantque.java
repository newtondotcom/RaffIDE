package theAssistantDesRaffinages;

public class StructureTantque extends StructureDeControle {
	public StructureTantque(String condition,String nom) {
		super(condition,nom);
	}

	@Override
	public String toString() {
		String stringToAppend = "TantQue (" + this.getCondition() + ") Faire :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct;
		}
		stringToAppend += "\n FinTQ \n";
		return stringToAppend;
		
	}
}


