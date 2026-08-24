package com.urlshortner;

public class Base62Encoder {
    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encode(long number){

        if(number == 0){
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while(number > 0){
            int remainder = (int)(number % 62);

            result.append(CHARACTERS.charAt(remainder));

            number /= 62;
        }

        return result.reverse().toString();
    }
}
