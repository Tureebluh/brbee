package brbee;

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
*   Class is used to play video if the user selects one.
*******************************************************************************/

public class VideoMediaPlayer {
    /***************************************************************************
    *   Declare variables
    ****************************************************************************/
    private String videoPath;
    private MediaPlayer mediaPlayer;
    
    /***************************************************************************
    *   Constructor method. Sets the video path and initializes the scene for the
    *   JFXPanel calling createScene()
    ****************************************************************************/
    public VideoMediaPlayer(JFXPanel jfxPanel, String videoPath) {
        this.videoPath = videoPath;
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
        //Create root node and add scene to node
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        //Create media object with passed videoPath. Add media object to mediaPlayer
        //and set mediaPlayer to autoplay
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        //Add mediaPlayer to a mediaView object
        MediaView mediaView = new MediaView(mediaPlayer);
        
        //Set video to 720p without preserving aspect ratio
        mediaView.setFitWidth(1285);
        mediaView.setFitHeight(720);
        mediaView.setPreserveRatio(false);
        
        //Add mediaView to root node
        root.getChildren().add(mediaView);
        
        return (scene);
    }
    
    /***************************************************************************
    *   Calls stop method on mediaPlayer object.
    ****************************************************************************/
    public void stopVideo(){
        mediaPlayer.stop();
    }
}
