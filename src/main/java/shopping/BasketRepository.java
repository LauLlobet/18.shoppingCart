package shopping;

import java.util.Hashtable;
import java.util.Optional;

public class BasketRepository {
    private Hashtable<String, Basket> hashTable = new Hashtable<>();

    public void store(Basket basket) {
        hashTable.put(basket.getUserId(),basket);
    }

    public Optional<Basket> getFrom(String user) {
        return Optional.ofNullable(hashTable.get(user));
    }
}
