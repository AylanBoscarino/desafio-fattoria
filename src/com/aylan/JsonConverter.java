package com.aylan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List; 

public class JsonConverter implements JsonSerializer<Produto>{
    
    private final Gson gson;
    
    public JsonConverter() {
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        gson = b.create();
        //gson = new GsonBuilder().create();
    }

    public JsonObject convertToJson(List<Produto> produtos) {
        
    	
        JsonArray jarray = gson.toJsonTree(produtos).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("produtos", jarray);

        return jsonObject;
    }

	@Override
	public JsonElement serialize(Produto arg0, Type arg1, JsonSerializationContext arg2) {
		// TODO Auto-generated method stub
		return null;
	}
   
}