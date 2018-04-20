package shopping;

import java.util.Objects;

public class Basket {
    private String userId;

    public Basket(String userId) {
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
}
