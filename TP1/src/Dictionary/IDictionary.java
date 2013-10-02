package Dictionary;

public interface IDictionary{
	public Object get(Object key) throws Exception;
	public Object put(Object key, Object value);
	public boolean isEmpty();
	public boolean containsKey(Object key);
}
