package phonedirectory;

import java.util.List;

public interface PhoneDirectory {
	
	boolean addEntry(String name, String number);
	
	List<PhoneEntry> searchNameWithPrefix(String name);
	
	boolean removeEntry(String name);
	
	 List<PhoneEntry> listAllEntries();
	 
	 int size();
	 
	 void clear();
	

}
