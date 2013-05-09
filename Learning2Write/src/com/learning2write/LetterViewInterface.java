package com.learning2write;

import android.view.MotionEvent;
import android.view.View;

public interface LetterViewInterface {
 
    public void touch_start(float x, float y);
    public void touch_move(float x, float y);
    public void touch_up();
    public void onClickUndo ();
    public void onClickRedo ();
    public boolean onTouch(View arg0, MotionEvent event);
    public boolean dispatchTouchEvent(MotionEvent event);

}
