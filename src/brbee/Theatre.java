package brbee;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.ImageIcon;
import javax.swing.Timer;


/*******************************************************************************
*   Author: Jarek Thomas
* 
*   This class is responsible for displaying the video, as well as the countdown
*   timer.
*******************************************************************************/

public class Theatre extends javax.swing.JPanel {
    
    /***************************************************************************
    *                           DECLARE VARIABLES
    *   NOTE: Variables marked with 'transient' will not be serialized.
    ***************************************************************************/
    private transient Controller controller;
    private int counter;
    private String bGround, song, video;
    private Timer timer;
    private transient AudioMediaPlayer audioMediaPlayer;
    private transient VideoMediaPlayer videoMediaPlayer;
    private transient JFXPanel videoPanel = new JFXPanel();
    private transient JFXPanel audioPanel = new JFXPanel();
    
    /***************************************************************************
    *                           CONSTRUCTOR METHODS
    ***************************************************************************/
    public Theatre(Controller controller) {
        initComponents();
        
        this.controller = controller;
        //Initiailize timer object and set callback function to StartCountdown()
        this.timer = new Timer(1000, new StartCountdown());
    }
    
    /***************************************************************************
    *                           ACCESSOR METHODS 
    ***************************************************************************/
    public int getTime() {
        return counter;
    }
    public String getSong() {
        return song;
    }
    public String getBGround() {
        return bGround;
    }
    public String getVideo() {
        return video;
    }
    
    /***************************************************************************
    *                           MUTATOR METHODS
    ***************************************************************************/
    public void setTime(int seconds) {
        this.counter = seconds;
    }
    public void setSong(String song) {
        this.song = song;
    }
    public void setBGround(String bGround) {
        this.bGround = bGround;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    
    /***************************************************************************
    *                           START/STOP METHODS
    ***************************************************************************/
    public void startTimer(){
        this.timer.start();  
    }
    public void stopTime(){
        this.timer.stop();
    }
    public void openDialog(){
        endDialog.setVisible(true);
    }
    
    /***************************************************************************
    *                           BACKGROUND METHODS
    ***************************************************************************/
    public void loadBackground(){
        
        try {
            backgroundLbl.setIcon(ResizeImage(getBGround()));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ImageIcon ResizeImage (String path){
        
        ImageIcon imgIcon = new ImageIcon (path);
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(backgroundLbl.getWidth(),
                                backgroundLbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(resizedImg);
        return image;
    }
    
    /***************************************************************************
    *                           VIDEO METHODS
    ***************************************************************************/
    public void loadVideo(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                
                add(videoPanel);
                
                try {
                   String fileURI = getVideo();
                   videoMediaPlayer = new VideoMediaPlayer( videoPanel, fileURI ); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
    }
    
    /***************************************************************************
    *                           AUDIO METHODS
    ***************************************************************************/
    public void loadAudio(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                
                add(audioPanel);
                
                try {
                   String fileURI = getSong();
                   audioMediaPlayer = new AudioMediaPlayer( audioPanel, fileURI ); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /***************************************************************************
    *                           TIME CONVERSION
    ***************************************************************************/
    private String timeConversion(int seconds){
        final int SECONDS_IN_A_MINUTE = 60;
        
        int minutes = seconds / SECONDS_IN_A_MINUTE;
        seconds -= minutes * SECONDS_IN_A_MINUTE;
        
        return String.format("%d:%02d", minutes, seconds);
    }
    
    
    /***************************************************************************
    *                         STARTCOUNTDOWN CLASS
    ***************************************************************************/
    private class StartCountdown implements ActionListener {     
        @Override
        public void actionPerformed(ActionEvent event){
            
            if(counter > 0) {
                timerLbl.setText("Your streamer will be back in approximately - " 
                        + timeConversion(counter));
                counter--;
            } else {
                if(getSong() != null){
                    audioMediaPlayer.stopAudio();
                }
                if(getVideo() != null){
                    videoMediaPlayer.stopVideo();
                }
                
                stopTime();
                controller.showCard(Controller.MAIN_MENU);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endDialog = new javax.swing.JDialog();
        endBtn = new javax.swing.JButton();
        backgroundLbl = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();

        endDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        endDialog.setMinimumSize(new java.awt.Dimension(75, 75));
        endDialog.setPreferredSize(new java.awt.Dimension(200, 200));

        endBtn.setForeground(new java.awt.Color(204, 0, 0));
        endBtn.setText("END");
        endBtn.setMaximumSize(new java.awt.Dimension(100, 100));
        endBtn.setMinimumSize(new java.awt.Dimension(75, 75));
        endBtn.setPreferredSize(new java.awt.Dimension(75, 75));
        endBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endBtnActionPerformed(evt);
            }
        });
        endDialog.getContentPane().add(endBtn, java.awt.BorderLayout.CENTER);

        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(1280, 755));
        setPreferredSize(new java.awt.Dimension(1280, 755));
        setLayout(new java.awt.BorderLayout());

        backgroundLbl.setPreferredSize(new java.awt.Dimension(1280, 720));
        add(backgroundLbl, java.awt.BorderLayout.CENTER);

        timerLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        timerLbl.setPreferredSize(new java.awt.Dimension(1280, 35));
        add(timerLbl, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    /***************************************************************************
    *                               END BUTTON
    ***************************************************************************/
    private void endBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endBtnActionPerformed
        
        //Ensures video/audio is not null before attempting to stop(). 
        //Returns user back to main menu and makes end button invisible.        
        if(getSong() != null){
            audioMediaPlayer.stopAudio();
        }
        if(getVideo() != null){
            videoMediaPlayer.stopVideo();
        }

        stopTime();
        controller.showCard(Controller.MAIN_MENU);

        endDialog.setVisible(false);
            
    }//GEN-LAST:event_endBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JButton endBtn;
    private javax.swing.JDialog endDialog;
    private javax.swing.JLabel timerLbl;
    // End of variables declaration//GEN-END:variables
}
