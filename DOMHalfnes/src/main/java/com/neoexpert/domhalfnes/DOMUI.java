package com.neoexpert.domhalfnes;
import com.grapeshot.halfnes.ui.*;

import com.grapeshot.halfnes.NES;
import com.grapeshot.halfnes.video.RGBRenderer;
import js.Console;
import js.JSEvent;
import js.JSObject;
import js.dom.Canvas;
import js.dom.DOM;
import js.dom.DOMElement;
import js.dom.JSElement;
import js.event.EventListener;
import js.io.JSFile;

public class DOMUI implements GUIInterface{
    private NES nes;
    private final DOMRenderer renderer;
    private PuppetController controller1, controller2;

    public DOMUI(){
        nes = new NES(this);
        Canvas canvas = DOM.createElement("canvas");
        canvas.setInt("width",256);
        canvas.setInt("height",240);
        this.renderer = new DOMRenderer(canvas);
        this.controller1 = new PuppetController();
        this.controller2 = new PuppetController();
        nes.setControllers(this.controller1, this.controller2);
        DOMElement root=DOM.getElementById("body");
        root.appendChild(canvas);
        DOMElement input=DOM.createElement("input");
        input.setString("type","file");
        root.appendChild(input);
        input.addEventListener("change", new EventListener() {
            @Override
            public void handle(JSElement jsElement, JSEvent jsEvent) {
                DOM.alert("open File");
                JSObject[] files = jsElement.getArray("files");
                JSFile file = new JSFile(files[0]);
                nes.loadROM(file,0xC000);
                //test();
                start();
            }
        });

    }

    private void test() {
        //nes.loadROM("src/test/resources/nestest/nestest.nes", 0xC000);
        //nes.setControllers(mock(ControllerInterface.class), mock(ControllerInterface.class));

        //log all instructions executed to compare with real nestest.log
        nes.getCPU().startLog();
        while (nes.runEmulation) {
            //runs until hits a KIL opcode which is a few instructions after the
            //official log finishes.
            nes.frameAdvance();
        }
        //log should be at least 8992 lines
        //I don't actually compare the logs in this test yet.

        //check some bytes of RAM for successful test result values
        System.err.println(nes.getCPURAM().read(0));
        System.err.println(nes.getCPURAM().read(1));
        System.err.println(nes.getCPURAM().read(2));
        System.err.println(nes.getCPURAM().read(3));

        assertEquals(nes.getCPURAM().read(0), 0);
        assertEquals(nes.getCPURAM().read(1), 255);
        assertEquals(nes.getCPURAM().read(2), 255);
        assertEquals(nes.getCPURAM().read(3), 255);
    }

    private void assertEquals(int v1, int v2) {
        if(v1!=v2)
            Console.error("assert failed");
    }

    private void start() {
        for (int i = 0; i < 100; i++) {
            Console.log("runFrame: "+i);
            runFrame();
        }
        Console.log("start: ");
        getController1().pressButton(PuppetController.Button.START);
        runFrame();
        Console.log("stop: ");
        getController1().releaseButton(PuppetController.Button.START);
        for (int i = 0; i < 5; i++) {
            runFrame();
        }
        Console.log("done: ");
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
        this.nes=nes;
    }

    @Override
    public void setFrame(int[] frame, int[] bgcolor, boolean dotcrawl) {
        renderer.render(frame,bgcolor,dotcrawl);
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

    Runnable runFrame=new Runnable() {
        @Override
        public void run() {
            nes.frameAdvance();
        }
    };
    public void runFrame() {
        DOM.requestAnimationFrame(runFrame);
    }
}
