//View
package com.learning2write;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LowerCase extends Activity implements ViewInterface, Serializable, Cloneable{
	// Various variable declarations

	Button back, erase, voice, next;
	Listener myListener; // calls on the Listener interface
	TextView textView;
    ArrayList <Character> L = new ArrayList<Character>();
	Model m = new Model(L); // creates an instance of the class Model
    //Model m;
    
    //Override the onCreate method, so when the Activity is created, the following happens
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		// The layout will be based on the XML file activity_main
		setContentView(R.layout.lowercase);
		
        // Assign the variables to the appropriate buttons.
        // The item id's are in relation to those specified in the XML file
		voice = (Button) findViewById(R.id.button_id);
		erase = (Button) findViewById(R.id.button1_id);
		next = (Button) findViewById(R.id.button2_id);
		back = (Button) findViewById(R.id.button3_id);
		textView  = (TextView) findViewById(R.id.LabelView);
		
        new Presenter(this); // Call an instance of the Presenter class
        //set up listeners
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
				Intent myIntent = new Intent(LowerCase.this, MainActivity.class); // Creates an Intent to go back to the MainActivity
				startActivity(myIntent);
				//m.removeItemUpper((Lower.size() -1)); // Should remove the last item from the ArrayList to show that the user has exited from the Letter a
            }
        });
        erase.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	myListener.eraseWork();  // To display toast message, confirming the work has been erased
            }
        });
        voice.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	myListener.setVoice(); // To display a toast message to say that Voice Commands have been turned on or off
            }
        });
        next.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { // Displays a toast message when the user moves onto the next letter, in this case b
            	myListener.next();
				m.addItemUpper('b'); // Adds b to the ArrayList in order to update on the user's progress
            }
        });
        Log.d("Software Patterns", "End");
	}
    public void setClickListener(Listener inListener) { // Define the method for setting the on click listener
        myListener = inListener;
        
    }
    public void setWelcomeText(String labelText) { // Method left blank as not used in this view, but still defined in the interface
    }
    public void displayToast(String display) { // Define the method to set text on the home screen
    	Toast.makeText(getApplicationContext(), display, Toast.LENGTH_SHORT).show();
    }
}
