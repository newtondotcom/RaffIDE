package theAssistantDesRaffinages;

import javax.swing.tree.DefaultMutableTreeNode;

public class RaffinageMutableTreeNode extends DefaultMutableTreeNode {
	
	public RaffinageMutableTreeNode(ActionComplexe raffinage){
		super(raffinage);
	}
	
	@Override
	public String toString() {
		return ((ActionComplexe) this.getUserObject()).getTitreEntier();
	}
}
