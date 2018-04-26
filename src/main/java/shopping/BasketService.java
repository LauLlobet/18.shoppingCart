package shopping;

public class BasketService {
    private final BasketRepository basketRepository;
    private ItemRepository itemRepository;

    public BasketService(BasketRepository basketRepository, ItemRepository itemRepository) {
        this.basketRepository = basketRepository;
        this.itemRepository = itemRepository;
    }

    public Basket basketFor(String userId) {
        return basketRepository.getFrom(userId).orElseThrow(BasketNotFoundException::new);
    }

    public void addItem(String userId, String itemId, int quantity) {

        Basket basket = basketRepository.getFrom(userId).orElseGet(() -> {
            Basket newBasket = new Basket(userId, itemRepository);
            basketRepository.store(newBasket);
            return newBasket;
        });
        basket.addItemQuantity(itemId,quantity);
        basketRepository.store(basket);
    }
}
