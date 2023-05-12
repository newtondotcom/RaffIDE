package theAssistantDesRaffinages;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.*;

public class ActionComplexeAdapter implements JsonSerializer<ActionComplexe>, JsonDeserializer<ActionComplexe> {

    @Override
    public JsonElement serialize(ActionComplexe actionComplexe, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("niveau", actionComplexe.getNiveau());
        jsonObject.addProperty("titre", actionComplexe.getTitre());
        jsonObject.addProperty("couleur", actionComplexe.getCouleur().toString());
        JsonArray formatsArray = new JsonArray();
        for (TextFormat format : actionComplexe.getFormats()) {
            formatsArray.add(new JsonPrimitive(format.toString()));
        }
        jsonObject.add("formats", formatsArray);
        JsonArray elementsArray = new JsonArray();
        for (Element element : actionComplexe.getElements()) {
            elementsArray.add(jsonSerializationContext.serialize(element));
        }
        jsonObject.add("elements", elementsArray);
        return jsonObject;
    }

    @Override
    public ActionComplexe deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int niveau = jsonObject.get("niveau").getAsInt();
        String titre = jsonObject.get("titre").getAsString();
        TextColor couleur = TextColor.valueOf(jsonObject.get("couleur").getAsString().toUpperCase());
        JsonArray formatsArray = jsonObject.getAsJsonArray("formats");
        List<TextFormat> formats = new ArrayList<>();
        for (JsonElement formatElement : formatsArray) {
            formats.add(TextFormat.valueOf(formatElement.getAsString().toUpperCase()));
        }
        ActionComplexe actionComplexe = new ActionComplexe(titre, niveau);
        actionComplexe.setCouleur(couleur);
        for (TextFormat format : formats) {
            actionComplexe.addFormat(format);
        }
        JsonArray elementsArray = jsonObject.getAsJsonArray("elements");
        for (JsonElement elementElement : elementsArray) {
            Element element = jsonDeserializationContext.deserialize(elementElement, Element.class);
            actionComplexe.addElement(element);
        }
        return actionComplexe;
    }
}
