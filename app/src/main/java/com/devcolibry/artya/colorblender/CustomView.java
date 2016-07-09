package com.devcolibry.artya.colorblender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class CustomView extends View {

    private Rect rectangle;
    private Paint paint;



    public static int _redBlended;
    public static int _greenBlended;
    public static int _blueBlended;


    /*
    public void setRedBlended (int redBlended){
        this.redBlended = redBlended;
    }
    public void setGreenBlended(int greenBlended){
        this.greenBlended = greenBlended;
    }
    public void setBlueBlended(int blueBlended){
        this.blueBlended = blueBlended;
    }
*/
    public CustomView(Context context) {
        super(context);
        int x = 50;
        int y = 50;
        int sideLength = 200;

        // create a rectangle that we'll draw later
        rectangle = new Rect(x, y, sideLength, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.rgb(_redBlended, _greenBlended, _blueBlended));//default color is GRAY
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        canvas.drawRect(rectangle, paint);
    }
}