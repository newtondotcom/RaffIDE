package theAssistantDesRaffinages;

import java.lang.String;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.tree.DefaultTreeModel;

public class Export {
	
    String exportation(RaffinageMutableTreeNode arbre){
        //JSONObject obj = new JSONObject();
        //obj.put("key1", "valeur1");
        //obj.put("key2", 42);
    	System.out.println("DÃ©but de l'exportation dans Export.java");

    	
    	Gson gson = new GsonBuilder()
    	        .registerTypeAdapter(ActionComplexe.class, new ActionComplexeAdapter())
    	        .create();
    	try {
    		//Gson gson = new Gson();
            String json = gson.toJson(arbre); 
            return json;
		} catch (Exception e) {
			System.out.println("Erreur dans la conversion");
			System.out.println(e.getMessage());
		}
		return null;
    }
    
    
}