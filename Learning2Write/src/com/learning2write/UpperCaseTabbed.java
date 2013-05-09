package com.learning2write;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class UpperCaseTabbed extends Activity {

	Button back, back1, back2, back3, back4, back5;
	Listener myListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabbed_view);
		
		back = (Button) findViewById(R.id.button3_id);
		back1 = (Button) findViewById(R.id.button4_id);
		back2 = (Button) findViewById(R.id.button5_id);
		back3 = (Button) findViewById(R.id.button6_id);
		back4 = (Button) findViewById(R.id.button7_id);
		back5 = (Button) findViewById(R.id.button8_id);
        //set up listeners
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
        back5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(UpperCaseTabbed.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Upper.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter A
            }
        });
				
		TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
		tabHost.setup();

		TabSpec spec1=tabHost.newTabSpec("Tab 1");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("----");

		TabSpec spec2=tabHost.newTabSpec("Tab 2");
		spec2.setIndicator("^^^^");
		spec2.setContent(R.id.tab2);

		TabSpec spec3=tabHost.newTabSpec("Tab 3");
		spec3.setIndicator("S");
		spec3.setContent(R.id.tab3);
		
		TabSpec spec4=tabHost.newTabSpec("Tab 4");
		spec4.setIndicator("A");
		spec4.setContent(R.id.tab4);
		
		TabSpec spec5=tabHost.newTabSpec("Tab 5");
		spec5.setIndicator("T");
		spec5.setContent(R.id.tab5);
		
		TabSpec spec6=tabHost.newTabSpec("Tab 6");
		spec6.setIndicator("I");
		spec6.setContent(R.id.tab6);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		tabHost.addTab(spec4);
		tabHost.addTab(spec5);
		tabHost.addTab(spec6);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabbed_view, menu);
		return true;
	}

}
