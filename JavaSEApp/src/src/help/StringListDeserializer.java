/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BRAVANTIC
 */
public class StringListDeserializer  implements JsonDeserializer<List<String>> {
   
    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        List<String> listaDeStrings = new ArrayList<>();
        JsonArray jsonArray = json.getAsJsonArray();

        for (JsonElement elemento : jsonArray) {
            listaDeStrings.add(elemento.getAsString());
        }

        return listaDeStrings;
    }
    
}

