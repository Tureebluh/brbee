package brbee;

import java.io.*;

/*******************************************************************************
*   Author: Jarek Thomas
* 
*   Used to generate a list of serialized objects that the user has saved
*******************************************************************************/

public class SearchProfiles {
    //Declare load and edit objects
    LoadProfile loadObj;
    EditProfile editObj;
    
    //Initialize objects and populate list when constructor is called
    public SearchProfiles(LoadProfile loadObj, EditProfile editObj){
        this.loadObj = loadObj;
        this.editObj = editObj;
        populateList();
    }
    
    public void populateList() {
        //Create file object referencing Saved directory
        File file = new File("Saved/");
        //Create an array of File objects that end with ser for serialized objects
        File[] profiles = file.listFiles(new FilenameFilter() {
           public boolean accept(File dir, String name) {
               return name.endsWith("ser");
           }    
        });
        
        //Clear the list so objects aren't duplicated if list is being updated.
        editObj.clearList();
        loadObj.clearList();
        
        //Loop through array of File objects (profiles) and add the name of the
        //file, minus the .ser extension, to both the Load, and Edit panels.
        for(int i = 0; i < profiles.length; i++ ){
            String temp = profiles[i].getName();
            temp = temp.substring( 0, temp.length() - 4 );
            loadObj.addToModel( temp );
            editObj.addToModel( temp );
        }
    }
    
}
