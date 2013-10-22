package PatternComposite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testComposite {
	
	Directory root;

	@Before
	public void setUp() throws Exception 
	{
		root = new Directory(null,"root");
//		Directory home = new Directory(root,"home");
//		File init = new File(root,"init");
//		File hello = new File(home,"hello");
	}

	@Test
	public void test() {
	}
	
	@Test
	public void testDirectory()
	{
		Directory home = new Directory(root,"home");	
		System.out.println(home.absoluteAddress(home));
		System.out.println(root.find("home"));
		assertTrue(root.find("home").contains(home.absoluteAddress(home)));
	}

}
