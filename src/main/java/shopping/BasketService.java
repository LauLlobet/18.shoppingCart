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

        basketRepository.store(new Basket(userId));
    }
}
