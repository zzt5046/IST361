/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

/**
 *
 * @author Zach
 */
public class CombinedGraphView {
    
    User currentUser;
    JFreeChart chart;
    JFreeChart chart2;
    
    public CombinedGraphView(User currentUser, int type){
        
        this.currentUser = currentUser;
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new JFrame("Combined Graph");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                CategoryDataset ds = null;  
                try {
                    ds = getDataset();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                chart = ChartFactory.createMultiplePieChart("All Data", ds, TableOrder.BY_COLUMN, true, true, false);

                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
                frame.setVisible(true);
            }
        });

    }
    
    CategoryDataset getDataset() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        ArrayList<ExerciseEntry> entries = ctrl.getList(currentUser).getList();
        
        CalorieEntryCtrl ctrl2 = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries2 = ctrl2.getList(currentUser).getList();
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0; i > entries.size(); i++){
            System.out.println(entries.get(i).getTime());
            dataset.addValue(entries.get(i).getTime(), entries.get(i).getTitle(), "Exercise");
        }
        
        for(int i = 0; i > entries2.size(); i++){
            dataset.addValue(entries2.get(i).getCalories(), entries2.get(i).getTitle(), "Calories");
        }
        
        return dataset;
    }  
}
