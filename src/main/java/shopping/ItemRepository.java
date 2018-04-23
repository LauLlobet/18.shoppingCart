package shopping;

public class ItemRepository {
    public int getPriceFor(String itemId) {
        if(itemId == "hobbit"){
            return 5;
        }
        return 7;
    }
}
