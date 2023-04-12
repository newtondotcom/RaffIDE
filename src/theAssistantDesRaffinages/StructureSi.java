package theAssistantDesRaffinages;

import javax.swing.JTextArea;

public class StructureSi extends StructureDeControle {
	private JTextArea textArea;

	public StructureSi(String condition,String nom,JTextArea textArea) {
		super(condition,nom);
		this.textArea = textArea;
	}

	@Override
	public void afficher() {
		String stringToAppend = "Si (" + this.getCondition() + ") Alors :" ;
		for (Structure struct : this.getCorps()) {
			stringToAppend += "\t";
			// TODO Gerer le Corps
		}
		stringToAppend += "\nFinsi\n";
		textArea.append(stringToAppend);
		
	}
}
