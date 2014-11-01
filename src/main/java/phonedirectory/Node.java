package phonedirectory;

import java.util.TreeMap;

 class Node {
	private Character c;
	private TreeMap<Character, Node> children;
	private Node parent;
	private boolean isEnd;
	private String number;
	
	public Node(Character c,String number){
		this.c = c;
		setChildren(new TreeMap<Character, Node>());
		this.isEnd = false;
		this.number = number;
		this.parent = null;
	}
	
	public Character getC() {
		return c;
	}
	public void setC(Character c) {
		this.c = c;
	}
	
	public boolean isEnd() {
		return isEnd;
	}
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TreeMap<Character, Node> getChildren() {
		return children;
	}

	public void setChildren(TreeMap<Character, Node> children) {
		this.children = children;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

}
