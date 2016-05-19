package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{
    boolean blnShowText;
    int intTextPosition;

    Paint pntTextPaint;     // Painting object to handle the paint jobs for text
    Paint pntBlackPaint;    // Painting object to handle the paint jobs for graphics
    Paint pntBlackBodPaint;      // Painting object to handle the paint jobs for graphics
    Paint pntBlckRArmPaint;
    Paint pntBlckLArmPaint;
    Paint pntBlckLlegPaint;
    Paint pntBlckRlegPaint;
    Paint pntRedBoxPaint;
    Paint pntBlackBoxPaint;
    float startX, startY, stopX, stopY;
    int squareShape = 4000;

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackBodPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlckRArmPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlckLArmPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlckLlegPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlckRlegPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntRedBoxPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackBoxPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntBlackPaint.setColor(Color.BLACK);
        pntBlackPaint.setStrokeWidth(3);

        pntBlackBodPaint.setColor(Color.BLACK);
        pntBlackBodPaint.setStrokeWidth(3);

        pntBlckRArmPaint.setColor(Color.BLACK);
        pntBlckRArmPaint.setStrokeWidth(10);

        pntBlckLArmPaint.setColor(Color.BLACK);
        pntBlckLArmPaint.setStrokeWidth(10);

        pntBlckLArmPaint.setColor(Color.BLACK);
        pntBlckLArmPaint.setStrokeWidth(10);

        pntBlckRlegPaint.setColor(Color.BLACK);
        pntBlckRlegPaint.setStrokeWidth(10);

        pntBlackBoxPaint.setColor(Color.BLACK);
        pntBlackBoxPaint.setStrokeWidth(10);

        pntRedBoxPaint.setColor(Color.RED);
        pntRedBoxPaint.setStrokeWidth(10);

    }
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas) {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.

        super.onDraw(canvas);

        //Code for stickman
        // canvas.drawCircle((float) 350.0, (float) 50.0, (float) 50.0, pntBlackPaint);

        // canvas.drawRect((float) 355.0, (float) 365.0, (float) 345.0, (float) 100.0, pntBlackBodPaint);

        // canvas.drawLine((float) 500.0, (float)200.0, (float) 350.0, (float) 150.0, pntBlckRArmPaint);

        //  canvas.drawLine((float) 350.0, (float) 150.0, (float) 200.0, (float) 150.0, pntBlckLArmPaint);

        //     canvas.drawLine((float) 500.0, (float) 150.0, (float) 350.0, (float) 200.0, pntBlckRlegPaint);


        int width = canvas.getWidth();
        int height = canvas.getHeight();

        for (int i = 1; i < 50; i++) {
            startX = width / 2 - squareShape;
            startY = i * 100;
            stopX = width / 2 + squareShape;
            stopY = i * 100;
            canvas.drawRect(startX, startY, stopX, stopY, pntRedBoxPaint);
        }

        for (int i = 1; i < 50; i++) {
            startX = i * 100;
            startY = height / 2 - squareShape;
            stopX = i * 100;
            stopY = height / 2 + squareShape;
            canvas.drawRect(startX, startY, stopX, stopY, pntBlackBoxPaint);
        }

    }
}
