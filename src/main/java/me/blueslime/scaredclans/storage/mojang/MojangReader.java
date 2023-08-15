package me.blueslime.scaredclans.storage.mojang;

public class MojangReader {
    public String getName(String uuid) {
        return "";
    }

    public String getUUID(String name) {
        return "";
    }

    public String getTexture(String uuid) {
        return "";
    }

    public void cacheUser(String value, boolean texture) {
        return;
    }

    public String convertUUID(String uuid) {
        return uuid.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
    }

    private String readURL(String url) {
        return "";
    }
}
