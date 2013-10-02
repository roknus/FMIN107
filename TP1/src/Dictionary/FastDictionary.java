package Dictionary;

public class FastDictionary extends AbstractDictionary {

	public FastDictionary() {
		super(5);
		// TODO Auto-generated constructor stub
	}

	public FastDictionary(int t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int indexOf(Object key) {
		int hash = Math.abs(key.hashCode()%keys.length-1);
		while(hash<keys.length && key!=keys[hash])
			hash++;
		if(hash==keys.length)
			return -1;
		else
			return hash;
	}

	@Override
	public int newIndexOf(Object key) {
		if(mustGrow())
			grow();
		int hash = Math.abs(key.hashCode()%keys.length-1);
		while(hash < this.keys.length && keys[hash]!=null)
			hash++;
		return hash;

	}

	@Override
	public int size() {
		int t=0;
		for(int i=0; i<keys.length; i++){
			if(keys[i]!=null)
				t++;
		}
		return t;
	}

	private boolean mustGrow(){
		return (size() > keys.length*0.75 ? true : false);
	}
	
	private void grow(){
		Object[] newKeys = new Object[keys.length+5];
		Object[] newValues = new Object[keys.length+5];
		for(int i=0;i<keys.length;i++){
			if(this.keys[i] != null)
			{
				int key = Math.abs(this.keys[i].hashCode()%newKeys.length-1);
				while(newKeys[key] != null) key++;
				newKeys[key] = this.keys[i];
				newValues[key] = this.values[i];				
			}
		}
		keys = newKeys;
		values = newValues;
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
