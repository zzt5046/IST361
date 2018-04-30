/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

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
            
                //create chart 1 ------------------------------------------------------------------
                JFrame frame = new JFrame("Exercise Graph");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                DefaultPieDataset ds = null;  
                try {
                    ds = getExerciseDataset();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                chart = ChartFactory.createPieChart("Hours", ds, true, true, false);

                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
                PiePlot plot = (PiePlot) chart.getPlot();
                plot.setNoDataMessage("No data available");
                frame.setVisible(true);
            
            //create chart 2----------------------------------------------------------------------
            JFrame frame2 = new JFrame("Calorie Data");
                frame2.setSize(800, 600);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                DefaultPieDataset ds2 = null;  
                try {
                    ds2 = getCalorieDataset();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                chart2 = ChartFactory.createPieChart("Calories", ds2, true, true, false);

                ChartPanel cp2 = new ChartPanel(chart2);
                frame2.getContentPane().add(cp2);
                PiePlot plot2 = (PiePlot) chart2.getPlot();
                plot2.setNoDataMessage("No data available");
                RefineryUtilities.centerFrameOnScreen(frame2);
                frame2.setVisible(true);
            
            }
        });

    }
    
    //get datasets
    public DefaultPieDataset getExerciseDataset() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        ArrayList<ExerciseEntry> entries = ctrl.getList(currentUser).getList();

        for(int i = 0; i < entries.size(); i++){
            dataset.setValue(entries.get(i).getTitle(), new Double(entries.get(i).getTime()));
        }
        
        return dataset;
    }
    
    DefaultPieDataset getCalorieDataset() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();

        for(int i = 0; i < entries.size(); i++){
            dataset.setValue(entries.get(i).getTitle(), new Double (entries.get(i).getCalories()));
        }
        
        return dataset;
    }  
}
