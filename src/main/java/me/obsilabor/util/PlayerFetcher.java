package me.obsilabor.util;

import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class PlayerFetcher {

    private String name;
    private UUID uuid;
    private String uuidURL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private String nameURL = "https://api.mojang.com/users/profiles/minecraft/";

    public UUID getUuid() {
        return uuid;
    }

    public String getUuidURL() {
        return uuidURL;
    }

    public String getNameURL() {
        return nameURL;
    }

    public PlayerFetcher(String name) {
        this.name = name;
    }

    public PlayerFetcher(UUID uuid) {
        this.uuid = uuid;
    }

    public JsonObject getPlayerJson() throws IOException {
        URL url;

        if (this.name != null) {
            url = new URL(nameURL + name);
        } else {
            url = new URL(uuidURL + uuid);
        }
        URLConnection urlConnection = url.openConnection();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        if(!stringBuilder.toString().startsWith("{")){
            return null;
        }
        return GsonUtils.fromString(stringBuilder.toString());
    }

    public UUID getUUID() throws IOException {
        String uuidTemp = getPlayerJson().get("id").getAsString();
        String uuid = "";
        for (int i = 0; i <= 31; i++) {
            uuid = uuid + uuidTemp.charAt(i);
            if (i == 7 || i == 11 || i == 15 || i == 19) {
                uuid = uuid + "-";
            }
        }

        if(getPlayerJson() != null){
            return UUID.fromString(uuid);
        }
        return null;
    }

    public String getName() throws IOException {
        if(getPlayerJson() != null){
            return getPlayerJson().get("name").getAsString();
        }
        return null;
    }

}