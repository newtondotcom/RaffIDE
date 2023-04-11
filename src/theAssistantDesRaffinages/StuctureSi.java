package theAssistantDesRaffinages;

public class StuctureSi extends StructureDeControle {

	public StuctureSi(String condition) {
		super(condition);
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
