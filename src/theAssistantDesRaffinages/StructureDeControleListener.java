package theAssistantDesRaffinages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class StructureDeControleListener implements ActionListener {

	/** La structure de controle a observer */
	private Class<? extends StructureDeControle> classe;

	/** La zone d'edition */
	private VueEditionRaffinages vueEd;

	/** Creer un observateur de structure de controle */
	public StructureDeControleListener(
			Class<? extends StructureDeControle> class1,
			VueEditionRaffinages vueEd) {
		this.classe = class1;
		this.vueEd = vueEd;
	}

	/**
	 * Action se declanchant lorsque l'on appuie sur le bouton
	 * 
	 * @param e L'evenement (appuyer sur le bouton)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		StructureDeControle sdc;
		if (classe == StructurePour.class) {
			/* À changer */
			String var = JOptionPane
					.showInputDialog("Entrez un nom de variable");
			String Debut = JOptionPane
					.showInputDialog("Entrez le début de la boucle");
			String Fin = JOptionPane
					.showInputDialog("Entrez la fin de la boucle");
			System.out.println(e.getSource().getClass());
			try {
				sdc = classe
						.getConstructor(new Class<?>[] { String.class,
								String.class, String.class, String.class })
						.newInstance("", var, Debut, Fin);
				vueEd.getRaffCourant().addElement(sdc);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else {
			String condition = JOptionPane
					.showInputDialog("Entrez une condition");
			try {
				sdc = classe
						.getConstructor(
								new Class<?>[] { String.class, String.class })
						.newInstance(condition, "");
				vueEd.getRaffCourant().addElement(sdc);
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		vueEd.update();
	}

}