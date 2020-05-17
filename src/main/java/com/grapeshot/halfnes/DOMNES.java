package com.grapeshot.halfnes;

import com.grapeshot.halfnes.ui.DOMUI;
import com.grapeshot.halfnes.ui.PuppetController;
import js.Console;
import js.dom.DOM;

public class DOMNES {
    public static void main(String ... args){
        PrefsSingleton.set(new DOMPrefs());
        DOMUI ui=new DOMUI();
        for (int i = 0; i < 100; i++) {
            ui.runFrame();
        }
        ui.getController1().pressButton(PuppetController.Button.START);
        ui.runFrame();
        ui.getController1().releaseButton(PuppetController.Button.START);
        for (int i = 0; i < 5; i++) {
            ui.runFrame();
        }
        Console.log("dom ui initialized");
        while (true){
            DOM.getNextEvent()
            .run();
        }
    }
}
