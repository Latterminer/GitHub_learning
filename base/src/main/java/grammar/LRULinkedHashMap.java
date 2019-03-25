package grammar;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap extends LinkedHashMap<String, Integer> {
    private static int MAX_CACHE_SIZE = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size()>MAX_CACHE_SIZE;
    }
    public LRULinkedHashMap(){
        super(MAX_CACHE_SIZE, 0.75f, true);
    }

    public static void main(String[] args) {

    }
}
