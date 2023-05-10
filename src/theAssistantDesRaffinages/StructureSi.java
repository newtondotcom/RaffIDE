package theAssistantDesRaffinages;



public class StructureSi extends StructureDeControle {

	public StructureSi(String condition,String nom) {
		super(condition,nom);
	}

	@Override
	public String toString() {
		String stringToAppend = "Si (" + this.getCondition() + ") Alors :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\n FinSi \n";
		return stringToAppend;		
	}
}
