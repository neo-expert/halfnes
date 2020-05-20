package com.neoexpert.domhalfnes;
import com.grapeshot.halfnes.video.*;


import js.dom.Canvas;
import js.dom.ImageData;

public class DOMRenderer extends Renderer{
    private final Canvas canvas;
    private final Canvas.Context2D ctx;

    public DOMRenderer(Canvas canvas){
        //frame_width=256;
        this.canvas=canvas;
        ctx=canvas.getContext2D();
    }

    @Override
    public void render(int[] nespixels, int[] bgcolors, boolean dotcrawl) {
        for (int i = 0; i < nespixels.length; ++i) {
            nespixels[i] = NesColors.col[(nespixels[i] & 0x1c0) >> 6][nespixels[i] & 0x3f];
        }
        ImageData imageData = ctx.createImageData(256, 240);
        imageData.setIntArray(nespixels);
        ctx.putImageData(0,0,imageData);
        System.out.println("nespixels length:"+nespixels.length);
    }
}
