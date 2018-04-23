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

    private static final Basket BASKET_OF_USER_1 = new Basket(USER_1_ID, new ItemRepository());
    private static final String item_ID = "item1";

    @Mock
    private BasketRepository basketRepository;
    private BasketService basketService;

    @Mock
    private Basket basketMock; // when naming of mock make sense
    @Mock
    private ItemRepository itemRepository;

    @Before
    public void set_up(){
        basketService = new BasketService(basketRepository,itemRepository);
    }

    @Test
    public void
    store_basket_when_adding_item() {

        basketService.addItem(USER_1_ID,ITEM_1_ID, 2);

        verify(basketRepository, atLeast(1)).store(BASKET_OF_USER_1);
    }

    @Test
    public void
    provide_basket_after_adding_items_to_it() {

        when(basketRepository.getFrom(USER_1_ID)).thenReturn(Optional.of(BASKET_OF_USER_1));

        Basket basket = basketService.basketFor(USER_1_ID);

        assertThat(basket,is(BASKET_OF_USER_1));
    }

    @Test
    public void
    add_items_to_basket_when_adding_items() {

        when(basketRepository.getFrom(USER_1_ID)).thenReturn(Optional.of(basketMock));

        basketService.addItem(USER_1_ID,item_ID,3);

        verify(basketMock).addItemQuantity(item_ID,3);
    }


}
