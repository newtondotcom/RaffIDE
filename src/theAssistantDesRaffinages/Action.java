package theAssistantDesRaffinages;

public interface Action extends Element {

    public void addFormat(TextFormat format);
    public void removeFormat(TextFormat format);

    public TextColor getCouleur();
    public void setCouleur(TextColor color);

    public String getContenu();
    public String getTexteFormate();

    public void print();
}

