package com.grapeshot.halfnes;

public interface Prefs {
    int getInt(String region, int def);
    boolean getBoolean(String key, boolean def);
    void put(String key, String value);
    void putBoolean(String key, boolean value);
    void putInt(String key, int value);
    void flush();
    String get(String key, String def);
}
