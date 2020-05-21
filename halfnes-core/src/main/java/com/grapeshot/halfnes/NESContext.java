/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author neoexpert
 *
 */
public class NESContext {

    private static Prefs prefs = null;
    private static Logger logger;

    private NESContext() {
        // Exists only to defeat instantiation.
    }

    public static void setPrefs(Prefs prefs){
       NESContext.prefs =prefs;
    }

    public synchronized static Prefs getPrefs() {
        if(prefs ==null)
            prefs =new DefaultPrefs();
        return prefs;
    }
    public static void setLogger(Logger _logger){
        logger=_logger;
    }

    public static Logger getLogger() {
        if(logger==null)
            logger=new DefaultLogger();
        return logger;
    }

    private static class DefaultPrefs implements Prefs{
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

    public static class DefaultLogger implements Logger {
        private final OutputStreamWriter w;

        public DefaultLogger(){
            this(new File("nesdebug.txt"));
        }

        public DefaultLogger(File file) {
            try {
                w = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override
        public void log(String ... tolog) {
            try {
								for(String s:tolog)
                	w.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void flush() {
            try {
                w.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
