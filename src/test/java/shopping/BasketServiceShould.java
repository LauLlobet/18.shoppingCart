package shopping;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.*;

import static org.mockito.Mockito.verify;

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
    create_user_if_not_exist_when_adding_item() {
        //user is not in the public api
        //should be used with mocks:

        basketService.addItem(USER_1_ID,ITEM_1_ID);

        verify(basketRepository).store(BASKET_OF_USER_1);
    }
}
