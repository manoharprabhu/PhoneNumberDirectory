package phonedirectory;

public class Main {

	public static void main(String[] args) {
		PhoneDirectory directory = new PhoneDirectoryTrie();
		
		directory.addEntry("Manohar", "34324234");
		directory.addEntry("Jeevan", "123456789");
		directory.addEntry("Sunil", "9833432321");
		directory.addEntry("Gilfoyle", "939483833");
		directory.addEntry("Mannu", "9928373331");
		directory.addEntry("Man", "2343243");
		
		
		System.out.println(directory.listAllEntries());
		

	}

}
