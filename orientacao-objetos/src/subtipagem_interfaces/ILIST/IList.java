package subtipagem_interfaces.ILIST;

public interface IList {
	
	int count();

	boolean isEmpty();
	
	public void append(Object o);
	
	public void prepend(Object o);
	
	public boolean insert(Object o, int index);
	
	public Object get(int index);
	
	public Object getFirst();
	
	public Object getLast();
	
	public Object getSample();
	
	public Object drop(int index);
	
	public boolean delete(int index);
	
	public boolean remove(Object o);
	
	public void reset();
	
	public boolean has(Object o);
	
	public int indexOf(Object o);



}
