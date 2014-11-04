package phonedirectory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class PhoneDirectoryTrie<T> implements PhoneDirectory<T> {

	private Node<T> root;
	private List<T> entries = new ArrayList<T>();
	private int size = 0;

	public PhoneDirectoryTrie() {
		root = new Node<T>(null, null);
	}

	public boolean addEntry(String name, T payload) {

		if (doesNameExist(name)) {
			return false;
		}

		Node<T> current = this.root;
		for (Character c : name.toCharArray()) {
			if (current.getChildren().containsKey(c)) {
				current = current.getChildren().get(c);
			} else {
				Node<T> temp = new Node<T>(c, null);
				current.getChildren().put(c, temp);
				temp.setParent(current);
				current = temp;
			}
		}
		size++;
		current.setEnd(true);
		current.setPayload(payload);

		return true;
	}

	public List<T> searchNameWithPrefix(String name) {
		entries.clear();
		Node<T> current = this.root;
		for (Character c : name.toCharArray()) {
			if (current.getChildren().containsKey(c)) {
				current = current.getChildren().get(c);
			} else {
				return new ArrayList<T>();
			}
		}
		return searchFromNode(current, name);
	}

	private List<T> searchFromNode(Node<T> n, String currentPrefix) {

		if (n.isEnd()) {
			entries.add(n.getPayload());
		}
		for (Entry<Character, Node<T>> entry : n.getChildren().entrySet()) {
			searchFromNode(entry.getValue(), currentPrefix + entry.getKey());
		}

		return entries;
	}

	public boolean removeEntry(String name) {
		if (!doesNameExist(name)) {
			return false;
		}

		Node<T> current = this.root;
		for (Character c : name.toCharArray()) {
			current = current.getChildren().get(c);
		}

		while (true) {
			if (current == null || current.getChildren().size() > 1) {
				break;
			} else {
				Node<T> temp = current.getParent();
				current.setEnd(false);
				current = temp;
			}
			if (current == null || current.isEnd()) {
				break;
			}
		}
		size--;
		return true;

	}

	private boolean doesNameExist(String name) {
		Node<T> current = this.root;
		for (Character c : name.toCharArray()) {
			if (current.getChildren().containsKey(c)) {
				current = current.getChildren().get(c);
			} else {
				return false;
			}

		}
		return current.isEnd();
	}

	public List<T> listAllEntries() {
		entries.clear();
		return searchFromNode(this.root, "");
	}

	public int size() {
		return size;
	}

	public void clear() {
		this.root = new Node<T>(null, null);
		this.size = 0;
	}

}
