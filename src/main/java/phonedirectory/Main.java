package phonedirectory;

public class Main {

	public static void main(String[] args) {
		PhoneDirectory directory = new PhoneDirectoryTrie();
		
		directory.addEntry("Manohar", "8050102366");
		directory.addEntry("Sunil", "12345678");
		directory.addEntry("Jeevan", "32453252366");
		directory.addEntry("Jeed", "98952366");
		directory.addEntry("Munna", "420420420");
		directory.addEntry("Mannu", "420420420");
		
		System.out.println(directory.listAllEntries());
		

	}

}
