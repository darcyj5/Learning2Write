// Presenter

package com.learning2write;

import java.io.Serializable;

//import com.software.patterns.Listener;
//import com.software.patterns.ViewInterface;

public class Presenter implements Serializable, Cloneable{
    
    ViewInterface View; // Creates an instance of the View Interface
    
    public Presenter(ViewInterface inView) { // Constructor
            setMethods(inView);
    }
    
    public void setMethods(ViewInterface inInter)
    {
            View = inInter;
  
            View.setClickListener(new Listener() {
            	// Use the following methods to determine what is displayed on the UI
                    public void setUpper() { 
                            View.setWelcomeText("Upper case selected. Please continue.");
                    }
                    public void setLower(){
                    	View.setWelcomeText("Lower case selected. Please continue.");
                    }
                    public void eraseWork(){
                    	View.displayToast("Work Erased");
                    }
                    public void setVoice(){
                    	View.displayToast("Voice Commands Activated");
                    }
                    public void next(){
                    	View.displayToast("Moving onto the next letter");
                    }
                    public void noCase(){
                    	View.displayToast("You must select a case");
                    }
                
            });
            View.setWelcomeText("Please choose a case to practice writing in");
    }

}
