package brbee;

import javafx.scene.Group;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

/*******************************************************************************
*   Author: Jarek Thomas
* 
*   Class is used to play audio files if the user selects one.
*******************************************************************************/

public class AudioMediaPlayer {
    /***************************************************************************
    *   Declare variables
    ****************************************************************************/
    private String audioPath;
    private MediaPlayer mediaPlayer;
    
    /***************************************************************************
    *   Constructor method. Sets the audiopath and initializes the scene for 
    *   the JFXPanel calling createScene()
    ****************************************************************************/
    public AudioMediaPlayer(JFXPanel jfxPanel, String audioPath) {
        
        this.audioPath = audioPath;
        initFX(jfxPanel);     
    }
    
    private void initFX(JFXPanel jfxPanel){
        Scene scene = createScene();
        jfxPanel.setScene(scene);
    }
    
    /***************************************************************************
    *   Used to create the scene for the JFXPanel.
    ****************************************************************************/
    private Scene createScene(){
        //Create our root node and add scene to node
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        //Create media object with passed audioPath, and add to MediaPlayer object.
        //MediaPlayer object is set to autoplay
        Media media = new Media(audioPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        //Add the mediaPlayer to a mediaView object.
        MediaView mediaView = new MediaView(mediaPlayer);
        
        //Add mediaView to root node
        root.getChildren().add(mediaView);
        
        return (scene);
    }
    /***************************************************************************
    *   Calls stop method on mediaPlayer object.
    ****************************************************************************/
    public void stopAudio(){
        mediaPlayer.stop();
    }
    
}
