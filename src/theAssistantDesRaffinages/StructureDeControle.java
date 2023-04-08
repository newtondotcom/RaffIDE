package theAssistantDesRaffinages;

import java.util.ArrayList;
import java.util.List;

public abstract class StructureDeControle implements Structure {
	
	private String condition;
	private List<Structure> corps;
	
	public StructureDeControle(String condition) {
		this.condition = condition;
		this.corps = new ArrayList<>();
	}
	
	public void add(Structure struct) {
		corps.add(struct);
	}
	
	public void delete(Structure struct) {
		corps.remove(struct);
	}
	
	public void setCondition(String newCondition) {
		this.condition = newCondition;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public List<Structure> getCorps() {
		return this.corps;
	}
	
}