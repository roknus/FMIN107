package Dictionary;

public class testDico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastDictionary fd = new FastDictionary();
		fd.put("test", "00000");
		fd.put("test2", "aaaaa");
		fd.put("test3", "bbbbb");
		fd.put("test4", "ccccc");
		fd.put("test5", "ddddd");
		fd.put("test6", "eeeee");
		fd.put("test7", "fffff");
		fd.put("test8", "ggggg");
		try
		{
			System.out.println(fd);
		}
		catch(Exception e)
		{
			System.out.println("erreur");
		}

	}

}
