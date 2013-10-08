package Dictionary;

public class testDico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortedDictionary fd = new SortedDictionary();
		fd.put("test", "00000");
		fd.put("zzzz", "zzzzz");
		fd.put("aaaa", "bbbbb");
		fd.put("hhhh", "ccccc");
		fd.put("vvvv", "ddddd");
		fd.put("mmmm", "eeeee");
		fd.put("oooo", "fffff");
		fd.put("kkkk", "ggggg");
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
