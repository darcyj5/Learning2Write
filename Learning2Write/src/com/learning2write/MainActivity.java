package com.learning2write;

import java.io.Serializable;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import android.widget.EditText;

public class MainActivity extends Activity implements ViewInterface, Serializable, Cloneable {
    /** Called when the activity is first created. */
	// Various variable declarations
        Button upper, lower, go;
        TextView textView;
        Listener myListener; // calls on the Listener interface
        Boolean isUpper;
        ArrayList <Character> U = new ArrayList<Character>();
        ArrayList <Character> L = new ArrayList<Character>();
    	Model m = new Model(U, L); // creates an instance of the class Model

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The layout will be based on the XML file activity_main
        setContentView(R.layout.activity_main);
        
        // Assign the variables to the appropriate buttons.
        // The item id's are in relation to those specified in the XML file
        upper = (Button) findViewById(R.id.button_id);
        lower = (Button) findViewById(R.id.button1_id);
        go = (Button) findViewById(R.id.button2_id);
        textView  = (TextView) findViewById(R.id.LabelView);
       
        new Presenter(this); // Call an instance of the Presenter class
        //set up listeners
        upper.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                    myListener.setUpper(); //Calls the setUpper method defined in the Presenter class
                    isUpper = true;
                    m.addItemUpper('0'); // Add item to appropriate ArrayList in Model
           }
        });
        lower.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
            		myListener.setLower(); // Calls the setLower method defined in the Presenter class
            		isUpper = false;
            		m.addItemLower('0');
            }
        });
        go.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	if(isUpper == null){
            		myListener.noCase(); // Calls the method noCase method defined in the Presenter class    		
            	}
            	else if(isUpper == true){
					Intent myIntent = new Intent(MainActivity.this, UpperCaseTabbed.class); // Creates an Intent to start the UpperCase activity
					//Intent myIntent = new Intent(MainActivity.this, TestActivity.class); // Creates an Intent to start the UpperCase activity
            		startActivity(myIntent);
					m.addItemUpper('A'); // Add upper case A to ArrayList, to show this step has been attempted
            	}
            	else{
    				Intent myIntent = new Intent(MainActivity.this, LowerCaseTabbed.class); //Creates an Intent to start the LowerCase activity
    				startActivity(myIntent);
    				m.addItemLower('a'); // Add lower case a to ArrayList, to show this step has been attempted
            	}
            }
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
    public void setClickListener(Listener inListener) { // Define the method for setting the on click listener
        myListener = inListener;
        
	}
	public void setWelcomeText(String labelText) { // Define the method to set text on the home screen
	        textView.setText(labelText);
	}
	public void displayToast(String display) { // Define the method to display Toast messages
		Toast.makeText(getApplicationContext(), display, Toast.LENGTH_LONG).show();
	}

}
