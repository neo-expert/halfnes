package com.neoexpert.domhalfnes;
import com.grapeshot.halfnes.audio.AudioOutInterface;

public class DOMAudio implements AudioOutInterface{
    @Override
    public void outputSample(int sample) {

    }

    @Override
    public void flushFrame(boolean waitIfBufferFull) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean bufferHasLessThan(int samples) {
        return false;
    }
}
