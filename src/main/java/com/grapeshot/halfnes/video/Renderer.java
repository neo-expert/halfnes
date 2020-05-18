/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes.video;

import java.awt.image.BufferedImage;

/**
 *
 * @author Andrew
 */
public abstract class Renderer {

    int frame_width;
    /*
    there's stuff involving this variable that's much uglier
    than it needs to be because of me not really remembering
    how abstract classes work
     */
    int clip = 8;
    int height = 240 - 2 * clip;

    public abstract void render(int[] nespixels, int[] bgcolors, boolean dotcrawl);

    public void setClip(int i) {
        //how many lines to clip from top + bottom
        clip = i;
        height = 240 - 2 * clip;
    }


}
