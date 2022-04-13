package me.obsilabor.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonUtils {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static JsonObject toJson(Object obj) {
        return new JsonParser().parse(GSON.toJson(obj)).getAsJsonObject();
    }

    public static JsonObject fromString(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }

    public static <T> T fromJson(JsonObject json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

}