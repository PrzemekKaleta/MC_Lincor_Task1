package repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RepositoryBasis {

    private Map<UUID,String> storageItems = new HashMap<>();

    public void addItem(UUID idGuid, String name){

        this.storageItems.putIfAbsent(idGuid, name);
    }

    public String getItem(UUID idGuid) {

        return this.storageItems.get(idGuid);
    }

    public int getItemsQuantity(){
        return this.storageItems.size();
    }

}
