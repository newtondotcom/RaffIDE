package theAssistantDesRaffinages;

import java.util.ArrayList;
import java.util.List;

public class StructureSiSinon extends StructureDeControle {

    List<Element> SinonCorps;

    public StructureSiSinon(String condition, String nom) {
        super(condition, nom);
        SinonCorps = new ArrayList<>();
    }

    @Override
    public String toStringAbstrait() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u001B[1m"); // Appliquer le format en gras
        stringBuilder.append("\u001B[33m"); // Appliquer la couleur jaune
        stringBuilder.append("Si ").append(getCondition()).append("  Alors :");
        stringBuilder.append("\u001B[0m"); // Réinitialiser le format

        // Affichage des éléments dans la partie "Alors"
        for (Element struct : getCorps()) {
            stringBuilder.append("\n\t").append(struct.toString());
        }

        stringBuilder.append("\u001B[1m"); // Appliquer le format en gras
        stringBuilder.append("\u001B[34m"); // Appliquer la couleur bleue
        stringBuilder.append("\nSinon :");
        stringBuilder.append("\u001B[0m"); // Réinitialiser le format

        // Affichage des éléments dans la partie "Sinon"
        for (Element struct : SinonCorps) {
            stringBuilder.append("\n\t").append(struct.toString());
        }

        stringBuilder.append("\u001B[1m"); // Appliquer le format en gras
        stringBuilder.append("\u001B[33m"); // Appliquer la couleur jaune
        stringBuilder.append("\nFinSi\n");
        stringBuilder.append("\u001B[0m"); // Réinitialiser le format

        return stringBuilder.toString();
    }
}
