package theAssistantDesRaffinages;

public class StructurePour extends StructureDeControle {

	public StructurePour(String nom, String var, String debut, String fin) {
		super(nom, var, debut, fin);
	}

	@Override
	public String toString(){
		String stringToAppend = "Pour  " + this.getVar() + " De " + this.getDebut() + " À " + this.getFin() + " Faire :" ;
		for (Element struct : this.getCorps()) {
			stringToAppend += "\n\t";
			stringToAppend += struct.toString();
		}
		stringToAppend += "\n FinPour \n";
		return stringToAppend; }
}