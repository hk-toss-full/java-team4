package store;

public class StoreService {
    private static StoreService storeService;
    private StoreRepository storeRepository;

    private StoreService() {
        storeRepository = storeRepository.getInstance();
    }

    public static StoreService getInstance(){
        if (storeService == null){
            storeService = new StoreService();
        }
        return storeService;
    }
}
