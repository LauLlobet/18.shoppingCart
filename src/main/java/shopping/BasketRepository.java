package shopping;

import java.util.Hashtable;

public class BasketRepository {
    private Hashtable<String, Basket> hashTable = new Hashtable<>();

    public void store(Basket basket) {
        hashTable.put(basket.getUserId(),basket);
    }

    public Basket getFrom(String user) {
        return hashTable.get(user);
    }
}
