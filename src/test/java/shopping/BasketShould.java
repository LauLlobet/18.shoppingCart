package shopping;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasketShould {

    private static final String ITEM_ID_2 = "itemId2";
    private static final String ITEM_ID_1 = "itemId1";
    private Basket basket;

    @Mock
    ItemRepository itemRepository;

    @Before
    public void set_up() {
        basket = new Basket("USER1",itemRepository);
    }

    @Test
    public void
    store_item_and_quantity_record() {

        set_up();
        ArrayList<ItemQuantityRecord> itemQuantityList = new ArrayList<>();

        ItemQuantityRecord producQuantity1 = new ItemQuantityRecord(ITEM_ID_1,1);
        itemQuantityList.add(producQuantity1);
        ItemQuantityRecord producQuantity2 = new ItemQuantityRecord(ITEM_ID_2,2);
        itemQuantityList.add(producQuantity2);

        basket.addItemQuantity(ITEM_ID_1,1);
        basket.addItemQuantity(ITEM_ID_2,2);

        assertThat(basket.getListOfItemQuantity(),
                IsIterableContainingInOrder.contains(itemQuantityList.toArray()));
    }

    @Test
    public void
    calculate_the_total_amount() {
        when(itemRepository.getPriceFor(ITEM_ID_1)).thenReturn(5);
        when(itemRepository.getPriceFor(ITEM_ID_2)).thenReturn(7);

        basket.addItemQuantity(ITEM_ID_1,2);
        basket.addItemQuantity(ITEM_ID_2,5);

        assertThat(basket.getPriceAmount(),is(45));
    }
}
