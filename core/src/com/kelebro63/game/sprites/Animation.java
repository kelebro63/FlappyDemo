package com.kelebro63.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Bistrov Alexey on 02.09.2016.
 */
public class Animation {

    private Array<TextureRegion> frames;
    private float maxFrameTime; //длительность отображения одного кадра
    private float currentFrameTime; //время отображения текущего кадра
    private int frameCount; // колличество кадров анимации
    private int frame; //отдельный кадр анимации

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        this.frameCount = frameCount;
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
