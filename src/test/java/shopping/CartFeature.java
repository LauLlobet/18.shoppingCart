package shopping;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartFeature {
    private static final String USER_ID = "user1" ;
    private static final String HOBBIT_ITEM_ID = "hobbit";
    private static final String BB_ITEM_ID = "breaking";

    private BasketService basketService;
    private ItemRepository itemRepository;

    @Before
    public void set_up(){
        itemRepository = new ItemRepository();
        itemRepository.add(HOBBIT_ITEM_ID,5);
        itemRepository.add(BB_ITEM_ID,7);
        basketService = new BasketService(new BasketRepository(), itemRepository);
    }

    @Test
    public void
    permit_calculation_of_price_of_a_set_of_items_given_a_user() {

        basketService.addItem(USER_ID, HOBBIT_ITEM_ID,2);
        basketService.addItem(USER_ID,BB_ITEM_ID,5);
        Basket basket = basketService.basketFor(USER_ID);

        assertThat(basket.getPriceAmount(),is(45));
    }
}
