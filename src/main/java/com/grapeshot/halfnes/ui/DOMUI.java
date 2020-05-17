package com.grapeshot.halfnes.ui;

import com.grapeshot.halfnes.NES;
import js.JSEvent;
import js.dom.DOM;
import js.dom.DOMElement;
import js.dom.JSElement;
import js.event.EventListener;

public class DOMUI implements GUIInterface{
    private final NES nes;
    private PuppetController controller1, controller2;

    public DOMUI(){
        nes = new NES(this);
        nes.loadROM("battletoads.nes");
        DOMElement root=DOM.getElementById("root");
        DOMElement button=DOM.createElement("button");
        button.setContent("load rom ...");
        root.appendChild(button);
        button.addEventListener("click", new EventListener() {
            @Override
            public void handle(JSElement jsElement, JSEvent jsEvent) {
                DOM.alert("open File");
            }
        });

    }
    public PuppetController getController1() {
        return controller1;
    }
    @Override
    public NES getNes() {
        return nes;
    }

    @Override
    public void setNES(NES nes) {

    }

    @Override
    public void setFrame(int[] frame, int[] bgcolor, boolean dotcrawl) {

    }

    @Override
    public void messageBox(String message) {
        DOM.alert(message);
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

    public void runFrame() {
        nes.frameAdvance();
    }
}
