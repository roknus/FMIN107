package PatternComposite;

public class File extends Element 
{
	private String content;
	
	public File(Directory parent, String name)
	{
		super(parent,name,0);
		this.content = "";
	}
	
	@Override
	public int size() 
	{
		return this.content.length();
	}
	
	public void cat()
	{
		System.out.println(content);
	}
	
	public int nbElement()
	{
		return nSpaces(content) +1 ;
	}
	
	static int nSpaces ( String s ) {
		int n = 0;
		if ( s.length() > 0 ) {
			if ( s.length() > 1 ) {
				// Split it in half.
				int center = s.length() / 2;
				// Count each half.
				n += nSpaces(s.substring(0, center)) + nSpaces(s.substring(center));
			} else {
				// Just 1 character.
				if ( s.charAt(0) == ' ' ) {
					// It's a space.
					n += 1;
		        	}
		      	}
		}
		//System.out.println(n+" spaces in '"+s+"'");
		return n;
	}
}
