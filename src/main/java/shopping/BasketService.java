package shopping;

public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {

        this.basketRepository = basketRepository;
    }

    public Basket basketFor(String userId) {
        throw new UnsupportedOperationException();
    }

    public void addItem(String userId, String itemId) {
        basketRepository.store(new Basket(userId));
    }
}
