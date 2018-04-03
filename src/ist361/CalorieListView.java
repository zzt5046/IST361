/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zach
 */
public class CalorieListView extends javax.swing.JFrame {

    /**
     * Creates new form CalorieListView
     */
    User currentUser;
    JTable table;
    int calorieCount;
    
    public CalorieListView(User currentUser) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        this.currentUser = currentUser;
        initComponents();
        
        GoalCtrl goalCtrl = new GoalCtrl(currentUser);
        jLabel2.setText("Current Calorie Goal: " + goalCtrl.getList().getCalorieLimit().getLimit());
        
        DefaultTableModel tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Title");
        tablemodel.addColumn("Hours");
 
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();
        
        calorieCount = 0;
        for(int i = 0; i < entries.size(); i++){
            
            Object[] data = {entries.get(i).getTitle(), entries.get(i).getCalories()};
            tablemodel.addRow(data);
            calorieCount = calorieCount + entries.get(i).getCalories();
        }
        
        GoalCtrl ctrl2 = new GoalCtrl(currentUser);
        
        String endLine = "<html><b>CALORIES REMAINING</b></html>";
        int calorieLimit = ctrl2.getList().getCalorieLimit().getLimit();
        int remaining = calorieLimit - calorieCount;
        
        String remainingCalories = "";
        float percentage = (float) remaining / calorieLimit;
        System.out.println(percentage);
        
        if(percentage > 0.5){
            remainingCalories = "<html><b color='green'>" + remaining + "</b></html>";
        }
        else if(percentage < 0.5 && percentage > 0.25){
            remainingCalories = "<html><b color='orange'>" + remaining + "</b></html>";
        }
        else if(percentage < 0.25){
            remaining = remaining / -1;
            remainingCalories = "<html><b color='red'>Over limit +" + remaining + "</b></html>";
        }
        else{
            remainingCalories = "<html><b>" + remaining + "</b></html>";
        }
            
        Object[] closing = {endLine,remainingCalories};
        tablemodel.addRow(closing);
        
        table = new JTable(tablemodel);
        jScrollPane1.add(table);
        jScrollPane1.setViewportView(table);
        
        setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Calorie Entries");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jButton1.setText("View Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jButton2.setText("Clear Entries");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addGap(56, 56, 56))))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = null;
        
        try {
            entries = ctrl.getList(currentUser).getList();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        CalorieEntry entry = entries.get(table.getSelectedRow());
        CalorieDetailView details = new CalorieDetailView(entry);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        CalorieEntryList list;
                
        try {
            list = ctrl.getList(currentUser);
            list.getList().clear();
            ctrl.saveList(list);
            dispose();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
