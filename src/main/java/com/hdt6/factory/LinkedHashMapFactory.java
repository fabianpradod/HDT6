package com.hdt6.factory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapFactory implements MapFactory {
    @Override
    public <K,V> Map<K , V> createMap() {
        return new LinkedHashMap<>();
    }
}
