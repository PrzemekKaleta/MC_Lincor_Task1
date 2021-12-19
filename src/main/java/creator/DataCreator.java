package creator;

import com.github.javafaker.Faker;

import java.util.UUID;

public class DataCreator {

    static Faker faker = new Faker();

    static public UUID generateUUID(){

        return java.util.UUID.randomUUID();
    }

    static public String generateName(){

        return faker.name().firstName();

    }
}
