package Dictionary;

public class SortedDictionary extends AbstractDictionary {

	@Override
	public int indexOf(Object key) {
		int i = 0;
		while(this.keys[i] != key && i < this.keys.length) i++;
		return i == this.keys.length ? -1 : i;
	}

	@Override
	public int newIndexOf(Object key) {
		if(size() == keys.length){
			
			Object[] newKeys = new Object[keys.length+1];
			Object[] newValues = new Object[keys.length+1];
			for(int i=0;i<keys.length;i++){
				if(this.keys[i].compareTo(key))
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
		// TODO Auto-generated method stub
		return 0;
	}

}
