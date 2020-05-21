package com.neoexpert.domhalfnes;

import com.grapeshot.halfnes.Logger;
import js.Console;

public class DOMLogger implements Logger {
    @Override
    public void log(String ... tolog) {
			StringBuilder sb=new StringBuilder();
			for(String s:tolog)
				sb.append(s);
        Console.log(sb.toString());
    }

    @Override
    public void flush() {

    }
}
