package PatternComposite;

public abstract class Element 
{
	protected Directory parent;
	protected String name;
	protected int basicSize;
	
	public Element(Directory parent, String name, int basicSize)
	{
		this.parent = parent;
		this.name = name;
		this.basicSize = basicSize;
	}
	
	public abstract int size();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBasicSize() {
		return basicSize;
	}
	public void setBasicSize(int basicSize) {
		this.basicSize = basicSize;
	}
	public String absoluteAddress(Element d)
	{
		if(d.getParent() == null)
		{
			return "/";
		}
		else
		{
			return absoluteAddress(d.getParent())+d.getName()+"/";
		}
	}
	
	public Directory getParent()
	{
		return parent;
	}
}
