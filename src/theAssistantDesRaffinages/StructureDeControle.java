import java.util.List;
import java.

public abstract class StructureDeControle implements Structure {
	
	private String condition;
	protected List<Structure> corps;
	
	public StructureDeControle(String condition) {
		this.condition = condition;
		this.corps = new ArrayList();
	}
	
	abstract void afficher();
	
	void add(Structure struct) {
		
	}
	
	void delete(Structure struct) {
		
	}
	
	void setCondition(String newCondition) {
		
	}
	
	String getCondition() {
		
	}
	
}