package shopping;

import java.util.Objects;

public class ProductQuantityRecord {
    private final String productId;
    private final int quantity;

    ProductQuantityRecord(String productId, int quantity) {

        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantityRecord that = (ProductQuantityRecord) o;
        return quantity == that.quantity &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, quantity);
    }
}
