package brbee;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*******************************************************************************
*   Author: Jarek Thomas
* 
*   Class is used to edit the users profile. Serialized theatre object is loaded,
*   and any changes will overwrite the previous object.
*******************************************************************************/

public class EditProfile extends javax.swing.JPanel {
    
    /***************************************************************************
    *                           DECLARE VARIABLES
    ***************************************************************************/
    private Controller controller;
    private Theatre theatreObj, tempTheatre;
    private String missingFields = "", temp;
    private BufferedImage img;
    private String[] message = { "Select Profile" };
    private DefaultComboBoxModel model = new DefaultComboBoxModel(message);
    private int counter = 0;
    
    /***************************************************************************
    *                           CONSTRUCTOR METHODS
    ***************************************************************************/
    public EditProfile(Controller controller, Theatre theatreObj) {
        initComponents();
        this.controller = controller;
        this.theatreObj = theatreObj;
    }
    public void addToModel(String name){
        model.addElement(name);
    }
    public void clearList(){
        model.removeAllElements();
        model.addElement(message[0]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveBtn = new javax.swing.JButton();
        profileCbo = new javax.swing.JComboBox();
        alertLbl = new javax.swing.JLabel();
        backgroundLbl = new javax.swing.JLabel();
        songBtn = new javax.swing.JButton();
        backgroundBtn = new javax.swing.JButton();
        videoBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(10, 10));
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
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, 410, 100));

        profileCbo.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        profileCbo.setModel(model);
        profileCbo.setSelectedItem(profileCbo);
        profileCbo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileCboMouseClicked(evt);
            }
        });
        add(profileCbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 71));

        alertLbl.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        alertLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alertLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        alertLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(alertLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 375, 450));

        backgroundLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brbee/images/BeeLogo.png"))); // NOI18N
        add(backgroundLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 150, 130));

        songBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        songBtn.setText("Audio (Optional)");
        songBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songBtnActionPerformed(evt);
            }
        });
        add(songBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 239, 73));

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

        backBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 110, 40));

        deleteBtn.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(204, 0, 0));
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 660, 120, 80));
    }// </editor-fold>//GEN-END:initComponents

    /***************************************************************************
    *                            ----BEGIN BUTTON---
    ***************************************************************************/
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        missingFields = "";
        alertLbl.setText("<html>" + missingFields + "</html>");
        
        if(profileCbo.getSelectedIndex() != 0){
            if( theatreObj.getBGround() != null || theatreObj.getVideo() != null ) {
               
               try {
                    FileOutputStream fileOut =
                    new FileOutputStream("Saved/" + profileCbo.getSelectedItem() + ".ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(theatreObj);
                    out.close();
                    fileOut.close();
                    
                    missingFields = profileCbo.getSelectedItem() + " profile updated.<br>";
                    alertLbl.setText("<html>" + missingFields + "</html>");
                    missingFields = "";
                }catch(IOException i)
                {
                    i.printStackTrace();
                } 
                
            } else {
                missingFields = "Required: Background/Video<br>";
                alertLbl.setText("<html>" + missingFields + "</html>");
                missingFields = "";
            }
        } else {
            missingFields = "Please select a profile.";
            alertLbl.setText("<html>" + missingFields + "</html>");
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
    *                           ----BACK BUTTON----
    ***************************************************************************/
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        controller.showCard(Controller.MAIN_MENU);

    }//GEN-LAST:event_backBtnActionPerformed
    /***************************************************************************
    *                           ----DELETE BUTTON----
    ***************************************************************************/
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(profileCbo.getSelectedItem().toString() != message[0]){
            
            try {
                Path path = FileSystems.getDefault().getPath("Saved", "" + profileCbo.getSelectedItem().toString()  + ".ser" );
                Files.delete( path );
            } catch (IOException io){
                io.printStackTrace();
            }
            model.removeElementAt( profileCbo.getSelectedIndex() );
            controller.deleteElement( profileCbo.getSelectedIndex() );
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void profileCboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileCboMouseClicked
   
        if(profileCbo.getSelectedIndex() != 0 ){
            
            tempTheatre = null;
            temp = profileCbo.getSelectedItem().toString();

            try {
                FileInputStream fileIn = new FileInputStream("Saved/" + temp + ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                tempTheatre = (Theatre) in.readObject();
                in.close();
                fileIn.close();
            }catch(IOException i)
            {
               i.printStackTrace();
               return;
            }catch(ClassNotFoundException c)
            {
               System.out.println("Profile not found.");
               c.printStackTrace();
               return;
            }

            theatreObj.setVideo( tempTheatre.getVideo() );
            theatreObj.setSong( tempTheatre.getSong() );
            theatreObj.setBGround( tempTheatre.getBGround() );
        }
        
    }//GEN-LAST:event_profileCboMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backgroundBtn;
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox profileCbo;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton songBtn;
    private javax.swing.JButton videoBtn;
    // End of variables declaration//GEN-END:variables
}
