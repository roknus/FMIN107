package Dictionary;

public abstract class AbstractDictionary implements IDictionary{
	protected Object[] keys;
	protected Object[] values;
	
	public AbstractDictionary(){
		keys = new Object[0];
		values = new Object[0];
	}
	
	public AbstractDictionary(int t){
		keys = new Object[t];
		values = new Object[t];
	}
	
	public Object get(Object key) throws Exception{
		int p = indexOf(key);
		if(p != -1){
			return values[p];
		}else
			throw new Exception();
	}
	
	public Object put(Object key, Object value){
		int i = indexOf(key);
		if(i == -1){
			int p = newIndexOf(key);
			keys[p] = key;
			values[p] = value;
		}
		return this;
	}
	
	public boolean isEmpty(){
		if(size() == 0)
			return true;
		else
			return false;
	}
	
	public boolean containsKey(Object key){
		if(indexOf(key)!=-1)
			return true;
		else 
			return false;
	}
	
	public abstract int indexOf(Object key);
	public abstract int newIndexOf(Object key);
	public abstract int size();
}
