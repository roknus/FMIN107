package Dictionary;

public class OrderedDictonary extends AbstractDictionary {
	public OrderedDictonary(){
		super();
	}
	
	public OrderedDictonary(int t){
		super(t);
	}
	
	@Override
	public int indexOf(Object key) {
		for(int i=0; i<keys.length; i++){
			if(keys[i] == key)
				return i;
		}
		return -1;
	}

	@Override
	public int newIndexOf(Object key) {
		if(size() == keys.length){
			
			Object[] newKeys = new Object[keys.length+1];
			Object[] newValues = new Object[keys.length+1];
			for(int i=0;i<keys.length;i++){
				newKeys[i] = keys[i];
				newValues[i] = values[i];
			}
			values = newValues;
			keys = newKeys;
			return keys.length;	
		}else{
			return size()+1;
		}
	}

	@Override
	public int size() {
		int t=0;
		while(keys[t]!=null)
			t++;
		return t;
	}

}
