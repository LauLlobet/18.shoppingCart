package shopping;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasketRepositoryShould {

    private static final String USERID_1 = "USERID_1";
    private static final Basket BASKET_1 = new Basket(USERID_1, new ItemRepository());
    //maybe we'll need a defautlbasket constructor so we dont have to touch all constructors
    //when basket evolves

    @Test
    public void
    store_and_retrival_of_baskets() {
        BasketRepository basketRepository = new BasketRepository();
        basketRepository.store(BASKET_1);

        Optional<Basket> basket = basketRepository.getFrom(USERID_1);

        assertThat(basket,is(Optional.of(BASKET_1)));
    }
}
