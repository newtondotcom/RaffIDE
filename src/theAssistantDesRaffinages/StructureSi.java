package theAssistantDesRaffinages;



public class StructureSi extends StructureDeControle {

	public StructureSi(String condition,String nom) {
		super(condition,nom);
	}

	@Override
	public String toString() {
		String stringToAppend = "Si (" + this.getCondition() + ") Alors :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct.toString();
		}
		stringToAppend += "\nFinSi\n";
		return stringToAppend;		
	}
}
