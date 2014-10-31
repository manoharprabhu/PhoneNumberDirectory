package phonedirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class PhoneDirectoryTrie implements PhoneDirectory {

	private Node root;
	private List<PhoneEntry> entries = new ArrayList<PhoneEntry>();
	public PhoneDirectoryTrie(){
		root = new Node(null,null);
	}
	
	
	public boolean addEntry(String name, String number) {
		Node current = this.root;
		boolean addedFlag = false;
		for(Character c : name.toCharArray()){
			if(current.getChildren().containsKey(c)){
				current = current.getChildren().get(c);
			} else {
				Node temp = new Node(c,null);
				current.getChildren().put(c, temp);
				temp.setParent(current);
				current = temp;
				addedFlag = true;
			}
		}
		if(addedFlag) {
			current.setEnd(true);
			current.setNumber(number);
		}
		return addedFlag;
	}

	public List<PhoneEntry> searchNameWithPrefix(String name) {
		entries.clear();
		Node current = this.root;
		for(Character c : name.toCharArray()){
			if(current.getChildren().containsKey(c)){
				current = current.getChildren().get(c);
			} else {
				return new ArrayList<PhoneEntry>();
			}
		}
		return searchFromNode(current, name);
	}
	
	private List<PhoneEntry> searchFromNode(Node n,String currentPrefix){
		
		if(n.isEnd()){
			entries.add(new PhoneEntry(currentPrefix, n.getNumber()));
			currentPrefix = "";
		} else {
			for(Entry<Character, Node> entry : n.getChildren().entrySet()){
				searchFromNode(entry.getValue(), currentPrefix + entry.getKey());
			}
		}
		return entries;
	}

	public boolean removeEntry(String name) {
		if(!doesNameExist(name)){
			return false;
		}
		
		Node current = this.root;
		for(Character c : name.toCharArray()){
			current = current.getChildren().get(c);
		}
		
		while(true){
			if(current.getChildren().size() > 1){
				break;
			} else {
				Node temp  = current.getParent();
				current.getChildren().clear();
				current.setC(null);
				current.setEnd(false);
				current.setParent(null);
				current = temp;
			}
		}
		return true;
		
	}
	
	private boolean doesNameExist(String name){
		Node current = this.root;
		for(Character c : name.toCharArray()){
			if(current.getChildren().containsKey(c)) {
			current = current.getChildren().get(c);
			} else {
				return false;
			}
			
		}
		return current.isEnd();
	}
	
	public List<PhoneEntry> listAllEntries(){
		return searchFromNode(this.root, "");
	}


}
