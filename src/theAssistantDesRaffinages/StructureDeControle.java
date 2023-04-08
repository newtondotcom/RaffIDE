package theAssistantDesRaffinages;

import java.util.ArrayList;
import java.util.List;

public abstract class StructureDeControle implements Structure {
	
	private String condition;
	private List<Structure> corps;
	
	public StructureDeControle(String condition) {
		this.condition = condition;
		this.corps = new ArrayList();
	}
	
	public abstract void afficher();
	
	public void add(Structure struct) {
		
	}
	
	public void delete(Structure struct) {
		
	}
	
	public void setCondition(String newCondition) {
		
	}
	
	public String getCondition() {
		return condition;
	}
	
}