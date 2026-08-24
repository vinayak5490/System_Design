package com.urlshortner;

import java.util.HashMap;
import java.util.Map;

public class UrlShortener {

    private final IdGenerator idGenerator;
    private final Base62Encoder encoder;

    private final Map<String, UrlMapping> urlStore;

    public UrlShortener() {
        this.idGenerator = new IdGenerator();
        this.encoder = new Base62Encoder();
        this.urlStore = new HashMap<>();
    }

    public String shorten(String longUrl) {

        long id = idGenerator.generateId();

        String shortCode = encoder.encode(id);

        UrlMapping mapping = new UrlMapping(
                id,
                shortCode,
                longUrl);

        urlStore.put(shortCode, mapping);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {

        UrlMapping mapping = urlStore.get(shortCode);

        if (mapping == null) {
            return null;
        }

        return mapping.getOriginalUrl();
    }
}