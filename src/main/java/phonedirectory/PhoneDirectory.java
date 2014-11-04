package phonedirectory;

import java.util.List;

public interface PhoneDirectory<T> {

	boolean addEntry(String name, T payload);

	List<T> searchNameWithPrefix(String name);

	boolean removeEntry(String name);

	List<T> listAllEntries();

	int size();

	void clear();

}
