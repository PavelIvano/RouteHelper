package com.example.pavel2.d2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.health.ServiceHealthStats;
import android.view.SurfaceHolder;
import com.example.pavel2.R;

public class SmileDrawThread  extends Thread{

    private Context context;
    private SurfaceHolder holder;
    private boolean running;

    int speed = 5;
    int smileX = 0;
    int smileY = 0;

    int x = -1;
    int y = -1;

    public SmileDrawThread(Context context, SurfaceHolder holder) {
        this.holder = holder;
        this.context = context;
    }
    public void run(){
        running = true;
        while(running) {
            Canvas canvas = this.holder.lockCanvas();
            if (canvas == null) continue;
            try {
                canvas.drawColor(Color.BLUE);
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.smile);
                if (smileX == 0 && smileY ==0){
                    smileX = canvas.getWidth() / 2;
                    smileY = canvas.getHeight() / 2;
                }
                if (x != -1 && y != -1) {
                    int diffX = x - smileX;
                    int diffY = y - smileY;
                    smileX += diffX > 0 ? speed : (speed*-1);
                    smileY += diffY > 0 ? speed : (speed*-1);
                }
                canvas.drawBitmap(bitmap, smileX, smileY, new Paint());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
