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
*   Last Edited: 02/09/2016
* 
*   Class is used to play video if the user selects one.
*******************************************************************************/

public class VideoMediaPlayer {

    private Group view;
    
    private String videoPath;
    private MediaPlayer mediaPlayer;
    
    public VideoMediaPlayer(JFXPanel jfxPanel, String videoPath) {
        this.videoPath = videoPath;
        initFX(jfxPanel);
        
    }
    
    private void initFX(JFXPanel jfxPanel){
        Scene scene = createScene();
        jfxPanel.setScene(scene);
        
    }
    
    private Scene createScene(){
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);
        
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        MediaView mediaView = new MediaView(mediaPlayer);
        
        
        mediaView.setFitWidth(1285);
        mediaView.setFitHeight(720);
        mediaView.setPreserveRatio(false);
        
        root.getChildren().add(mediaView);
        
        return (scene);
    }
    
    public void stopVideo(){
        mediaPlayer.stop();
    }
    
    public Parent getView(){
        return view;
    }
}
