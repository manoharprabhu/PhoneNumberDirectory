package phonedirectory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneDirectoryTest {
	
	private static PhoneDirectory directory;
	
	@BeforeClass
	public static void setup(){
		directory = new PhoneDirectoryTrie();
	}
	
	@Before
	public void clearDirectory(){
		directory.clear();
	}
	
	@Test
	public void searchTest(){
		directory.addEntry("Manohar", "34324234");
		directory.addEntry("Jeevan", "123456789");
		directory.addEntry("Sunil", "9833432321");
		directory.addEntry("Gilfoyle", "939483833");
		directory.addEntry("Mannu", "9928373331");
		directory.addEntry("Man", "2343243");
		
		Assert.assertEquals(3, directory.searchNameWithPrefix("Man").size());
		Assert.assertEquals(0, directory.searchNameWithPrefix("Kat").size());
		Assert.assertEquals(1, directory.searchNameWithPrefix("G").size());
		Assert.assertEquals(3, directory.searchNameWithPrefix("Man").size());
		Assert.assertEquals(1, directory.searchNameWithPrefix("Jeevan").size());
		Assert.assertEquals(6, directory.listAllEntries().size());
		
	}
	
	@Test
	public void modificationSizeTest(){
		directory.addEntry("Manohar", "8050102366");
		directory.addEntry("Jeevan", "123456789");
		Assert.assertEquals(2, directory.size());
		
		directory.addEntry("Sunil", "9833432321");
		directory.addEntry("Gilfoyle", "939483833");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("Gilfoyle", "12232232");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("Mannu", "9928373331");
		Assert.assertEquals(5, directory.size());
		
		directory.removeEntry("Jeevan");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("Man", "2343243");
		Assert.assertEquals(5, directory.size());
		
		directory.removeEntry("Manohar");
		Assert.assertEquals(4, directory.size());
		
		directory.clear();
		Assert.assertEquals(0, directory.size());
	}

}
