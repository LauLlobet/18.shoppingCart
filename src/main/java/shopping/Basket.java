package shopping;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basket {
    private String userId;
    private final ItemRepository itemRepository;
    private ArrayList<ItemQuantityRecord> itemQuantityList = new ArrayList<>();

    Basket(String userId, ItemRepository itemRepository) {
        this.userId = userId;
        this.itemRepository = itemRepository;
    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<ItemQuantityRecord> getListOfItemQuantity() {
        return itemQuantityList;
    }

    public void addItemQuantity(String itemId, int quantity) {
        itemQuantityList.add(new ItemQuantityRecord(itemId,quantity));
    }

    public int getPriceAmount() {
        ArrayList<Integer> amounts =  itemQuantityList.stream()
                .map(x->x.getQuantity())
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> priceForItems =  itemQuantityList.stream()
                .map(ItemQuantityRecord::getItemId)
                .map(itemId -> itemRepository.getPriceFor(itemId))
                .collect(Collectors.toCollection(ArrayList::new));

        return IntStream.range(
                0, amounts.size())
                .mapToObj(i -> amounts.get(i) * priceForItems.get(i))
                .reduce(0,(x,y)->x+y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(userId, basket.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }

}
