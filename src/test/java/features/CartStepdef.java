package features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Before;
import shopping.Basket;
import shopping.BasketRepository;
import shopping.BasketService;
import shopping.ItemRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CartStepdef {
    private BasketService basketService;
    private Basket tempBasket;
    private ItemRepository itemRepository;

    @Given("^a shopping cart$")
    public void aShoppingCart() throws Throwable {
        itemRepository = new ItemRepository();
        basketService = new BasketService(new BasketRepository(), itemRepository);
    }

    @Given("^I add (\\d+) units of \"([^\"]*)\" to the cart of \"([^\"]*)\"$")
    public void iAddUnitsOfToTheCartOf(int amount, String itemId, String user) throws Throwable {
        basketService.addItem(user,itemId,amount);
    }

    @Then("^I get the basket of \"([^\"]*)\"$")
    public void iGetTheBasketOf(String user) throws Throwable {
        tempBasket = basketService.basketFor(user);
    }


    @Then("^the basket price is (\\d+)$")
    public void theBasketPriceIs(int price) throws Throwable {
        assertThat(tempBasket.getPriceAmount(),is(price));
    }

    @Given("^that the database has item \"([^\"]*)\" at (\\d+) euros$")
    public void thatTheDatabaseHasItemAtEuros(String itemId, int price) throws Throwable {
        itemRepository.add(itemId,price);
    }
}
