package shopping;

import org.junit.Before;
import org.junit.Test;
import shopping.Basket;
import shopping.BasketService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartFeature {
    private static final String USER_ID = "user1" ;
    private static final String LOTR_ITEM_ID = "lotr1";
    private BasketService basketService;
    //decided not to call it shopping cart, so i dont have to add shopping everywhere asa a prefix

    @Before
    public void set_up(){
        basketService = new BasketService(new BasketRepository());
    }

    @Test
    public void
    permit_agregation_of_products_at_users() { //simplest user feature

        basketService.addItem(USER_ID,LOTR_ITEM_ID);
        Basket basket = basketService.basketFor(USER_ID);
        assertThat(basket.getUserId(),is(USER_ID));
    }
}
