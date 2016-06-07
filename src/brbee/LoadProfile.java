package brbee;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*******************************************************************************
*   Author: Jarek Thomas
*   Last Edited: 02/09/2016
* 
*   Class is used to load the users profile, which is stored locally as a serialized
*   object.
*******************************************************************************/

public class LoadProfile extends javax.swing.JPanel {
    
    /***************************************************************************
    *                           DECLARE VARIABLES
    ***************************************************************************/
    private Controller controller;
    private Theatre theatreObj, tempTheatre;
    private String missingFields = "";
    private String[] message = { "Select Profile" };
    private DefaultComboBoxModel model = new DefaultComboBoxModel(message);
    
    
    /***************************************************************************
    *                           CONSTRUCTOR METHODS
    ***************************************************************************/
    public LoadProfile(Controller controller, Theatre theatreObj) {
        initComponents();
        this.controller = controller;
        this.theatreObj = theatreObj;
    }
    
    public void addToModel(String name){
        model.addElement(name);
    }
    public void deleteElement(Integer index){
        model.removeElementAt( index + 1 );
    }
    public void clearList(){
        model.removeAllElements();
        model.addElement(message[0]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beginBtn = new javax.swing.JButton();
        timeCbo = new javax.swing.JComboBox();
        alertLbl = new javax.swing.JLabel();
        backgroundLbl = new javax.swing.JLabel();
        profileCbo = new javax.swing.JComboBox();
        backBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(10, 10));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        beginBtn.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        beginBtn.setText("BEGIN");
        beginBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        beginBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        beginBtn.setMargin(null);
        beginBtn.setMaximumSize(null);
        beginBtn.setMinimumSize(null);
        beginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginBtnActionPerformed(evt);
            }
        });
        add(beginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 410, 100));

        timeCbo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        timeCbo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "How many minutes?", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "15", "20", "25", "30" }));
timeCbo.setSelectedItem(timeCbo);
add(timeCbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 230, 70));

alertLbl.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
alertLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
alertLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
alertLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
add(alertLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 390, 500));

backgroundLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
backgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brbee/images/BeeLogo.png"))); // NOI18N
add(backgroundLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 209, -1, -1));

profileCbo.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
profileCbo.setModel(model);
add(profileCbo, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 243, 71));

backBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
backBtn.setText("Back");
backBtn.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        backBtnActionPerformed(evt);
    }
    });
    add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 107, 41));
    }// </editor-fold>//GEN-END:initComponents

    /***************************************************************************
    *                            ----BEGIN BUTTON---
    ***************************************************************************/
    private void beginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginBtnActionPerformed
        
        if(profileCbo.getSelectedIndex() != 0){
            alertLbl.setText("");
            tempTheatre = null;
            String temp = profileCbo.getSelectedItem().toString();

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
            
            if(theatreObj.getVideo() != null){
                theatreObj.loadVideo();
            }
            if(theatreObj.getSong() != null){
                theatreObj.loadAudio();
            }
            if(theatreObj.getBGround() != null){
                theatreObj.loadBackground();
            }
            if(timeCbo.getSelectedIndex() != 0){
                int time = Integer.parseInt( (String)timeCbo.getSelectedItem() );
                theatreObj.setTime(time * 60);

                theatreObj.startTimer();
                theatreObj.openDialog();
                controller.showCard("THEATRE");
            } else {
                missingFields = "No minutes selected.";
                alertLbl.setText(missingFields);
            }
        } else {
            missingFields = "No profile selected.";
            alertLbl.setText(missingFields);
            missingFields = "";
        }
    }//GEN-LAST:event_beginBtnActionPerformed

    /***************************************************************************
    *                            ----BACK BUTTON---
    ***************************************************************************/
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        controller.showCard("MAIN_MENU");

    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JButton beginBtn;
    private javax.swing.JComboBox profileCbo;
    private javax.swing.JComboBox timeCbo;
    // End of variables declaration//GEN-END:variables
}
