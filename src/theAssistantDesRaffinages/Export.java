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
    public static void main(String[] args) throws Exception{
        //JSONObject obj = new JSONObject();
        //obj.put("key1", "valeur1");
        //obj.put("key2", 42);


        
        DefaultTreeModel arbre = new DefaultTreeModel(null);
        Gson gson = new Gson();
        String json = gson.toJson(gson); 
        FileWriter writer = new FileWriter("./test.json");
        writer.write(json);
        writer.close();
        
        
    }
    
    
}
