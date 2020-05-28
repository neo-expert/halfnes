/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes.video;

import com.grapeshot.halfnes.video.NesColors;
import com.grapeshot.halfnes.video.Renderer;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andrew
 */
public class RGBRenderer extends BufferedImageRenderer {

    private BufferedImage img;

    public RGBRenderer() {
        frame_width = 256;
        init_images();
    }

    @Override
    public void render(int[] nespixels, int[] bgcolors, boolean dotcrawl) {
        //and now replace the nes color numbers with rgb colors (respecting color emph bits)
        for (int i = 0; i < nespixels.length; ++i) {
            nespixels[i] = NesColors.col[(nespixels[i] & 0x1c0) >> 6][nespixels[i] & 0x3f];
        }
        img = getBufferedImage(nespixels);
    }

    @Override
    public BufferedImage getImage() {
        return img;
    }
}
