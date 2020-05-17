package com.grapeshot.halfnes.ui;

import com.grapeshot.halfnes.NES;
import js.dom.DOMElement;

public class DOMUI implements GUIInterface{
    public DOMUI(){
        DOMElement dom;
    }
    @Override
    public NES getNes() {
        return null;
    }

    @Override
    public void setNES(NES nes) {

    }

    @Override
    public void setFrame(int[] frame, int[] bgcolor, boolean dotcrawl) {

    }

    @Override
    public void messageBox(String message) {

    }

    @Override
    public void run() {

    }

    @Override
    public void render() {

    }

    @Override
    public void loadROMs(String path) {

    }
}
