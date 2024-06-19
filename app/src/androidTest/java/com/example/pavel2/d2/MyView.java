package com.example.pavel2.d2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pavel2.R;
import com.example.pavel2.fragment.ButtonsFragment;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        Paint p = new Paint();
        p.setColor(Color.CYAN);
//          p.setColor(Color.rgb(0,255,0));
//          p.setColor(Color.argb(127,0,255,0));
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5);
        canvas.drawRect(50,50,250,250,p);

        p.setColor(getResources().getColor(R.color.mycolor));
        p.setStyle(Paint.Style.FILL);
        canvas.drawCircle(
              canvas.getWidth()  /2,
              canvas.getHeight()/2,
              100,
              p
            );
        canvas.save();
        canvas.rotate(45);
        p.setTextSize(100);
        canvas.drawText("IT school samsung",500,500,p);
        canvas.restore();
        Bitmap samsung = BitmapFactory.decodeResource(getResources(),R.drawable.samsung);
        int sw = samsung.getWidth();
        int sh = samsung.getHeight();
        Rect r = new Rect(0,0, sw, sh);
        int ytop = canvas.getHeight() * 2 / 3;
        Rect d = new Rect(50, ytop,550,ytop + 500 * sh/sw);
        canvas.drawBitmap(samsung, r, d,p);
    }
}
