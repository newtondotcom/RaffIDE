package src.theAssistantDesRaffinages;

import org.json.JSONObject;
import java.io.FileWriter;
import java.lang.String;
import com.google.gson.Gson;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class Export {
	
    String exportation(DefaultTreeModel arbre){
        //JSONObject obj = new JSONObject();
        //obj.put("key1", "valeur1");
        //obj.put("key2", 42);
    	System.out.println("Début de l'exportation dans Export.java");
    	try {
            Gson gson = new Gson();
            String json = gson.toJson(gson); 
            return json;
		} catch (Exception e) {
			System.out.println("Erreur dans la conversion");
		}
		return null;
    }
    
    
}
