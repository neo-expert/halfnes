/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes.audio;

/**
 *
 * @author Andrew
 */
public interface AudioOutInterface {

    void outputSample(int sample);

    void flushFrame(boolean waitIfBufferFull);

    void pause();

    void resume();

    void destroy();

    boolean bufferHasLessThan(int samples);
}
