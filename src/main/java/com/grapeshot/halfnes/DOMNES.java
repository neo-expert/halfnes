package com.grapeshot.halfnes;

import com.grapeshot.halfnes.ui.DOMUI;
import com.grapeshot.halfnes.ui.PuppetController;

public class DOMNES {
    public static void main(String ... args){
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
    }
}
