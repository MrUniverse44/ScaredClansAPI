package me.blueslime.scaredclans.utils.resource;

import java.io.InputStream;

public class LocalResource {
    private final InputStream src;
    private final String resource;
    private final String file;

    private LocalResource(String resource, String file) {
        this.resource = "/" + resource;
        this.file = file;
        this.src = null;
    }

    private LocalResource(InputStream resource, String file) {
        this.resource = null;
        this.src = resource;
        this.file = file;
    }

    public String getResource() {
        return resource;
    }

    public String getFile() {
        return file;
    }

    public static LocalResource fromData(String file, String resource) {
        return new LocalResource(
                resource,
                file
        );
    }

    public static LocalResource fromData(String file, InputStream resource) {
        return new LocalResource(
                resource,
                file
        );
    }

    public InputStream getSrc() {
        return src;
    }
}



