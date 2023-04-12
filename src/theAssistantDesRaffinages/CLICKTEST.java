package theAssistantDesRaffinages;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;

public class CLICKTEST extends JFrame {
    
    public CLICKTEST() {
        super("Keyword Clickable Text Area");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(400, 300));
        
        // Create a document to hold the text
        StyledDocument doc = textPane.getStyledDocument();
        
        // Add some text with keywords and ids
        try {
            doc.insertString(0, "This is some sample text. ", null);
            doc.insertString(doc.getLength(), "Click me!", createClickableStyle("click", 1));
            doc.insertString(doc.getLength(), " This is some more text. ", null);
            doc.insertString(doc.getLength(), "Click me too!", createClickableStyle("click", 2));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        
        // Add a listener to handle clicks on the keywords
        textPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int offset = textPane.viewToModel(e.getPoint());
                javax.swing.text.Element element = (javax.swing.text.Element) doc.getCharacterElement(offset);
                AttributeSet attributeSet = ((javax.swing.text.Element) element).getAttributes();
                if (attributeSet.containsAttribute("clickable", true)) {
                    String keyword = (String) attributeSet.getAttribute("keyword");
                    int id = (int) attributeSet.getAttribute("id");
                    JOptionPane.showMessageDialog(CLICKTEST.this,
                            String.format("You clicked keyword '%s' with id %d", keyword, id));
                }
            }
        });
        
        // Add the JTextPane to the frame
        getContentPane().add(new JScrollPane(textPane));
        
        // Display the frame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private SimpleAttributeSet createClickableStyle(String keyword, int id) {
        SimpleAttributeSet style = new SimpleAttributeSet();
        style.addAttribute("clickable", true);
        style.addAttribute("foreground", Color.BLUE);
        style.addAttribute("underline", TextAttribute.UNDERLINE_LOW_DOTTED);
        style.addAttribute("keyword", keyword);
        style.addAttribute("id", id);
        return style;
    }
    
    public static void main(String[] args) {
        new CLICKTEST();
    }
    
}

