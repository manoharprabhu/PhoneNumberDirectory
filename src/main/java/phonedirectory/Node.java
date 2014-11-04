package phonedirectory;

import java.util.TreeMap;

 class  Node<T> {
	private Character c;
	private TreeMap<Character, Node<T>> children;
	private Node<T> parent;
	private boolean isEnd;
	private T payload;
	
	public Node(Character c,T payload){
		this.c = c;
		setChildren(new TreeMap<Character, Node<T>>());
		this.isEnd = false;
		this.setPayload(payload);
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

	public TreeMap<Character, Node<T>> getChildren() {
		return children;
	}

	public void setChildren(TreeMap<Character, Node<T>> children) {
		this.children = children;
	}



	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

}
