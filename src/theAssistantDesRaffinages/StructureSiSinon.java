package theAssistantDesRaffinages;

import java.util.List;

public abstract class StructureSiSinon extends StructureDeControle {

    public StructureSiSinon(String condition, String nom) {
        super(condition, nom);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TextFormat.BOLD.getCode()); // Appliquer le format en gras
        stringBuilder.append(TextColor.YELLOW.getCode()); // Appliquer la couleur jaune
        stringBuilder.append("Si (").append(getCondition()).append(") Alors :");
        stringBuilder.append(TextFormat.RESET.getCode()); // Réinitialiser le format

        // Affichage des éléments dans la partie "Alors"
        for (Element struct : getCorps()) {
            stringBuilder.append("\n\t").append(struct.toString());
        }

        stringBuilder.append(TextFormat.BOLD.getCode()); // Appliquer le format en gras
        stringBuilder.append(TextColor.BLUE.getCode()); // Appliquer la couleur bleue
        stringBuilder.append("\nSinon :");
        stringBuilder.append(TextFormat.RESET.getCode()); // Réinitialiser le format

        // Affichage des éléments dans la partie "Sinon"
        for (Element struct : getSinonCorps()) {
            stringBuilder.append("\n\t").append(struct.toString());
        }

        stringBuilder.append(TextFormat.BOLD.getCode()); // Appliquer le format en gras
        stringBuilder.append(TextColor.YELLOW.getCode()); // Appliquer la couleur jaune
        stringBuilder.append("\nFinSi\n");
        stringBuilder.append(TextFormat.RESET.getCode()); // Réinitialiser le format

        return stringBuilder.toString();
    }
}
