package shopping;

import java.util.Hashtable;

public class ItemRepository {
    private Hashtable<String, Integer> hashtable = new Hashtable<>();

    public int getPriceFor(String itemId) {
        return hashtable.get(itemId);
    }

    public void add(String itemId, int price) {
        hashtable.put(itemId,price);
    }
}
