package com.grapeshot.halfnes;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class DefaultPrefs implements Prefs{
    private final Preferences prefs;

    public DefaultPrefs() {
        this.prefs = Preferences.userNodeForPackage(NES.class);
    }

    @Override
    public int getInt(String key, int def) {
        return prefs.getInt(key, def);
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        return prefs.getBoolean(key, def);
    }

    @Override
    public void put(String key, String value) {
        prefs.put(key,value);
    }

    @Override
    public void putBoolean(String key, boolean value) {
        prefs.putBoolean(key, value);
    }

    @Override
    public void putInt(String key, int value) {
        prefs.putInt(key, value);
    }

    @Override
    public void flush() {
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(String key, String def) {
        return prefs.get(key, def);
    }
}
