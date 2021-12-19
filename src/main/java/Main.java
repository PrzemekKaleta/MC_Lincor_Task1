import creator.TabCreator;
import entity.Item;
import repository.RepositoryBasis;
import service.Service;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Main {

    private final static int COMPLEXITY = 10;

    public static void main(String[] args) {

        //PRZYGTOWANIE DO TESTU

        //Uworzenie tablic w kreatorze - tablica danych, tablica zapytań, tablica do zapisów
        //comlexityNumber - przyjmuje od 1 do 20 oznacza ile rekordów i zapytań zostanie utworzonych (2 do potęgi n)

        TabCreator tabCreator = new TabCreator(COMPLEXITY);

        //Utworzenie klas do zapytań i obsługi

        RepositoryBasis repositoryBasis = new RepositoryBasis();
        Service service = new Service(repositoryBasis);


        List<Item> basicItemDB = tabCreator.getItemDB();
        Iterator<Item> itemIterator =tabCreator.getItemDB().iterator();

        while(itemIterator.hasNext()){
            Item item = itemIterator.next();
            service.addItem(item.getID_uuid(),item.getName());
        }

        List<Item> commandsItems = tabCreator.getCommandsItem();
        List<UUID> queryUUID = tabCreator.getQueryItemID();

        Iterator<Item> itemIteratorCommand = commandsItems.iterator();
        Iterator<UUID> uuidIterator = queryUUID.iterator();


        //Przerwa w programie na zakończenie działań CPU

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        

    }
}
