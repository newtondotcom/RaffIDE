package theAssistantDesRaffinages;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BasicEditorListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("GAINED: "+e.paramString());
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("LOST: "+e.paramString());
		
	}
	
}
