package shopping;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartFeature {
    private static final String USER_ID = "user1" ;
    private static final String HOBBIT_ITEM_ID = "hobbit";
    private BasketService basketService;
    //decided not to call it shopping cart, so i don't have to add shopping everywhere asa a prefix

    @Before
    public void set_up(){
        basketService = new BasketService(new BasketRepository());
    }

    @Test
    public void
    permit_aggregation_of_products_at_users() { //simplest user feature

        basketService.addItem(USER_ID, HOBBIT_ITEM_ID,2);
        Basket basket = basketService.basketFor(USER_ID);
        assertThat(basket.getUserId(),is(USER_ID));
        assertThat(basket.getListOfProductQuantity().get(0).quantity(),2);
    }
}
