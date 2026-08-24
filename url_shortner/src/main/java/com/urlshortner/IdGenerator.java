package com.urlshortner;

import java.util.concurrent.atomic.AtomicLong;
public class IdGenerator {
    private final AtomicLong currentId = new AtomicLong(0);

    public long generateId(){
        return currentId.incrementAndGet();
    }
    
}