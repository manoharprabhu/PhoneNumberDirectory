package phonedirectory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneDirectoryTest {
	
	private static PhoneDirectory<String> directoryString;
	private static PhoneDirectory<Integer> directoryInteger;
	@BeforeClass
	public static void setup(){
		directoryString = new PhoneDirectoryTrie<String>();
		directoryInteger = new PhoneDirectoryTrie<Integer>();
	}
	
	@Before
	public void clearDirectory(){
		directoryString.clear();
		directoryInteger.clear();
	}
	
	@Test(timeout=100)
	public void returnValueTest(){
		Assert.assertEquals(true, directoryString.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directoryString.addEntry("Gilfoyle", "8050102366"));
		Assert.assertEquals(false, directoryString.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directoryString.removeEntry("Richard"));
		Assert.assertEquals(false, directoryString.removeEntry("Richard"));
		Assert.assertEquals(true, directoryString.addEntry("Richard", "8050102366"));
		Assert.assertEquals(true, directoryString.addEntry("RichardHendriks", "8050102366"));
		Assert.assertEquals(true, directoryString.removeEntry("Richard"));
		Assert.assertEquals(false, directoryString.removeEntry("Richard"));
		Assert.assertEquals(true, directoryString.removeEntry("RichardHendriks"));
		Assert.assertEquals(true, directoryString.addEntry("Richard", "8050102366"));
		
		Assert.assertEquals(true, directoryInteger.addEntry("Richard", 80502366));
		Assert.assertEquals(true, directoryInteger.addEntry("Gilfoyle", 12343223));
		Assert.assertEquals(false, directoryInteger.addEntry("Richard", 45435245));
		Assert.assertEquals(true, directoryInteger.removeEntry("Richard"));
		Assert.assertEquals(false, directoryInteger.removeEntry("Richard"));
		Assert.assertEquals(true, directoryInteger.addEntry("Richard", 456543));
		Assert.assertEquals(true, directoryInteger.addEntry("RichardHendriks", 2436432));
		Assert.assertEquals(true, directoryInteger.removeEntry("Richard"));
		Assert.assertEquals(false, directoryInteger.removeEntry("Richard"));
		Assert.assertEquals(true, directoryInteger.removeEntry("RichardHendriks"));
		Assert.assertEquals(true, directoryInteger.addEntry("Richard", 9878976));
		
	}
	
	@Test(timeout=100)
	public void searchTest(){
		directoryString.addEntry("Manohar", "34324234");
		directoryString.addEntry("Jeevan", "123456789");
		directoryString.addEntry("Sunil", "9833432321");
		directoryString.addEntry("Gilfoyle", "939483833");
		directoryString.addEntry("Mannu", "9928373331");
		directoryString.addEntry("Man", "2343243");
		directoryString.addEntry("Richard", "8050102366");
		directoryString.addEntry("RichardHendriks", "8050102366");
		directoryString.addEntry("RichardHendriksJR", "8050102366");
		directoryString.addEntry("Richie", "8050102366");
		
		
		Assert.assertEquals(10, directoryString.size());
		
		Assert.assertEquals(3, directoryString.searchNameWithPrefix("Man").size());
		Assert.assertEquals(0, directoryString.searchNameWithPrefix("Kat").size());
		Assert.assertEquals(1, directoryString.searchNameWithPrefix("G").size());
		Assert.assertEquals(3, directoryString.searchNameWithPrefix("Man").size());
		Assert.assertEquals(1, directoryString.searchNameWithPrefix("Jeevan").size());
		Assert.assertEquals(4, directoryString.searchNameWithPrefix("Ric").size());
		Assert.assertEquals(3, directoryString.searchNameWithPrefix("Richard").size());
		Assert.assertEquals(2, directoryString.searchNameWithPrefix("RichardHendriks").size());
		
	}
	
	@Test(timeout=100)
	public void modificationSizeTest(){
		directoryString.addEntry("Richard", "8050102366");
		directoryString.addEntry("Erlich", "123456789");
		Assert.assertEquals(2, directoryString.size());
		
		directoryString.addEntry("Bighetti", "9833432321");
		directoryString.addEntry("Gilfoyle", "939483833");
		Assert.assertEquals(4, directoryString.size());
		
		directoryString.addEntry("Donald", "9928373331");
		Assert.assertEquals(5, directoryString.size());
		
		directoryString.removeEntry("Erlich");
		Assert.assertEquals(4, directoryString.size());
		
		directoryString.addEntry("Dinesh", "2343243");
		Assert.assertEquals(5, directoryString.size());
		
		directoryString.removeEntry("Richard");
		Assert.assertEquals(4, directoryString.size());
		
		directoryString.addEntry("RichardHendriks","55345346");
		Assert.assertEquals(5, directoryString.size());
		
		directoryString.addEntry("RichardHendriksJR","55345346");
		Assert.assertEquals(6, directoryString.size());
		
		directoryString.removeEntry("RichardHendriksJR");
		Assert.assertEquals(5, directoryString.size());
		
		directoryString.removeEntry("RichardHendriks");
		Assert.assertEquals(4, directoryString.size());
		
		
		directoryString.clear();
		Assert.assertEquals(0, directoryString.size());
		
		directoryString.addEntry("Richard", "8050102366");
		directoryString.addEntry("RichardHendriks", "8050102366");
		directoryString.addEntry("RichardHendriksJR", "8050102366");
		
		directoryString.removeEntry("RichardHendriks");
		Assert.assertEquals(2, directoryString.size());
		
		directoryString.addEntry("RichardHendriks", "8050102366");
		
		directoryString.removeEntry("Richard");
		Assert.assertEquals(2, directoryString.size());
		
		directoryString.addEntry("Richard", "8050102366");
		
		directoryString.removeEntry("RichardHendriksJR");
		Assert.assertEquals(2, directoryString.size());
		
		directoryString.clear();
		directoryString.removeEntry("Richard");
		Assert.assertEquals(0, directoryString.size());
		
	}

}
