package shopping;

public class BasketService {
    private final BasketRepository basketRepository;

    BasketService(BasketRepository basketRepository) {

        this.basketRepository = basketRepository;
    }

    public Basket basketFor(String userId) {
        return basketRepository.retrive(userId);
    }

    public void addItem(String userId, String itemId) {
        basketRepository.store(new Basket(userId));
    }
}
