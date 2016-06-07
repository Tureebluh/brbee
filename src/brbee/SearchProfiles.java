package brbee;


import java.io.*;


public class SearchProfiles {
    LoadProfile loadObj;
    EditProfile editObj;
    
    public SearchProfiles(LoadProfile loadObj, EditProfile editObj){
        this.loadObj = loadObj;
        this.editObj = editObj;
        populateList();
    }

    public void populateList() {
        File file = new File("Saved/");
        File[] profiles = file.listFiles(new FilenameFilter() {
           public boolean accept(File dir, String name) {
               return name.endsWith("ser");
           }    
        });
        
        editObj.clearList();
        loadObj.clearList();
        
        for(int i = 0; i < profiles.length; i++ ){
            String temp = profiles[i].getName();
            temp = temp.substring( 0, temp.length() - 4 );
            loadObj.addToModel( temp );
            editObj.addToModel( temp );
        }
    }
    
}
