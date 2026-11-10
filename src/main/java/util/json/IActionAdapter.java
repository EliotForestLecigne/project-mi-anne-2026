package util.json;

import action.ActionEnum;
import action.IAction;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

public class IActionAdapter implements JsonSerializer<IAction>, JsonDeserializer<IAction> {
    @Override
    public IAction deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String name;
        if(jsonElement.isJsonPrimitive()){
            name = jsonElement.getAsString();
        }else {
            throw new JsonParseException("Incorect format for Action : "+ jsonElement);
        }
        return Arrays.stream(ActionEnum.values()).filter(actionEnum -> Objects.equals(actionEnum.getName(), name)).findFirst().orElseThrow(() -> new JsonParseException("Invalid Action name")).getAction();
    }

    @Override
    public JsonElement serialize(IAction iAction, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(iAction.getName());
    }
}
