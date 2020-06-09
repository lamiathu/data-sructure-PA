
public class ArrayList<T> implements List<T> {
	
	private int maxsize;
	private int size;
	private int current;
	private T[] nodes;
 
	public ArrayList(int n) {
		maxsize = n;
		size = 0;
		current = -1;
		nodes = (T[]) new Object[n];
	}
	public boolean full () {
		return size == maxsize;
	}
	public boolean empty () {
		return size == 0;
	}
	public boolean last () {
		return current == size - 1;
	}
	public void findFirst () {
		current = 0;
	}
	public void findNext () {
		current++;
	}
	public T retrieve () {
		return nodes[current];
	}

	public void update (T e) {
		nodes[current] = e;
	}

	public void insert (T e) {
		for (int i = size-1; i > current; --i) {
			nodes[i+1] = nodes[i];
		}
		current++;
		nodes[current] = e;
		size++;
	}
	
	public void remove () {
		for (int i = current + 1; i < size; i++) {
			nodes[i-1] = nodes[i];
		}
		size--;
		if (size == 0)
			current = -1;
		else if (current == size)
			current = 0;
	}

	// Searches for the first element that satisfies a condition. If found, it is set as current and true is returned, otherwise current remains unchanged and false is returned. The condition is tested using cnd.
	public boolean findFirstEle(Cond<T> cnd) {
		for(int i=0; i<size; i++) {
			if(cnd.test(nodes[i])) {
			current=i;
			return true;
			}
				
		}
		return false;
	}
	// Searches and returns all elements that satisfy a condition. If none is found, the empty list is returned. This method does not change current. The condition is tested using cnd.
	public List<T> findAllEle(Cond<T> cnd){
		List<T> list=new ArrayList<>(size);
		for(int i=0; i<size; i++) {
			if(cnd.test(nodes[i])) {
				list.insert(nodes[i]);
			}
		}
		return list;
	}
}
