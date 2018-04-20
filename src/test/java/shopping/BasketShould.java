package shopping;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BasketShould {

    private static final String PRODUCT_ID_2 = "productId2";
    private static final String PRODUCT_ID_1 = "productId1";

    @Test
    public void
    strore_product_and_quantity_record() { // cration and agregation testing no mock or stub

        Basket basket = new Basket("USER1");
        ArrayList<ProductQuantityRecord> productQuantityList = new ArrayList<>();

        ProductQuantityRecord producQuantity1 = new ProductQuantityRecord(PRODUCT_ID_1,1);
        productQuantityList.add(producQuantity1);
        ProductQuantityRecord producQuantity2 = new ProductQuantityRecord(PRODUCT_ID_2,2);
        productQuantityList.add(producQuantity2);

        basket.addProductQuantity(PRODUCT_ID_1,1);
        basket.addProductQuantity(PRODUCT_ID_2,2);

        assertThat(basket.getListOfProductQuantity(),
                IsIterableContainingInOrder.contains(productQuantityList.toArray()));
    }
}
