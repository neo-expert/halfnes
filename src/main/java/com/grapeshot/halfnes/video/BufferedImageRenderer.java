package com.grapeshot.halfnes.video;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;

public abstract class BufferedImageRenderer extends Renderer {
    public abstract BufferedImage getImage();
    int imgctr = 0;
    BufferedImage[] imgs = {null, null, null, null};
    protected final void init_images() {
        for (int i = 0; i < imgs.length; ++i) {
            imgs[i] = new BufferedImage(frame_width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        }
    }
    protected BufferedImage getBufferedImage(int[] frame) {
        final BufferedImage image = imgs[++imgctr % imgs.length];
        final WritableRaster raster = image.getRaster();
        final int[] pixels = ((DataBufferInt) raster.getDataBuffer()).getData();
        System.arraycopy(frame, frame_width * clip, pixels, 0, frame_width * height);
        return image;
    }
}

