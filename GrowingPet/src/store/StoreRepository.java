package store;

public class StoreRepository {
    private static StoreRepository storeRepository;

    public static StoreRepository getInstance(){
        if (storeRepository == null){
            storeRepository = new StoreRepository();
        }
        return storeRepository;
    }
}
