package com.example.pavel2.module4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CircleView extends View {

    public CircleView(Context context) {
        super(context);
    }
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.GREEN);
        p.setStyle(Paint.Style.STROKE);
        int x = canvas.getWidth();
        int y = canvas.getHeight() / 6;
        int r = canvas.getWidth() / 4;
        canvas.save();
        canvas.rotate(45);
        drawRecursion(canvas, x, y, r, p);
        canvas.restore();
    }
    public  void drawRecursion(Canvas canvas, int x, int y, int r, Paint p) {

        if (r > 10) {
            drawRecursion(canvas, x + r, y, r / 2, p);
            drawRecursion(canvas, x - r, y, r / 2, p);
            drawRecursion(canvas, x, y + r, r / 2, p);
            drawRecursion(canvas, x, y - r, r / 2, p);

            canvas.drawCircle(x, y, r, p);
        }
    }
}
