// Class which allows the user to draw on screen with their finger

package com.learning2write;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class LowerS extends View{

	// Various variable definitions
    int lineColour = Color.BLACK; // Signature colour
    int sColour = Color.GREEN; // Signature colour
    int eColour = Color.RED; // Signature colour
    int lColour = Color.GRAY; // Signature colour
    int glColour = Color.LTGRAY; // Signature colour
    boolean mCapturing = true; // Boolean determining if the line is writing or not
    Bitmap mSignature, bmap; // Empty bitmaps
    float lineWidth = 8f; // Width of the line drawn
    float pWidth = 12f; // Width of the line drawn
    float glWidth = 4f; // Width of the line drawn   
    static final boolean GESTURE_RENDERING_ANTIALIAS = true; // Boolean for AntiAlias
    static final boolean DITHER_FLAG = true; // Boolean for the dither
    Paint mPaint = new Paint(); // Creates a new paint object
    Paint sPaint = new Paint(); // Creates a new paint object
    Paint ePaint = new Paint(); // Creates a new paint object
    Paint lPaint = new Paint(); // Creates a new paint object
    Paint glPaint = new Paint(); // Creates a new paint object
    Path mPath = new Path(); // Creates a new path object
    final Rect mInvalidRect = new Rect(); //creates an empy Rect();
    // Floats for appropriate x and y coordinates
    float mX;
    float mY;
    float mCurveEndX;
    float mCurveEndY;
    int mInvalidateExtraBorder = 10;
    Canvas canvas;
    
    // Constructors
    public LowerS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public LowerS(Context context) {
        super(context);
        init();
    }

    public LowerS(Context context, AttributeSet attrs) {
        super(context, attrs);  

        init();
    }

    // Method to initialize the variables
    private void init() {
        setWillNotDraw(false);

        mPaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        mPaint.setColor(lineColour); // Sets the colour
        mPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        mPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        mPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        mPaint.setStrokeWidth(lineWidth); // Width of the line
        mPaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        mPath.reset();
        sPaint.setColor(sColour); // Sets the colour
        sPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        sPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        sPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        sPaint.setStrokeWidth(pWidth); // Width of the line
        ePaint.setColor(eColour); // Sets the colour
        ePaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        ePaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        ePaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        ePaint.setStrokeWidth(pWidth); // Width of the line
        lPaint.setColor(lColour); // Sets the colour
        lPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        lPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        lPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        lPaint.setStrokeWidth(lineWidth); // Width of the line
        glPaint.setColor(glColour); // Sets the colour
        glPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        glPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        glPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        glPaint.setStrokeWidth(glWidth); // Width of the line
        //bmap = BitmapFactory.decodeResource(getResources(), R.drawable.upper_a); // Create a bitmap with an image of a lower case a

    }

    // Override the onDraw method
    // Draws the bitmap with the image a on it. Also draws the line following the user's finger
    @Override
    protected void onDraw(Canvas canvas) {
    	//canvas.drawBitmap(bmap, ((canvas.getWidth() - bmap.getWidth())/2), ((canvas.getHeight() - bmap.getHeight())/2), null);
        float x = canvas.getWidth()/2f;
        float y = canvas.getHeight()/1.5f;
        
        canvas.drawLine(0, y-590, canvas.getWidth(), y-590, glPaint);        
        //canvas.drawLine(0, y-505, canvas.getWidth(), y-505, glPaint);
        //canvas.drawLine(0, y-335, canvas.getWidth(), y-335, glPaint);
        canvas.drawLine(0, y-250, canvas.getWidth(), y-250, glPaint);
        
        canvas.drawLine(0, y-105, canvas.getWidth(), y-105, glPaint);
        canvas.drawLine(0, y+237, canvas.getWidth(), y+237, glPaint);
        
        for(int i = 0; i < canvas.getWidth(); i=i+10){
        	
        	canvas.drawLine(i, y-418, i+5, y-418, glPaint);
        	canvas.drawLine(i, y-460, i+5, y-460, glPaint);
        	canvas.drawLine(i, y+23, i+5, y+23, glPaint);
        	canvas.drawLine(i, y+65, i+5, y+65, glPaint);
        	
        }
  	
    	canvas.drawPoint(x-140, y-399, sPaint);    	
    	canvas.drawPoint(x-157, y-411, lPaint);    	
    	canvas.drawPoint(x-176, y-418, lPaint);    	
    	canvas.drawPoint(x-192, y-413, lPaint);    	
    	canvas.drawPoint(x-206, y-406, lPaint);    	
    	canvas.drawPoint(x-218, y-395, lPaint); 
    	canvas.drawPoint(x-225, y-380, lPaint);    	
    	canvas.drawPoint(x-225, y-363, lPaint);    	
    	canvas.drawPoint(x-214, y-350, lPaint);    	
    	canvas.drawPoint(x-200, y-340, lPaint);    	
    	canvas.drawPoint(x-186, y-330, lPaint);    	
    	canvas.drawPoint(x-171, y-320, lPaint);      	
    	canvas.drawPoint(x-157, y-311, lPaint);    	
    	canvas.drawPoint(x-147, y-296, lPaint);    	
    	canvas.drawPoint(x-147, y-277, lPaint);    	
    	canvas.drawPoint(x-158, y-262, lPaint);    	
    	canvas.drawPoint(x-173, y-253, lPaint);   	
    	canvas.drawPoint(x-187, y-248, lPaint);    	
    	canvas.drawPoint(x-201, y-253, lPaint);    	
    	canvas.drawPoint(x-215, y-261, lPaint);    	
    	canvas.drawPoint(x-229, y-271, ePaint);
    	
    	
    	canvas.drawPoint(x-140, y+84, sPaint);    	
    	canvas.drawPoint(x-176, y+65, lPaint);    	
    	canvas.drawPoint(x-206, y+77, lPaint);    	
    	canvas.drawPoint(x-225, y+103, lPaint);    	
    	canvas.drawPoint(x-214, y+133, lPaint);    	
    	canvas.drawPoint(x-186, y+153, lPaint);    	
    	canvas.drawPoint(x-157, y+172, lPaint);    	
    	canvas.drawPoint(x-147, y+206, lPaint);    	
    	canvas.drawPoint(x-173, y+230, lPaint);   	
    	canvas.drawPoint(x-201, y+230, lPaint);    	
    	canvas.drawPoint(x-229, y+212, ePaint);
    	
    	canvas.drawPoint(x+260, y+84, sPaint);    		
    	canvas.drawPoint(x+224, y+65, lPaint);    	  	
    	canvas.drawPoint(x+175, y+103, lPaint);    	    	
    	canvas.drawPoint(x+214, y+153, lPaint);    	  	
    	canvas.drawPoint(x+253, y+187, lPaint);
    	//canvas.drawPoint(x+253, y+36, lPaint);
    	canvas.drawPoint(x+227, y+230, lPaint);    	
    	canvas.drawPoint(x+171, y+212, ePaint);
    	
    	canvas.drawPoint(x+260, y-399, sPaint);    	
    	canvas.drawPoint(x+243, y-411, lPaint);    	
    	canvas.drawPoint(x+224, y-418, lPaint);    	
    	canvas.drawPoint(x+208, y-413, lPaint);    	
    	canvas.drawPoint(x+194, y-406, lPaint);    	
    	canvas.drawPoint(x+182, y-395, lPaint); 
    	canvas.drawPoint(x+175, y-380, lPaint);    	
    	canvas.drawPoint(x+175, y-363, lPaint);    	
    	canvas.drawPoint(x+186, y-350, lPaint);    	
    	canvas.drawPoint(x+200, y-340, lPaint);    	
    	canvas.drawPoint(x+214, y-330, lPaint);    	
    	canvas.drawPoint(x+229, y-320, lPaint);      	
    	canvas.drawPoint(x+243, y-311, lPaint);    	
    	canvas.drawPoint(x+253, y-296, lPaint);    	
    	canvas.drawPoint(x+253, y-277, lPaint);    	
    	canvas.drawPoint(x+242, y-262, lPaint);    	
    	canvas.drawPoint(x+227, y-253, lPaint);   	
    	canvas.drawPoint(x+213, y-248, lPaint);    	
    	canvas.drawPoint(x+199, y-253, lPaint);    	
    	canvas.drawPoint(x+185, y-261, lPaint);    	
    	canvas.drawPoint(x+171, y-271, ePaint);


    	
        if (mSignature != null) {
            canvas.drawBitmap(mSignature, null, new Rect(0, 0, getWidth(),getHeight()), null);
        } else {
            canvas.drawPath(mPath, mPaint);
        }

    }

    @Override
    // Pass the touch screen motion event down to the target view, or this view if it is the target
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mCapturing) {
            processEvent(event);
            Log.d(VIEW_LOG_TAG, "dispatchTouchEvent");
            return true;
        } else {
            return false;
        }
    }

    // Method to process events. Determines 
    private boolean processEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN: // A pressed gesture has started, the motion contains the initial starting location
            touchDown(event);
            invalidate(); // Invalidate the whole view. If the view is visible, onDraw will be called at some point in the future
            return true;
        case MotionEvent.ACTION_MOVE: // A change has happened during a press gesture (between ACTION_DOWN and ACTION_UP)

            Rect rect = touchMove(event);
            if (rect != null) {
                invalidate(rect);
            }
            return true;

        case MotionEvent.ACTION_UP: // A pressed gesture has finished, the motion contains the final release location as well as any intermediate points since the last down or move event

            touchUp(event, false);
            invalidate();
            return true;

        case MotionEvent.ACTION_CANCEL: // The current gesture has been aborted

            touchUp(event, true);
            invalidate();
            return true;

        }

        return false;

    }

    // A method dealing with when a user takes their finger off the screen
    private void touchUp(MotionEvent event, boolean b) {
        // TODO Auto-generated method stub

    }

    // Method gets the x and y co-ordinates of the current and previous touch.
    private Rect touchMove(MotionEvent event) {
        Rect areaToRefresh = null;

        // Set the coordinates
        final float x = event.getX();
        final float y = event.getY();

        final float previousX = mX;
        final float previousY = mY;

        areaToRefresh = mInvalidRect;

        // Start with the curve end
        final int border = mInvalidateExtraBorder;
        areaToRefresh.set((int) mCurveEndX - border, (int) mCurveEndY - border,
                (int) mCurveEndX + border, (int) mCurveEndY + border);

        float cX = mCurveEndX = (x + previousX) / 2;
        float cY = mCurveEndY = (y + previousY) / 2;

        mPath.quadTo(previousX, previousY, cX, cY);

        // Union with the control point of the new curve
        areaToRefresh.union((int) previousX - border, (int) previousY - border,
                (int) previousX + border, (int) previousY + border);

        // Union with the end point of the new curve
        areaToRefresh.union((int) cX - border, (int) cY - border, (int) cX
                + border, (int) cY + border);

        mX = x;
        mY = y;

        return areaToRefresh;

    }

    // Method to handle when the user has touched down on the screen
    private void touchDown(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        mX = x;
        mY = y;
        mPath.moveTo(x, y); // Set the beginning of the next contour to the point (x,y)

        final int border = mInvalidateExtraBorder;
        // Set the rectangle's coordinates to the specified values
        mInvalidRect.set((int) x - border, (int) y - border, (int) x + border,
                (int) y + border);

        mCurveEndX = x;
        mCurveEndY = y;

    }
    public void clearScreen(Canvas canvas){
    	canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }
}