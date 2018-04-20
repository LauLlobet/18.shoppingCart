package shopping;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BasketShould {

    public static final String PRODUCT_ID_2 = "productId2";
    public static final String PRODUCT_ID_1 = "productId1";

    @Test
    public void
    strore_product_quantity() {
        Basket basket = new Basket("USER1");
        ArrayList<ProductQuantity> productQuantityList = new ArrayList();

        ProductQuantity producQuantity1 = new ProductQuantity(PRODUCT_ID_1,1);
        productQuantityList.add(producQuantity1);
        ProductQuantity producQuantity2 = new ProductQuantity(PRODUCT_ID_2,2);
        productQuantityList.add(producQuantity2);

        basket.addProductQuantity(PRODUCT_ID_1,1);
        basket.addProductQuantity(PRODUCT_ID_2,2);

        assertThat(basket.getListOfProductQuantity(),
                IsIterableContainingInOrder.contains(productQuantityList.toArray()));
    }
}
