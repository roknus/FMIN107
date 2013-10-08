package Dictionary;

public class SortedDictionary extends AbstractDictionary {
	
	public SortedDictionary()
	{
		super();
	}
	
	public SortedDictionary(int t)
	{
		super(t);
	}

	@Override
	public int indexOf(Object key) {
		int i = 0;
		while(i < this.keys.length && this.keys[i] != key) i++;
		return i == this.keys.length ? -1 : i;
	}

	@Override
	public int newIndexOf(Object key) {
		int pos = 0;
		Object[] newKeys;
		Object[] newValues;
		if(size() == keys.length)
		{
			newKeys = new Object[keys.length+1];
			newValues = new Object[keys.length+1];
		}
		else
		{
			newKeys = new Object[keys.length];
			newValues = new Object[keys.length];
		}		
		for(int i=0;i<keys.length;i++)
		{
			if( ((Comparable)keys[i]).compareTo((Comparable)key) < 0)
			{
				newKeys[i] = keys[i];
				newValues[i] = values[i];
				pos = i+1;
			}
			else
			{
				newKeys[i+1] = keys[i];
				newValues[i+1] = values[i];
			}
		}
		values = newValues;
		keys = newKeys;
		return pos;	
	}

	@Override
	public int size() {
		int size = 0;
		for(int i = 0; i< keys.length ; i++)
		{
			if( keys[i] != null)
			{
				size += 1;
			}
		}
		return size;
	}
	
	public String toString()
	{
		String s = "";
		for(int i=0;i<this.keys.length;i++)
		{
			if(keys[i] != null) s+="'"+keys[i]+"' -> '"+values[i]+"'\n";
		}
		return s;
	}
}
