package shopping;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceShould {

    private static final String USER_1_ID = "user1";
    private static final User USER_1 = new User(USER_1_ID);

    private static final String ITEM_1_ID = "item1";

    private static final Basket BASKET_OF_USER_1 = new Basket(USER_1_ID);

    @Mock
    private BasketRepository basketRepository;
    private BasketService basketService;

    @Before
    public void set_up(){
        basketService = new BasketService(basketRepository);
    }

    @Test
    public void
    store_basket_when_adding_item() { // command + mock
        //user is not in the public api
        //should be used with mocks:

        basketService.addItem(USER_1_ID,ITEM_1_ID);

        verify(basketRepository).store(BASKET_OF_USER_1);
    }

    @Test
    public void
    basket_should_be_retreivable_after_adding_items_to_it() { //query + stub

        when(basketRepository.getFrom(USER_1_ID)).thenReturn(BASKET_OF_USER_1);

        Basket basket = basketService.basketFor(USER_1_ID);

        assertThat(basket,is(BASKET_OF_USER_1));
    }


}
