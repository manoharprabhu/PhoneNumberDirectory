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
	
	@Test(timeout=100)
	public void returnValueTest(){
		Assert.assertEquals(true, directory.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directory.addEntry("Gilfoyle", "8050102366"));
		Assert.assertEquals(false, directory.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directory.removeEntry("Richard"));
		Assert.assertEquals(false, directory.removeEntry("Richard"));
		Assert.assertEquals(true, directory.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directory.addEntry("RichardHendriks", "8050102366"));
		Assert.assertEquals(true, directory.removeEntry("Richard"));
		Assert.assertEquals(false, directory.removeEntry("Richard"));
		Assert.assertEquals(true, directory.removeEntry("RichardHendriks"));
		Assert.assertEquals(true, directory.addEntry("Richard", "8050102366"));
	}
	
	@Test(timeout=100)
	public void searchTest(){
		directory.addEntry("Manohar", "34324234");
		directory.addEntry("Jeevan", "123456789");
		directory.addEntry("Sunil", "9833432321");
		directory.addEntry("Gilfoyle", "939483833");
		directory.addEntry("Mannu", "9928373331");
		directory.addEntry("Man", "2343243");
		directory.addEntry("Richard", "8050102366");
		directory.addEntry("RichardHendriks", "8050102366");
		directory.addEntry("RichardHendriksJR", "8050102366");
		
		Assert.assertEquals(3, directory.searchNameWithPrefix("Man").size());
		Assert.assertEquals(0, directory.searchNameWithPrefix("Kat").size());
		Assert.assertEquals(1, directory.searchNameWithPrefix("G").size());
		Assert.assertEquals(3, directory.searchNameWithPrefix("Man").size());
		Assert.assertEquals(1, directory.searchNameWithPrefix("Jeevan").size());
		Assert.assertEquals(3, directory.searchNameWithPrefix("Ric").size());
		Assert.assertEquals(3, directory.searchNameWithPrefix("Richard").size());
		Assert.assertEquals(2, directory.searchNameWithPrefix("RichardHendriks").size());
		
		
		Assert.assertEquals(9, directory.listAllEntries().size());
		
	}
	
	@Test(timeout=100)
	public void modificationSizeTest(){
		directory.addEntry("Richard", "8050102366");
		directory.addEntry("Erlich", "123456789");
		Assert.assertEquals(2, directory.size());
		
		directory.addEntry("Bighetti", "9833432321");
		directory.addEntry("Gilfoyle", "939483833");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("Donald", "9928373331");
		Assert.assertEquals(5, directory.size());
		
		directory.removeEntry("Erlich");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("Dinesh", "2343243");
		Assert.assertEquals(5, directory.size());
		
		directory.removeEntry("Richard");
		Assert.assertEquals(4, directory.size());
		
		directory.addEntry("RichardHendriks","55345346");
		Assert.assertEquals(5, directory.size());
		
		directory.addEntry("RichardHendriksJR","55345346");
		Assert.assertEquals(6, directory.size());
		
		directory.removeEntry("RichardHendriksJR");
		Assert.assertEquals(5, directory.size());
		
		directory.removeEntry("RichardHendriks");
		Assert.assertEquals(4, directory.size());
		
		
		directory.clear();
		Assert.assertEquals(0, directory.size());
	}

}
