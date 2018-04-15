/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist361;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Zach
 */
public class CalorieGraphView {
    
    User currentUser;
    JFreeChart chart;
    
    public CalorieGraphView(User currentUser, int type){
        
        this.currentUser = currentUser;
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new JFrame("Your Generated Chart");            
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);

                if(type == 0){
                
                    XYDataset ds = null;
                    try {
                        ds = createDatasetLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                               
                    chart = ChartFactory.createXYLineChart("Calories Over Time",
                            "Per Entry", "Calories", ds, PlotOrientation.VERTICAL, true, true, false);
                }
                else if (type == 1){
                    
                    CategoryDataset ds = null;
                    try {
                        ds = createDatasetBar();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    
                    chart = ChartFactory.createBarChart("Calories Over Time", 
                            "Date", "Calories", ds, PlotOrientation.VERTICAL, true, true, false);
                    
                }

                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
            }
        });

    }

    XYDataset createDatasetLine() throws IOException, FileNotFoundException, ClassNotFoundException {

        DefaultXYDataset ds = new DefaultXYDataset();
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();
        
        ArrayList<Double> calData = new ArrayList<>();
        ArrayList<Double> counters = new ArrayList<>();
        
        for(int i = 0; i < entries.size(); i++){
            calData.add((double) entries.get(i).getCalories());
            counters.add((double) i);
        }
        
        double[] calArray = new double[calData.size()];
        for(int i = 0; i < calArray.length; i++){
            calArray[i] = calData.get(i);
        }
        Arrays.sort(calArray);
        
        double[] countArray = new double[counters.size()];
        for(int i = 0; i < countArray.length; i++){
            countArray[i] = counters.get(i);
        }
        Arrays.sort(countArray);

        
        double[][] data = {countArray, calArray};
        ds.addSeries("Main", data);
        ds.addSeries("Top represents Calorie Limit", setCalorieLimit());

        return ds;
    }
    
    double[][] setCalorieLimit() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        GoalCtrl goalCtrl = new GoalCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();
        
        ArrayList<Double> limits = new ArrayList<>();
        ArrayList<Double> zeros = new ArrayList<>();
        
        for(int i = 0; i < entries.size(); i++){
            limits.add((double) goalCtrl.getList().getCalorieLimit().getLimit());
            zeros.add((double) 0);
        }
        
        double[] limArray = new double[limits.size()];
        for(int i = 0; i < limArray.length; i++){
            limArray[i] = limits.get(i);
        }
        
        double[] zeroArray = new double[zeros.size()];
        for(int i = 0; i < zeroArray.length; i++){
            zeroArray[i] = zeros.get(i);
        }
        
        double[][] data = {zeroArray, limArray};

        return data;
        
    }
    
    CategoryDataset createDatasetBar() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();
        
        for(int i = 0; i < entries.size(); i++){
            dataset.addValue(entries.get(i).getCalories(), entries.get(i).getTitle(), entries.get(i).getDate());
        }
        
        return dataset;
    }
}
