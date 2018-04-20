package shopping;

import java.util.ArrayList;
import java.util.Objects;

public class Basket {
    private String userId;
    private ArrayList<ProductQuantity> productQuantityList = new ArrayList<>();

    Basket(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
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

    public ArrayList<ProductQuantity> getListOfProductQuantity() {
        return productQuantityList;
    }

    public void addProductQuantity(String productId, int quantity) {
        productQuantityList.add(new ProductQuantity(productId,quantity));
    }
}
