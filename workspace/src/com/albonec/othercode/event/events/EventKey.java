package com.albonec.othercode.event.events;

import com.albonec.othercode.event.Event;

public class EventKey extends Event {
    private int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
