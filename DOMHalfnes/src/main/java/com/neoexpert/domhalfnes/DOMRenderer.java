package com.neoexpert.domhalfnes;
import com.grapeshot.halfnes.video.*;


import js.Console;

public class DOMRenderer extends Renderer{
    public DOMRenderer(){
        //frame_width=256;
    }

    @Override
    public void render(int[] nespixels, int[] bgcolors, boolean dotcrawl) {
        for (int i = 0; i < nespixels.length; ++i) {
            nespixels[i] = NesColors.col[(nespixels[i] & 0x1c0) >> 6][nespixels[i] & 0x3f];
        }
        System.out.println("nespixels length:"+nespixels.length);
    }
}
