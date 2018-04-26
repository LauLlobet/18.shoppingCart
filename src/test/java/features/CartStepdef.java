package features;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    private String user;

    @Given("^I add (\\d+) units of \"([^\"]*)\" to the shopping basket$")
    public void iAddUnitsOfToTheCartOf(int amount, String itemId) throws Throwable {
        basketService.addItem(user,itemId,amount);
    }

    @When("^I check the content of the shopping basket$")
    public void iGetTheBasketOf() throws Throwable {
        tempBasket = basketService.basketFor(user);
    }

    @Then("^it contains the following price:(\\d+)$")
    public void theBasketPriceIs(int price) throws Throwable {
        assertThat(tempBasket.getPriceAmount(),is(price));
    }

    @Given("^a \"([^\"]*)\" product is avaliable at (\\d+) euros$")
    public void thatTheDatabaseHasItemAtEuros(String itemId, int price) throws Throwable {
        itemRepository.add(itemId,price);
    }

    @Given("^a user of a shopping basket \"([^\"]*)\"$")
    public void aUserOfAShoppingBasket(String user) throws Throwable {
        itemRepository = new ItemRepository();
        basketService = new BasketService(new BasketRepository(),itemRepository);
        this.user = user;
    }
}
