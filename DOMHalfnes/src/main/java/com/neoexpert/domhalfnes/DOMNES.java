package com.neoexpert.domhalfnes;
import com.grapeshot.halfnes.*;

import com.grapeshot.halfnes.ui.PuppetController;
import js.Console;
import js.dom.DOM;

public class DOMNES {
    public static void main(String ... args){
			if(!DOM.isInitialized()){
				System.out.println("ERROR: DOM is not initialized");
				return;
			}

			APU.setDedaultAudioInterface(new DOMAudio());
        PrefsSingleton.set(new DOMPrefs());
        DOMUI ui=new DOMUI();
        Console.log("dom ui initialized");
        while (true){
            DOM.getNextEvent()
            .run();
        }
    }
}
