package com.learning2write;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class LowerCaseTabbed extends Activity {

	Button back, back1, back2, back3, back4, back5, undo, redo;
	Listener myListener;
	LowerT t;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lower_case_tabbed);
		//FrameLayout frm_layout=(FrameLayout) findViewById(R.id.tabcontent);
		t = new LowerT(this);

        //frm_layout.addView(t);
		back = (Button) findViewById(R.id.button3_id);
		back1 = (Button) findViewById(R.id.button4_id);
		back2 = (Button) findViewById(R.id.button5_id);
		back3 = (Button) findViewById(R.id.button6_id);
		back4 = (Button) findViewById(R.id.button7_id);
		back5 = (Button) findViewById(R.id.button8_id);
		undo = (Button) findViewById(R.id.button9_id);
		redo = (Button) findViewById(R.id.button10_id);

        //set up listeners
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        undo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	System.out.println("Undo Clicked");
            	t.onClickUndo();
            }
        });
        
        redo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	System.out.println("Redo Clicked");
            	t.onClickRedo();
            }
        });
		
		
		TabHost tabHostl=(TabHost)findViewById(R.id.tabHostl);
		tabHostl.setup();

		TabSpec spec1l=tabHostl.newTabSpec("Tab 1");
		spec1l.setContent(R.id.tab1l);
		spec1l.setIndicator("----");

		TabSpec spec2l=tabHostl.newTabSpec("Tab 2");
		spec2l.setIndicator("^^^^");
		spec2l.setContent(R.id.tab2l);

		TabSpec spec3l=tabHostl.newTabSpec("Tab 3");
		spec3l.setIndicator("s");
		spec3l.setContent(R.id.tab3l);
		
		TabSpec spec4l=tabHostl.newTabSpec("Tab 4");
		spec4l.setIndicator("a");
		spec4l.setContent(R.id.tab4l);
		
		TabSpec spec5l=tabHostl.newTabSpec("Tab 5");
		spec5l.setIndicator("t");
		spec5l.setContent(R.id.tab5l);
		
		TabSpec spec6l=tabHostl.newTabSpec("Tab 6");
		spec6l.setIndicator("i");
		spec6l.setContent(R.id.tab6l);

		tabHostl.addTab(spec1l);
		tabHostl.addTab(spec2l);
		tabHostl.addTab(spec3l);
		tabHostl.addTab(spec4l);
		tabHostl.addTab(spec5l);
		tabHostl.addTab(spec6l);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabbed_view, menu);
		return true;
	}
}