package PatternComposite;

import java.util.ArrayList;
import java.util.Collection;

public class Directory extends Element
{
	private ArrayList<Element> content;

	public Directory(Directory parent, String name)
	{
		super(parent,name,4);
		this.content = new ArrayList<Element>();
	}
	
	@Override
	public int size()
	{
		int size = 0;
		for(Element e : content)
		{
			size += e.size();
		}
		return size+basicSize;
	}
	
	public void ls()
	{
		String ls = "";
		for(Element e : content)
		{
			if(e instanceof Directory)
			{
				ls += "d ";
			}
			else
			{
				ls += "- ";
			}
			ls += e.getName()+"\n";
		}
		System.out.println(ls);
	}
	
	public int nbElement()
	{
		return content.size();
	}
	
	public Collection<String> find(String name)
	{
		Collection<String> c = new ArrayList<String>();
		for(Element e : content)
		{
			if(e.getName() == name)
			{
				c.add(e.absoluteAddress(e));
			}
		}
		return c;
	}
	
	public Collection<String> findR(String name)
	{
		Collection<String> c = new ArrayList<String>();
		for(Element e : content)
		{
			if(e.getName() == name)
			{
				c.add(e.absoluteAddress(e));
			}
			if(e instanceof Directory)
			{
				c.addAll(((Directory) e).findR(name));
			}
		}
		return c;
	}
}
