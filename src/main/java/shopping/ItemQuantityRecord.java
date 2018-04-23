package shopping;

import java.util.Objects;

public class ItemQuantityRecord {
    private final String itemId;
    private final int quantity;

    ItemQuantityRecord(String itemId, int quantity) {

        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemQuantityRecord that = (ItemQuantityRecord) o;
        return quantity == that.quantity &&
                Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId, quantity);
    }

}
