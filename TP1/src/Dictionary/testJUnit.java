package Dictionary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testJUnit {

	OrderedDictonary od;
	FastDictionary fd;

	@Before
	public void setUp() throws Exception {
		od = new OrderedDictonary();
		fd = new FastDictionary();
	}

	@Test
	public void test() {
	}
	
	@Test
	public void testAddOneElementToEmptyDico()
	{
		od.put("1", "vache");
		assertEquals(1,od.size());
		assertTrue(od.containsKey("1"));
	}
	
	@Test
	public void addOneElementToFastDico()
	{
		fd.put("1", "vache");
		fd.put("2", "vache");
		fd.put("3", "vache");
		fd.put("4", "vache");
		fd.put("5", "vache");
		fd.put("6", "vache");
		fd.put("7", "vache");
		assertEquals(7,fd.size());
		assertTrue(fd.containsKey("1"));		
	}

}
