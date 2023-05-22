package theAssistantDesRaffinages;

import java.lang.String;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;


import javax.swing.JTree;
import javax.swing.tree.*;


public class Export {
	
	public Export() {};
	
	//ajouter des références avec du \hyperref{sec:intro}{cliquer ici} et \hypertarget{sec:intro}{Introduction}
	//\usepackage{hyperref}

	
	//passage au txt manuel
	public String getString(JTree tree) {
		String string;
		LinkedList<Element> list;
		
        RaffinageMutableTreeNode selectedNode = (RaffinageMutableTreeNode) tree.getModel().getRoot();
        ActionComplexe actionComplexe = selectedNode.getActionComplexe();
        
        // On peut utiliser les méthodes et attributs de la classe ActionComplexe
        
        string = actionComplexe.getTitreEntier();
        list = (LinkedList<Element>) actionComplexe.getElements();
        System.out.println("Size of the LinkedList: " + list.size());
        string = buildCurrentRaff(actionComplexe);
        System.out.println("String written: " + string);
		return string;
	}
	
	public boolean allElementary(LinkedList<Element> list) {
		for ( Element e : list) {
			if (e instanceof ActionComplexe) {
        		return false;
        	}
        }
		return true;
	}
	
	public String buildCurrentRaff(ActionComplexe ac) {
		String title;
		String body;
		title = ac.getTitreEntier();
		body = " ";
        for ( Element e : ac.getElements()) {
        	if (e instanceof ActionElementaire) {
        		body += e.toString() + "\n";
        	}
        	else if (e instanceof StructureDeControle) {
        		body += e.toString()+ "\n";
        	}
        	else if (e instanceof ActionComplexe) {
        		body += e.toString()+ "\n";
        	}
        }
		return title+body;
	}
	
	
	
	
	
	
	
	
	
	
	
	//GSON
	public String getString2(JTree tree) {
		DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
		TreeNode rootNode = (TreeNode) treeModel.getRoot();

		// Convert the tree structure to a serializable format
		JsonObject treeJson = convertTreeToJson(rootNode);

		// Serialize the JSON object using Gson
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonString = gson.toJson(treeJson);

		System.out.println(jsonString);
		return jsonString;
	}
	
	// Method to recursively convert the tree to a JSON object
	final JsonObject convertTreeToJson(TreeNode node) {
	    JsonObject nodeJson = new JsonObject();
	    int count = 0;
	    while (node.children().hasMoreElements()) {
	    	node.children().nextElement();
	        count++;
	    }
	    System.out.println("Length of enumeration: " + count);
	    
	    nodeJson.addProperty("name", node.toString());
	    JsonArray childrenJson = new JsonArray();
	    int childCount = node.getChildCount();
	    System.out.println("Nombres d'enfants : " + String.valueOf(childCount));
	    for (int i = 0; i < childCount; i++) {
	        TreeNode childNode = node.getChildAt(i);
	        JsonObject childJson = convertTreeToJson(childNode);
	        childrenJson.add(childJson);
	    }
	    nodeJson.add("children", childrenJson);
	    return nodeJson;
	}
	

    
    
}