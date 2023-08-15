package me.blueslime.scaredclans.menus.types;

public class LocalMenu {

    private final String resource;
    private final String file;

    private LocalMenu(String resource, String file) {
        this.resource = "/" + resource;
        this.file = file;
    }

    public String getResource() {
        return resource;
    }

    public String getFile() {
        return file;
    }

    public static LocalMenu fromData(String file, String resource) {
        return new LocalMenu(
                resource,
                file
        );
    }
}