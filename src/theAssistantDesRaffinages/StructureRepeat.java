package theAssistantDesRaffinages;

public class StructureRepeat extends StructureDeControle {

	public StructureRepeat(String condition,String nom) {
		super(condition,nom);
	}
	
	public StructureRepeat(int id,String condition,String nom) {
		super(id,condition,nom);
	}

	@Override
	public String toStringAbstrait() {
		String stringToAppend = "Faire :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct.toString();
		}
		stringToAppend += "\n Jusqu'À " + this.getCondition() + ".";
		return stringToAppend;

	}
}