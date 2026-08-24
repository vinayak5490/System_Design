package com.urlshortner;

public class Main {

    public static void main(String[] args) {
        UrlShortener shortner = new UrlShortener();

        String shortCode1 = shortner.shorten("https://www.google.com");
        String shortCode2 = shortner.shorten("https://www.youtube.com");

        System.out.println("Short Code 1: " + shortCode1);
        System.out.println("Short code 2: " + shortCode2);

        System.out.println("Original URL: " + shortner.getOriginalUrl(shortCode1));
    }
}