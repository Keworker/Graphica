package com.samsung.graphica;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class MyPaint extends View {

    int wight, height;
    Paint paint;
    Bitmap bitmapTree, bitmapToy;
    Rect rect;
    Toy button;

    public MyPaint(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        wight = w;
        height = h;
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.violet));
        //bitmap1.getWidth(); //Размеры картинки
        //canvas.drawCircle(wight/2, height/2, 100, paint); //Рисуем круг в центре с радиусом 100 dp
        bitmapTree = BitmapFactory.decodeResource(getResources(), R.drawable.elka);
        rect = new Rect(0, 0, wight, height);
        bitmapToy = BitmapFactory.decodeResource(getResources(), R.drawable.igrushka);
        bitmapToy = Bitmap.createScaledBitmap(bitmapToy, 100, 100, true);
        button = new Toy(100, height - 100, bitmapToy, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmapTree, rect, rect, paint);
        button.onDraw(canvas);
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                if (button.bound(event.getX(), event.getY())) {

                }
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                break;
            }
            case MotionEvent.ACTION_UP:{

            }
        }
        return super.onTouchEvent(event);
    }
}
