package com.hdt6.factory;
import java.util.Map;

public interface MapFactory {
    <K,V> Map<K,V> createMap();
}
