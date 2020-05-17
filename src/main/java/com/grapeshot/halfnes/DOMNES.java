package com.grapeshot.halfnes;

import com.grapeshot.halfnes.ui.DOMUI;
import com.grapeshot.halfnes.ui.PuppetController;
import js.Console;
import js.dom.DOM;

public class DOMNES {
    public static void main(String ... args){
        PrefsSingleton.set(new DOMPrefs());
        DOMUI ui=new DOMUI();
        Console.log("dom ui initialized");
        while (true){
            DOM.getNextEvent()
            .run();
        }
    }
}
