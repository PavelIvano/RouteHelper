package com.example.pavel2.d2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import com.example.pavel2.R;

public class GameView extends View {
    private int viewWidth = 0;
    private int viewHeight = 0;
    private int points = 0;
    private  Paint paint = new Paint();
    private Sprite player;
    private Sprite enemy;
    public final static int INTERVAL = 50;

    public GameView(Context context) {
        super(context);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);
        int w = bitmap.getWidth()/5;
        int h = bitmap.getHeight()/3;
        Rect frame = new Rect(0,0,w,h);
        player = new Sprite(0, 0, 0, 40, frame,bitmap);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 4 && j == 2) {
                    continue;
                }
                Rect rect = new Rect( i * w, j * h, i * w + w, j * h + h);
                player.addFrame(rect);
            }

        }
        Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy);
        int w2 = bitmap.getWidth()/5;
        int h2 = bitmap.getHeight()/3;
        Rect frame2 = new Rect(0,0,w2,h2);
        enemy = new Sprite(4000, 0, -30, 0, frame2,bitmap2);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 2) {
                    continue;
                }
                Rect rect = new Rect( i * w2, j * h2, i * w2 + w2, j * h2 + h2);
                enemy.addFrame(rect);
            }

        }
        Timer t = new Timer();
        t.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText(points + "",viewWidth - 100, 100, paint);

        player.draw(canvas);
        enemy.draw(canvas);
    }

    public void update(long ms2) {
        player.update(ms2);
        enemy.update(ms2);

        if (player.intersect(enemy)) {
            points -= 50;
            enemy.teleport(viewWidth, viewHeight);
        }
        if(enemy.getX() < -1 * enemy.getFrameWidth()) {
            enemy.teleport(viewWidth, viewHeight);
        }
        if (player.getY() < 0 || player.getY() > viewHeight - player.getFrameHeight()) {
            player.setVy(player.getVy() * -1);
        }
        this.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        player.setVy( -1 * player.getVy());
        points += 3333333;
        return super.onTouchEvent(event);
    }

    class Timer extends CountDownTimer {
        public long lastTime = Integer.MAX_VALUE;
        public Timer() {
            super(Integer.MAX_VALUE, INTERVAL);
        }
        public void onTick(long ms) {
            long diff = lastTime - ms;
            System.out.println(diff);
            update(diff);
            lastTime = ms;
        }
        public void onFinish() {

        }
    }
}
