package com.grapeshot.halfnes.ui;

import com.grapeshot.halfnes.NES;
import com.grapeshot.halfnes.video.DOMRenderer;
import com.grapeshot.halfnes.video.RGBRenderer;
import js.Console;
import js.JSEvent;
import js.JSObject;
import js.dom.DOM;
import js.dom.DOMElement;
import js.dom.JSElement;
import js.event.EventListener;
import js.io.JSFile;

public class DOMUI implements GUIInterface{
    private final NES nes;
    private final DOMRenderer renderer;
    private PuppetController controller1, controller2;

    public DOMUI(){
        nes = new NES(this);
        this.renderer = new DOMRenderer();
        this.controller1 = new PuppetController();
        this.controller2 = new PuppetController();
        nes.setControllers(this.controller1, this.controller2);
        DOMElement root=DOM.getElementById("body");
        DOMElement input=DOM.createElement("input");
        input.setString("type","file");
        root.appendChild(input);
        input.addEventListener("change", new EventListener() {
            @Override
            public void handle(JSElement jsElement, JSEvent jsEvent) {
                DOM.alert("open File");
                Console.debugger();
                JSObject[] files = jsElement.getArray("files");
                JSFile file = new JSFile(files[0]);
                nes.loadROM(file);
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
