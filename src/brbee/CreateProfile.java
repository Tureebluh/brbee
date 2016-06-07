package brbee;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*******************************************************************************
*   Author: Jarek Thomas
*   Last Edited: 02/09/2016
* 
*   Class is used to save user profiles. Profiles are saved as serialized theatre
*   objects.
*******************************************************************************/

public class CreateProfile extends javax.swing.JPanel {
    
    /***************************************************************************
    *                           DECLARE VARIABLES
    ***************************************************************************/
    private Controller controller;
    private Theatre theatreObj;
    private String missingFields = "";
    private BufferedImage img;
    
    
    /***************************************************************************
    *                           CONSTRUCTOR METHODS
    ***************************************************************************/
    public CreateProfile(Controller controller, Theatre theatreObj) {
        initComponents();
        this.controller = controller;
        this.theatreObj = theatreObj;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveBtn = new javax.swing.JButton();
        alertLbl = new javax.swing.JLabel();
        backgroundLbl = new javax.swing.JLabel();
        songBtn = new javax.swing.JButton();
        backgroundBtn = new javax.swing.JButton();
        videoBtn = new javax.swing.JButton();
        userInput = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        nameProfileLbl = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveBtn.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBtn.setMargin(null);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, 410, 100));

        alertLbl.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        alertLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(alertLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 350, 290));

        backgroundLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brbee/images/BeeLogo.png"))); // NOI18N
        add(backgroundLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, -1, -1));

        songBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        songBtn.setText("Audio (Optional)");
        songBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songBtnActionPerformed(evt);
            }
        });
        add(songBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 22, 239, 73));

        backgroundBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        backgroundBtn.setText("Background (Required)");
        backgroundBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundBtnActionPerformed(evt);
            }
        });
        add(backgroundBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 225, 74));

        videoBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        videoBtn.setText("Video (Optional)");
        videoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoBtnActionPerformed(evt);
            }
        });
        add(videoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 225, 74));

        userInput.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        userInput.setToolTipText("Profile name");
        add(userInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 226, 43));

        backBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 107, 41));

        nameProfileLbl.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        nameProfileLbl.setText("Name Profile:");
        add(nameProfileLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 24, 230, 20));
    }// </editor-fold>//GEN-END:initComponents

    /***************************************************************************
    *                            ----SAVE BUTTON---
    ***************************************************************************/
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
            
        missingFields = "";
        alertLbl.setText("<html>" + missingFields + "</html>");

        if( theatreObj.getBGround() != null || theatreObj.getVideo() != null ) {
           if(userInput.getText().matches("[a-zA-Z0-9]+")) { 
                try {
                     FileOutputStream fileOut =
                     new FileOutputStream("Saved/" + userInput.getText() + ".ser");
                     ObjectOutputStream out = new ObjectOutputStream(fileOut);
                     out.writeObject(theatreObj);
                     out.close();
                     fileOut.close();

                     controller.updateProfiles();
                     missingFields = userInput.getText() + " profile saved.<br>";
                     alertLbl.setText("<html>" + missingFields + "</html>");
                     userInput.setText("");
                     missingFields = "";
                } catch(IOException i) {
                     i.printStackTrace();
                } 
            } else {
                missingFields = "Profile name may only contain letters and numbers.";
                alertLbl.setText("<html>" + missingFields + "</html>");
                missingFields = "";
            }
        } else {
            missingFields = "Required: Background/Video<br>";
            alertLbl.setText("<html>" + missingFields + "</html>");
            missingFields = "";
        }
                
            

    }//GEN-LAST:event_saveBtnActionPerformed
    /***************************************************************************
    *                            ----SONG BUTTON----
    ***************************************************************************/
    private void songBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songBtnActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        
        FileNameExtensionFilter filter = 
                new FileNameExtensionFilter("Audio Files", "aif", "au", "wav", "mid", "mp3");
        
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.addChoosableFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        
        int result = jfc.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            
            File file = jfc.getSelectedFile();
            theatreObj.setSong(file.toURI().toString());
            
        }
    }//GEN-LAST:event_songBtnActionPerformed
    /***************************************************************************
    *                          ----BACKGROUND BUTTON----
    ***************************************************************************/
    private void backgroundBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backgroundBtnActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        
        FileNameExtensionFilter filter = 
                new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg", "tiff", "tif");
        
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.addChoosableFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        
        int result = jfc.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            theatreObj.setBGround(file.getAbsolutePath());
        }
    }//GEN-LAST:event_backgroundBtnActionPerformed
    /***************************************************************************
    *                           ----VIDEO BUTTON----
    ***************************************************************************/
    private void videoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoBtnActionPerformed
        
        JFileChooser jfc = new JFileChooser();
        
        FileNameExtensionFilter filter = 
                new FileNameExtensionFilter("Video Files", "fxm", "flv", "m3u8", "mp4", "m4a", "m4v");
        
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.addChoosableFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        
        int result = jfc.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            
            theatreObj.setVideo(file.toURI().toString());
        }
        
    }//GEN-LAST:event_videoBtnActionPerformed

    /***************************************************************************
    *                            ----BACK BUTTON---
    ***************************************************************************/
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        
        controller.showCard("MAIN_MENU");
        
        alertLbl.setText("");
        
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backgroundBtn;
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JLabel nameProfileLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton songBtn;
    private javax.swing.JTextField userInput;
    private javax.swing.JButton videoBtn;
    // End of variables declaration//GEN-END:variables
}
