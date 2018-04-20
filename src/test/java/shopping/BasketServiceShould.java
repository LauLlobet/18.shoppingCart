package shopping;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceShould {

    private static final String USER_1_ID = "user1";

    private static final String ITEM_1_ID = "item1";

    private static final Basket BASKET_OF_USER_1 = new Basket(USER_1_ID);
    private static final String PRODUCT_ID = "product1";

    @Mock
    private BasketRepository basketRepository;
    private BasketService basketService;

    @Mock
    private Basket basketMock; // when naming of mock make sense

    @Before
    public void set_up(){
        basketService = new BasketService(basketRepository);
    }

    @Test
    public void
    store_basket_when_adding_item() { // command + mock
        //user is not in the public api
        //should be used with mocks:

        basketService.addItem(USER_1_ID,ITEM_1_ID, 2);

        verify(basketRepository, atLeast(1)).store(BASKET_OF_USER_1);
    }

    @Test
    public void
    should_provide_basket_after_adding_items_to_it() { //query + stub

        when(basketRepository.getFrom(USER_1_ID)).thenReturn(Optional.of(BASKET_OF_USER_1));

        Basket basket = basketService.basketFor(USER_1_ID);

        assertThat(basket,is(BASKET_OF_USER_1));
    }

    @Test
    public void
    add_items_to_basket_when_adding_items() { // command + mock

        when(basketRepository.getFrom(USER_1_ID)).thenReturn(Optional.of(basketMock));

        basketService.addItem(USER_1_ID,PRODUCT_ID,3);

        verify(basketMock).addProductQuantity(PRODUCT_ID,3);
    }

}
