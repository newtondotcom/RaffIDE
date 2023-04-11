package theAssistantDesRaffinages;

public class StuctureSi extends StructureDeControle {

	public StuctureSi(String condition,String nom) {
		super(condition,nom);
	}

	@Override
	public void afficher() {
		System.out.println("Si (" + this.getCondition() + ") : " );
		for (Structure struct : this.getCorps()) {
			System.out.print("\t");
			struct.afficher();
		}
		System.out.println("FinSi");
	}
}
