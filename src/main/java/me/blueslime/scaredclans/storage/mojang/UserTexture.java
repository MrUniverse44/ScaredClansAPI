package me.blueslime.scaredclans.storage.mojang;

public class UserTexture {

    private final String name;

    private final String uuid;

    private final long millis;

    private String texture = null;

    private UserTexture(String name, String uuid, long millis) {
        this.millis = millis;
        this.name = name;
        this.uuid = uuid;
    }

    public static UserTexture of(String name, String uuid, long millis) {
        return new UserTexture(
                name,
                uuid,
                millis
        );
    }

    public UserTexture copy() {
        UserTexture copy = new UserTexture(
                name,
                uuid,
                millis
        );

        copy.setTexture(texture);

        return copy;
    }

    public void setTexture(String textureUrl) {
        this.texture = textureUrl;
    }

    public String getTexture() {
        return this.texture;
    }

    public long getMillis() {
        return this.millis;
    }

    public String getName() {
        return this.name;
    }

    public String getUniqueId() {
        return this.uuid;
    }
}
