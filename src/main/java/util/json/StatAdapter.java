package util.json;

import com.google.gson.*;
import entity.Stat;
import util.exception.InvalidInputException;

import java.lang.reflect.Type;

public class StatAdapter  implements JsonDeserializer<Stat> {
    @Override
    public Stat deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int maxHP = jsonObject.get("maxHP").getAsInt();
        int maxMP = jsonObject.get("maxMP").getAsInt();
        int strength = jsonObject.get("strength").getAsInt();
        int defence = jsonObject.get("defence").getAsInt();
        int agility = jsonObject.get("agility").getAsInt();
        int evasionRate = jsonObject.get("evasionRate").getAsInt();
        int luck = jsonObject.get("luck").getAsInt();


        try {
            return new Stat(maxHP, maxMP, strength, defence, agility, evasionRate, luck);
        }catch (InvalidInputException e){
            throw new InvalidInputException(e.getMessage() +"\nerror in json : "+ jsonElement.toString());
        }
    }
}
