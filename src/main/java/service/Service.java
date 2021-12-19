package service;

import repository.RepositoryBasis;

import java.util.UUID;

public class Service {

    private RepositoryBasis repository;

    public Service(RepositoryBasis repository){
        this.repository = repository;
    }

    public void addItem(UUID idGuid, String name){

        this.repository.addItem(idGuid, name);

    }

    public String getItem(UUID idGuid){
        return this.repository.getItem(idGuid);
    }

    public int getItemsQuantity(){
        return this.repository.getItemsQuantity();
    }
}
