// Model

package com.learning2write;

import java.io.Serializable;
import java.util.ArrayList;

// Define an object Model, which implements two ArrayLists, which keep track of how the user is progressing
public class Model implements Serializable, Cloneable {
    public ArrayList <Character> Upper = new ArrayList<Character>(); // For Upper case
    public ArrayList <Character> Lower = new ArrayList<Character>(); // For Lower case
    
    // Constructors
    public Model(ArrayList <Character> U, ArrayList <Character> L){
    	Upper = U;
    	Lower = L;
    }
    public Model(ArrayList <Character> U){
    	Upper = U;
    }
    // Override the methods for adding and removing items from the Array Lists
    public void addItemUpper(char u){
    	Upper.add(u);
    }
    public void addItemLower(char l){
    	Lower.add(l);
    }
    public void removeItemUpper(int u){
    	Upper.remove(u);
    }
    public void removeItemLower(int l){
    	Lower.remove(l);
    }
    // Override the clone and equals methods in order to make this class canonical.
    public Object clone() {

        // Do the basic clone
        Model theClone = null;
        try {
            theClone = (Model) super.clone();
        }
        catch (CloneNotSupportedException e) {
            // Should never happen
            throw new InternalError(e.toString());
        }

        // Clone mutable members
        theClone.Upper = (ArrayList) Upper.clone();
        theClone.Lower = (ArrayList) Lower.clone();
        return theClone;
    }

    public boolean equals(Model o) {

        if (o == null) {
            return false;
        }

        Model m;
        try {
            m = (Model) o;
        }
        catch (ClassCastException e) {
            return false;
        }

        if (Lower.equals(m.Lower) && Upper.equals(m.Upper)) {
            return true;
        }
        return false;
    }

}
