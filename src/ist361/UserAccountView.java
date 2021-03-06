/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zach
 */
public class UserAccountView extends javax.swing.JFrame {

    /**
     * Creates new form AccountView
     */
    
    User currentUser;
    GoalCtrl ctrl;
    
    public UserAccountView(User user) throws IOException, FileNotFoundException, ClassNotFoundException {
        currentUser = user;
        ctrl = new GoalCtrl(currentUser);
        
        initComponents();
        jLabel2.setText("Username: " + currentUser.getUsername());
        
        File goalDirectory = new File("data/" + currentUser.getUsername() + "Goals.ser");
        
        if (!goalDirectory.exists()){
            
            CalorieLimit limit = new CalorieLimit(currentUser, 0);
            ExerciseGoal goal = new ExerciseGoal(currentUser, 0);
            ValueList vals = new ValueList(currentUser, limit, goal);
            ctrl.saveList(vals);
        }
        
        CalorieLimit limit = ctrl.getList().getCalorieLimit();
        cal.setText("Calorie Limit:     " + limit.getLimit() + " cals");
        
        ExerciseGoal goal = ctrl.getList().getExerciseGoal();
        exer.setText("Exercise Goal:   " + goal.getGoal() + " hours");
        
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
        jLabel2 = new javax.swing.JLabel();
        exer = new javax.swing.JLabel();
        cal = new javax.swing.JLabel();
        setCal = new javax.swing.JButton();
        setExer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Profile Information");

        jLabel2.setText("jLabel2");

        exer.setText("Exercise Goal");

        cal.setText("Calorie Limit");

        setCal.setText("Set Limit");
        setCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setCalActionPerformed(evt);
            }
        });

        setExer.setText("Set Goal");
        setExer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setExerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cal)
                            .addComponent(exer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(setExer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(setCal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cal)
                    .addComponent(setCal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exer)
                    .addComponent(setExer))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setCalActionPerformed
        String tempNum = JOptionPane.showInputDialog("Enter a new calorie limit (integer):");
        int cals = Integer.parseInt(tempNum);
        
        CalorieLimit newLimit = new CalorieLimit(currentUser, cals);
        
        try {
            ctrl.editCalories(newLimit);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        dispose();
        try {
            UserAccountView view = new UserAccountView(currentUser);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_setCalActionPerformed

    private void setExerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setExerActionPerformed
        String tempNum = JOptionPane.showInputDialog("Enter a new exercise goal (number of hours):");
        double hours = Double.parseDouble(tempNum);
        
        ExerciseGoal newGoal = new ExerciseGoal(currentUser, hours);
        
        try {
            ctrl.editExercise(newGoal);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        dispose();
        try {
            UserAccountView view = new UserAccountView(currentUser);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_setExerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cal;
    private javax.swing.JLabel exer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton setCal;
    private javax.swing.JButton setExer;
    // End of variables declaration//GEN-END:variables
}
