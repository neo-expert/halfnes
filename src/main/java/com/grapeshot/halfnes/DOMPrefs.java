package com.grapeshot.halfnes;

public class DOMPrefs implements Prefs{
    @Override
    public int getInt(String region, int def) {
        return def;
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        return def;
    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public void putBoolean(String key, boolean value) {

    }

    @Override
    public void putInt(String key, int value) {

    }

    @Override
    public void flush() {

    }

    @Override
    public String get(String key, String def) {
        return def;
    }
}
