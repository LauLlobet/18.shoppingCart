package shopping;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingRepositoryShould {
    private ItemRepository itemRepository = new ItemRepository();

    @Test
    public void
    store_items_and_provide_their_price() {
        itemRepository.add("Hamlet",50);

        Integer price = itemRepository.getPriceFor("Hamlet");

        assertThat(price,is(50));
    }
}
