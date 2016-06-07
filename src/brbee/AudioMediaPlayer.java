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
*   Last Edited: 02/09/2016
* 
*   Class is used to play audio files if the user selects one.
*******************************************************************************/

public class AudioMediaPlayer {
    
    private Group view;
    private String audioPath;
    private MediaPlayer mediaPlayer;
    
    public AudioMediaPlayer(JFXPanel jfxPanel, String audioPath) {
        
        this.audioPath = audioPath;
        initFX(jfxPanel);     
    }
    
    private void initFX(JFXPanel jfxPanel){
        Scene scene = createScene();
        jfxPanel.setScene(scene);
    }
    
    private Scene createScene(){
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        Media media = new Media(audioPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        MediaView mediaView = new MediaView(mediaPlayer);
        
        System.out.println(audioPath);
        
        root.getChildren().add(mediaView);
        
        return (scene);
    }
    
    public void stopAudio(){
        mediaPlayer.stop();
    }
    
    public Parent getView(){
        return view;
    }
}
