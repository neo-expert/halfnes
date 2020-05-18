/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes;

import java.util.prefs.Preferences;

/**
 *
 * @author Andrew
 */
public class PrefsSingleton {

    private static Prefs instance = null;

    private PrefsSingleton() {
        // Exists only to defeat instantiation.
    }

    public static void set(Prefs prefs){
       instance=prefs;
    }

    public synchronized static Prefs get() {
        if(instance==null)
            instance=new DOMPrefs();
        return instance;
    }
}
