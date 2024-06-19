package com.example.pavel2.d2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

public class Sprite {
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private int frameWidth;
    private int frameHeight;
    private int frame = 0;
    private double frameTime;
    private double timeForCurrentFrame;
    private int padding;
    private List<Rect> frames;
    Bitmap bitmap;

    public Sprite(double x, double y, double velocityX, double velocityY, Rect initFrame,Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.bitmap = bitmap;
        this.frames = new ArrayList<Rect>();
        this.frames.add (initFrame);
        this.frameHeight = initFrame.height();
        this.frameWidth = initFrame.width();
        this.padding = 20;
        this.frameTime = 0.1;
        this.timeForCurrentFrame = 0.0;
    }
    public void addFrame(Rect frame) {
        frames.add(frame);
    }

    public void update (long ms) {
        System.out.println(ms);
        timeForCurrentFrame += ms;
        if (timeForCurrentFrame >= frameTime) {
            frame = (frame + 1) % frames.size();
            timeForCurrentFrame = timeForCurrentFrame - frameTime;
        }
        x = x + velocityX * ms/(1. * GameView.INTERVAL);
        y = y + velocityY * ms/(1. * GameView.INTERVAL);
    }

    public void draw (Canvas canvas) {
        Paint p = new Paint();
        Rect destination = new Rect((int)x, (int)y, (int)(x + frameWidth), (int)(y + frameHeight));
        canvas.drawBitmap(bitmap, frames.get(frame), destination,  p);
    }

    public Rect getBoundingBoxRect () {
        return new Rect((int)x+padding, (int)y+padding, (int)(x + frameWidth - 2 * padding), (int)(y + frameHeight - 2 * padding));
    }

    public boolean intersect(Sprite enemy) {
        return this.getBoundingBoxRect().intersect(enemy.getBoundingBoxRect());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getFrameWidth() {
        return frameWidth;
    }
    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }
    public int getFrameHeight() {
        return frameHeight;
    }
    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }
    public double getVx() {
        return velocityX;
    }
    public void setVx(double velocityX) {
        this.velocityX = velocityX;
    }
    public double getVy() {
        return velocityY;
    }
    public void setVy(double velocityY) {
        this.velocityY = velocityY;
    }
    public int getCurrentFrame() {
        return frame;
    }
    public void setCurrentFrame(int currentFrame) {
        this.frame = currentFrame%frames.size();
    }
    public double getFrameTime() {
        return frameTime;
    }
    public void setFrameTime(double frameTime) {
        this.frameTime = Math.abs(frameTime);
    }
    public double getTimeForCurrentFrame() {
        return timeForCurrentFrame;
    }
    public void setTimeForCurrentFrame(double timeForCurrentFrame) {
        this.timeForCurrentFrame = Math.abs(timeForCurrentFrame);
    }
    public int getFramesCount () {
        return frames.size();
    }

    public void teleport(int maxX, int  maxH) {
        this.setX(maxX+ 100);
        this.setY(maxH * Math.random());
    }

}