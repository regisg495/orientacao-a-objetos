package subtipagem_interfaces.KeyValue;

public interface IKeyValue {

	void put(String string, Integer i);

	Integer get(String string);

	boolean hasKey(String string);

	String[] getKeys();

	Integer[] getValues();

	boolean remove(String key);

	void reset();

}
