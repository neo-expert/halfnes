package com.neoexpert.domhalfnes;

import com.grapeshot.halfnes.Logger;
import js.Console;

public class DOMLogger implements Logger {
    @Override
    public void log(String tolog) {
        Console.log(tolog);
    }

    @Override
    public void flush() {

    }
}
