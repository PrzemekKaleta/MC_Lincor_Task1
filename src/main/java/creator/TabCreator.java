package creator;

import entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TabCreator {

    final static int RATIO_RECORDS = 5;

    private List<Item> itemDB = new ArrayList<>();

    private List<Item> commandsItem = new ArrayList<>();

    private List<UUID> queryItemID = new ArrayList<>();


    public TabCreator(int complexityNumber) {

        if(complexityNumber < 1){
            throw new IllegalArgumentException("parameter to low, minimum value can not be lower than 1");
        }else if(complexityNumber > 20){
            throw new IllegalArgumentException("parameter to high, max value can not be higher than 20");
        }

        int asksNb = (int) Math.pow(2.0, complexityNumber);

        int recordsBD = asksNb * RATIO_RECORDS;

        for(int i = 0; i < recordsBD; i++){

            this.itemDB.add(new Item(DataCreator.generateUUID(),DataCreator.generateName()));

        }

        for(int i = 0; i < asksNb; i++){

            this.queryItemID.add(itemDB.get(i).getID_uuid());
        }

        for(int i = 0; i <asksNb; i++){

            this.commandsItem.add(new Item(DataCreator.generateUUID(),DataCreator.generateName()));
        }

        Collections.shuffle(itemDB);


    }

    public List<Item> getItemDB() {
        return itemDB;
    }

    public List<Item> getCommandsItem() {
        return commandsItem;
    }

    public List<UUID> getQueryItemID() {
        return queryItemID;
    }
}
