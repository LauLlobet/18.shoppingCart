package shopping;

public class BasketService {
    private final BasketRepository basketRepository;

    BasketService(BasketRepository basketRepository) {

        this.basketRepository = basketRepository;
    }

    public Basket basketFor(String userId) {
        return basketRepository.getFrom(userId).orElseThrow(BasketNotFoundException::new);
    }

    public void addItem(String userId, String itemId, int quantity) {

        Basket basket = basketRepository.getFrom(userId).orElseGet(() -> {
            Basket newBasket = new Basket(userId);
            basketRepository.store(newBasket);
            return newBasket;
        });
        basket.addProductQuantity(itemId,quantity);
        basketRepository.store(basket);
    }
}
