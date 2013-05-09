package com.learning2write;

public interface ViewInterface {

	// The View classes make use of the following empty bodied messages
    public void setWelcomeText(String labelText);
    public void setClickListener(Listener inListener);
    public void displayToast(String display);
}
