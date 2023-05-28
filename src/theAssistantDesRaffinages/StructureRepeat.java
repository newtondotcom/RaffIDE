package theAssistantDesRaffinages;

public class StructureRepeat extends StructureDeControle {

	public StructureRepeat(String condition,String nom) {
		super(condition,nom);
	}

	@Override
	public String toString() {
		String stringToAppend = "Faire :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct.toString();
		}
		stringToAppend += "\n Jusqu'À " + this.getCondition() + ".\n ";
		return stringToAppend;

	}
}