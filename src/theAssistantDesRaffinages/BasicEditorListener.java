package theAssistantDesRaffinages;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.*;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class BasicEditorListener implements FocusListener {
	int turn = 0;

	@Override
	public void focusGained(FocusEvent e) {

		System.out.println("GAINED: ");
		JTextArea tArea = (JTextArea) e.getSource();
		System.out.println(tArea.getCaretPosition());
		Highlighter h = tArea.getHighlighter();
		
		HighlightPainter pink = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
		HighlightPainter blue = new DefaultHighlighter.DefaultHighlightPainter(Color.blue);
		
		try {
			h.removeAllHighlights();
			
			
			String curr = tArea.getText();
			
			int pos = tArea.getCaretPosition(); 
		
			int from=pos, to =pos;
			
			while (from >0 && (curr.charAt(from) != ' ' || curr.charAt(from) != '\n')) {
				from--;
			}
			while (to < curr.length() && (curr.charAt(to) != ' ' || curr.charAt(to) != '\n')) {
				to++;
			}
			
			h.addHighlight(1, 3, pink);
			
		} catch (BadLocationException ex) {
			System.out.println("Bad Location!");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("LOST: ");

	}

}
