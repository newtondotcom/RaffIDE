package theAssistantDesRaffinages;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class BasicEditorListener implements FocusListener{
	int turn =0;
	@Override
	public void focusGained(FocusEvent e) {
		
		System.out.println("GAINED: ");
		JTextArea tArea = (JTextArea)e.getSource();
		tArea.append("lol");
		System.out.println(tArea.getCaretPosition());
		Highlighter h = tArea.getHighlighter();
		HighlightPainter pink = 
	             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
		HighlightPainter blue = 
	             new DefaultHighlighter.DefaultHighlightPainter(Color.blue);
		
		try {
			
			h.addHighlight(0, tArea.getText().length(), blue);
			
		} catch (BadLocationException ex) {
			System.out.println("Bad Location!");
		}
		
		}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("LOST: ");
		
	}
	
}
