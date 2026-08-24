package com.urlshortner;

public class UrlMapping {
    
    private final long id;
    private final String shortCode;
    private final String originalUrl;

    public UrlMapping(long id, String shortCode, String originalUrl){
        this.id = id;
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }

    public long getId(){
        return id;
    }

    public String getShortCode(){
        return shortCode;
    }

    public String getOriginalUrl(){
        return originalUrl;
    }
}
