package pair;

import java.util.ArrayList;

/**
 * @author OGUNDE KEHINDE
 *         This class is a generics class with two types
 *         {@literal} <K> key of element
 *         {@literal} <V> value of element
 *         <b>An Example code</b>
 *         {@code} pair<String, String> pair = new pair<>("Hello", "World");
 */
public class Pair<K, V> {
    public static final String DEFAULT_KEY = "";
    public static final ArrayList<String> DEFAULT_VALUE = new ArrayList<>();

    private K key;
    private V value;

    /**
     * Accepts two parameter of types
     * {@literal} <K> of element
     * {@literal} <V> of element
     *
     * @param key   key to be stored
     * @param value value to be stored
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
