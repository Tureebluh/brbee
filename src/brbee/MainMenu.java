package brbee;

/*******************************************************************************
*   Author: Jarek Thomas
* 
*   This is the main screen the user sees. Was thrown together mostly for
*   functionality atm. GUI needs to be done better for the program as a whole.
*******************************************************************************/

public class MainMenu extends javax.swing.JPanel {

    private Controller controller;
    private CreateProfile createProfile;
    
    public MainMenu(Controller controller, CreateProfile createProfile) {
        initComponents();
        this.controller = controller;
        this.createProfile = createProfile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        createBtn = new javax.swing.JButton();
        loadBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1285, 755));

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        jPanel1.setAlignmentY(0.5F);
        jPanel1.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        createBtn.setText("Create Profile");
        createBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createBtn.setMaximumSize(new java.awt.Dimension(200, 400));
        createBtn.setMinimumSize(new java.awt.Dimension(200, 100));
        createBtn.setPreferredSize(new java.awt.Dimension(200, 100));
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        jPanel1.add(createBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 150));

        loadBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        loadBtn.setText("Load Profile");
        loadBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loadBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadBtn.setMaximumSize(new java.awt.Dimension(200, 400));
        loadBtn.setMinimumSize(new java.awt.Dimension(200, 100));
        loadBtn.setPreferredSize(new java.awt.Dimension(200, 100));
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 200, 150));

        editBtn.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        editBtn.setText("Edit Profile");
        editBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setMaximumSize(new java.awt.Dimension(200, 400));
        editBtn.setMinimumSize(new java.awt.Dimension(200, 100));
        editBtn.setPreferredSize(new java.awt.Dimension(200, 100));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 200, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/brbee/images/BeeLogo.png"))); // NOI18N
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(564, 564, 564))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(140, 140, 140)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        
        controller.showCard(Controller.CREATE_PROFILE);
        
    }//GEN-LAST:event_createBtnActionPerformed

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        
        controller.showCard(Controller.LOAD_PROFILE);
        
    }//GEN-LAST:event_loadBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        
        
        controller.showCard(Controller.EDIT_PROFILE);
        
    }//GEN-LAST:event_editBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadBtn;
    // End of variables declaration//GEN-END:variables
}
