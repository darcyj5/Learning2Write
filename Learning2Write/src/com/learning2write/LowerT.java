package com.learning2write;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

// Class which allows the user to draw on screen with their finger
public class LowerT extends View implements LetterViewInterface  {
    	
    private Canvas mCanvas;
    int lineColour = Color.BLACK; // Signature colour
    int sColour = Color.GREEN; // Signature colour
    int eColour = Color.RED; // Signature colour
    int lColour = Color.GRAY; // Signature colour
    int glColour = Color.LTGRAY; // Signature colour
    boolean mCapturing = true; // Boolean determining if the line is writing or not
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
    Paint rectPaint = new Paint();
    Path mPath = new Path(); // Creates a new path object
    static ArrayList<Path> paths;
    static ArrayList<Path> undonePaths;
    float xCoor;
    float yCoor;
    float x;
    float y;
    Point letP,letP1,letP2,letP3,letP4,letP5,letP6,letP7,letP8,letP9,letP10,letP11;
    int vertCount = 0;
    
    Region r, r1, r2;
    
    int pointInCount = 0;
    int pointOutCount = 0;
    boolean isLetter = false;
    
    public LowerT(Context context) 
    {
        super(context);
        init();

    }
    
    public LowerT(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();    
    }

    public LowerT(Context context, AttributeSet attrs) {
        super(context, attrs);  
        init();
    }

    private void init() {
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);      
        //this.setOnTouchListener(this);
        mPaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        mPaint.setColor(lineColour); // Sets the colour
        mPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        mPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        mPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        mPaint.setStrokeWidth(lineWidth); // Width of the line
        mPaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        mPath.reset();
        sPaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        sPaint.setColor(sColour); // Sets the colour
        sPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        sPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        sPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        sPaint.setStrokeWidth(pWidth); // Width of the line
        sPaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        ePaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        ePaint.setColor(eColour); // Sets the colour
        ePaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        ePaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        ePaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        ePaint.setStrokeWidth(pWidth); // Width of the line
        ePaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        lPaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        lPaint.setColor(lColour); // Sets the colour
        lPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        lPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        lPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        lPaint.setStrokeWidth(lineWidth); // Width of the line
        lPaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        glPaint.setAntiAlias(GESTURE_RENDERING_ANTIALIAS);
        glPaint.setColor(glColour); // Sets the colour
        glPaint.setStyle(Paint.Style.STROKE); // AntiAliasing smooths out the edges of what is being drawn, but is has no impact on the interior of the shape
        glPaint.setStrokeJoin(Paint.Join.ROUND); // Sets the paint's join
        glPaint.setStrokeCap(Paint.Cap.ROUND); // Sets the paint's cap
        glPaint.setStrokeWidth(glWidth); // Width of the line
        glPaint.setDither(DITHER_FLAG); // Dithering affects how colors that are higher precision than the device are down-sampled
        
        mCanvas = new Canvas();
        paths = new ArrayList<Path>();
        undonePaths = new ArrayList<Path>();
        
        rectPaint.setARGB(200, 255, 255, 255);
        //rectPaint.setColor(glColour);

    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    	
        x = canvas.getWidth()/2;
        y = canvas.getHeight()/1.5f;
        
        canvas.drawLine(0, y-590, canvas.getWidth(), y-590, glPaint);        
        canvas.drawLine(0, y-250, canvas.getWidth(), y-250, glPaint);
        
        canvas.drawLine(0, y-105, canvas.getWidth(), y-105, glPaint);
        canvas.drawLine(0, y+237, canvas.getWidth(), y+237, glPaint);
        
        for(int i = 0; i < canvas.getWidth(); i=i+10){
        	
        	canvas.drawLine(i, y-418, i+5, y-418, glPaint);
        	canvas.drawLine(i, y-460, i+5, y-460, glPaint);
        	canvas.drawLine(i, y+23, i+5, y+23, glPaint);
        	canvas.drawLine(i, y+65, i+5, y+65, glPaint);
        	
        }
    	    	
    	canvas.drawPoint(x-175, y-590, sPaint);
    	canvas.drawPoint(x-175, y-550, lPaint);
    	canvas.drawPoint(x-175, y-510, lPaint);
    	canvas.drawPoint(x-175, y-460, lPaint);
    	canvas.drawPoint(x-175, y-419, lPaint);
    	canvas.drawPoint(x-175, y-390, lPaint);
    	canvas.drawPoint(x-175, y-350, lPaint);
    	canvas.drawPoint(x-175, y-310, lPaint);
    	canvas.drawPoint(x-165, y-273, lPaint);
    	canvas.drawPoint(x-145, y-256, lPaint);
    	canvas.drawPoint(x-120, y-250, lPaint);
    	canvas.drawPoint(x-105, y-265, ePaint);
    	
    	canvas.drawPoint(x-225, y-460, sPaint);
    	canvas.drawPoint(x-200, y-460, lPaint);
    	canvas.drawPoint(x-150, y-460, lPaint);
    	canvas.drawPoint(x-125, y-460, ePaint);
    	
    	canvas.drawPoint(x+225, y-590, sPaint);
    	canvas.drawPoint(x+225, y-550, lPaint);
    	canvas.drawPoint(x+225, y-510, lPaint);
    	canvas.drawPoint(x+225, y-460, lPaint);
    	canvas.drawPoint(x+225, y-419, lPaint);    	
    	canvas.drawPoint(x+225, y-390, lPaint);
    	canvas.drawPoint(x+225, y-350, lPaint);
    	canvas.drawPoint(x+225, y-310, lPaint);
    	canvas.drawPoint(x+235, y-273, lPaint);
    	canvas.drawPoint(x+255, y-256, lPaint);
    	canvas.drawPoint(x+280, y-250, lPaint);
    	canvas.drawPoint(x+295, y-265, ePaint);
    	
    	canvas.drawPoint(x+175, y-460, sPaint);
    	canvas.drawPoint(x+200, y-460, lPaint);
    	canvas.drawPoint(x+250, y-460, lPaint);
    	canvas.drawPoint(x+275, y-460, ePaint);
    	
    	canvas.drawPoint(x+225, y-105, sPaint);
    	canvas.drawPoint(x+225, y+25, lPaint);   	
    	canvas.drawPoint(x+225, y+135, lPaint);
    	canvas.drawPoint(x+235, y+202, lPaint);
    	canvas.drawPoint(x+280, y+230, lPaint);
    	canvas.drawPoint(x+295, y+222, ePaint);
    	
    	canvas.drawPoint(x+175, y+25, sPaint);
    	canvas.drawPoint(x+275, y+25, ePaint);
    	
    	canvas.drawPoint(x-175, y-105, sPaint);
    	canvas.drawPoint(x-175, y-25, lPaint);
    	canvas.drawPoint(x-175, y+25, lPaint);   	
    	canvas.drawPoint(x-175, y+95, lPaint);
    	canvas.drawPoint(x-175, y+175, lPaint);
    	canvas.drawPoint(x-145, y+223, lPaint);
    	canvas.drawPoint(x-105, y+222, ePaint);
    	
    	canvas.drawPoint(x-225, y+25, sPaint);
    	canvas.drawPoint(x-125, y+25, ePaint);
        

		/*float [] pos = {x-175, y-590,x-175, y-550, x-175, y-510,x-175, y-460,x-175, y-419,x-175, y-390,x-175, y-350};
		canvas.drawPoints(pos, lPaint);*/

    	for (Path p : paths){
            canvas.drawPath(p, mPaint);
    	}
        canvas.drawPath(mPath, mPaint);
        
        Path p1 = new Path();
        Path p2 = new Path();
        Path p3 = new Path();
        p1.moveTo(x-160, y-600);
        p1.lineTo(x-190, y-600);
        p1.lineTo(x-190, y-240);
        p1.lineTo(x-160, y-240);
        p1.close();
        
        p2.moveTo(x-240, y-445);
        p2.lineTo(x-110, y-445);
        p2.lineTo(x-110, y-475);
        p2.lineTo(x-240, y-475);
        p2.close();
        
        p3.moveTo(x-160, y-240);
        p3.lineTo(x-90, y-240);
        p3.lineTo(x-90, y-280);
        p3.lineTo(x-160, y-280);
        p3.close();
        
        canvas.drawPath(p1, rectPaint);
        canvas.drawPath(p2, rectPaint);
        canvas.drawPath(p3, rectPaint);

        RectF rectF = new RectF();
        RectF rectF1 = new RectF();
        RectF rectF2 = new RectF();
        p1.computeBounds(rectF, true);
        p2.computeBounds(rectF1, true);
        p3.computeBounds(rectF2, true);
        r = new Region();
        r1 = new Region();
        r2 = new Region();
        r.setPath(p1, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        r1.setPath(p2, new Region((int) rectF1.left, (int) rectF1.top, (int) rectF1.right, (int) rectF1.bottom));
        r2.setPath(p3, new Region((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom));
        
        
        invalidate();
        
        
    }

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    public void touch_start(float x, float y) {
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;

    }
    public void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;
        }

    }
    public void touch_up() {
        mPath.lineTo(mX, mY);
        // commit the path to our offscreen
        mCanvas.drawPath(mPath, mPaint);
        paths.add(mPath);
        mPath = new Path();

    }

    public void onClickUndo () {;
        if (paths.size()>0) 
        { 
        	
           undonePaths.add(paths.remove(paths.size()-1));
           invalidate();
         }
    }

    public void onClickRedo (){
       if (undonePaths.size()>0) 
       { 
           paths.add(undonePaths.remove(undonePaths.size()-1));
           invalidate();

       } 
        postInvalidate(); // invalidate view from non UI thread
    }

    @Override
    public boolean onTouch(View arg0, MotionEvent event) {
    	
      xCoor = event.getX();
      yCoor = event.getY();

      switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
              touch_start(xCoor, yCoor);
              invalidate();
              //if(xCoor == )
              break;
          case MotionEvent.ACTION_MOVE:
              touch_move(xCoor, yCoor);
              invalidate();
              break;
          case MotionEvent.ACTION_UP:
              touch_up();
              invalidate();
              break;
      }
	      
	  Point point = new Point();
	  ArrayList<Point> vertPoints = new ArrayList<Point>();
	  ArrayList<Point> horizPoints = new ArrayList<Point>();
	  point.x = (int) event.getX();
	  point.y = (int) event.getY();
	  invalidate();
	  Log.d(VIEW_LOG_TAG, "point: " + point);
	
	  if(r.contains((int)point.x,(int) point.y) || r1.contains((int)point.x,(int) point.y) || r2.contains((int)point.x,(int) point.y)){
	      Log.d(VIEW_LOG_TAG, "Touch IN");
	  	  pointInCount++;
	      Log.d(VIEW_LOG_TAG, "XXXXXXXXXXXX" + (x-175));
	      Log.d(VIEW_LOG_TAG, "YYYYYYYYYYYY" + (y-590));
	      if(point == new Point((int)x-176,(int)y-589)){
		      Log.d(VIEW_LOG_TAG, "A MATCH!!!!!!!!!!!!!!!!!!!!!!");

	      }

	  }
	  else{
	      Log.d(VIEW_LOG_TAG, "Touch OUT");
	      pointOutCount++;
	      Log.d(VIEW_LOG_TAG, "Point Out Count" + pointOutCount);
	      if(pointOutCount > 15){
	    	  Toast.makeText(getContext(), "Not a valid letter, please try again", Toast.LENGTH_LONG).show();
	    	  pointOutCount = 0;	    	  
	          /*while(paths.size()>0) 
	          { 
	             //undonePaths.add(paths.remove(paths.size()-1));
	        	  paths.clear();
	             invalidate();
	           }*/
	      }
	      
	  }
	
	  return true;
	}
    
    @Override
    // Pass the touch screen motion event down to the target view, or this view if it is the target
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mCapturing) {
			onTouch(null, event);
            //Log.d(VIEW_LOG_TAG, "dispatchTouchEvent");
  	      	//System.out.println("Arraylist" + paths.size());
            return true;
        } else {
            return false;
        }
    }
      
}