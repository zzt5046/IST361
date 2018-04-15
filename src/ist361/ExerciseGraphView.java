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
public class ExerciseGraphView {
    
    User currentUser;
    JFreeChart chart;
    
    public ExerciseGraphView(User currentUser, int type){
        
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
                               
                    chart = ChartFactory.createXYLineChart("Hours Over Time",
                            "Per Entry", "Hours", ds, PlotOrientation.VERTICAL, true, true, false);
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
                    
                    chart = ChartFactory.createBarChart("Hours Over Time", 
                            "Date", "Hours", ds, PlotOrientation.VERTICAL, true, true, false);
                    
                }

                ChartPanel cp = new ChartPanel(chart);
                frame.getContentPane().add(cp);
            }
        });

    }

    XYDataset createDatasetLine() throws IOException, FileNotFoundException, ClassNotFoundException {

        DefaultXYDataset ds = new DefaultXYDataset();
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        ArrayList<ExerciseEntry> entries = ctrl.getList(currentUser).getList();
        
        ArrayList<Double> hourData = new ArrayList<>();
        ArrayList<Double> counters = new ArrayList<>();
        
        for(int i = 0; i < entries.size(); i++){
            hourData.add((double) entries.get(i).getTime());
            counters.add((double) i);
        }
        
        double[] hourArray = new double[hourData.size()];
        for(int i = 0; i < hourArray.length; i++){
            hourArray[i] = hourData.get(i);
        }
        Arrays.sort(hourArray);
        
        double[] countArray = new double[counters.size()];
        for(int i = 0; i < countArray.length; i++){
            countArray[i] = counters.get(i);
        }
        Arrays.sort(countArray);

        
        double[][] data = {countArray, hourArray};
        ds.addSeries("Main", data);
        ds.addSeries("Top represents Hour Goal", setHourGoal());

        return ds;
    }
    
    double[][] setHourGoal() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        GoalCtrl goalCtrl = new GoalCtrl(currentUser);
        ArrayList<ExerciseEntry> entries = ctrl.getList(currentUser).getList();
        
        ArrayList<Double> goals = new ArrayList<>();
        ArrayList<Double> zeros = new ArrayList<>();
        
        for(int i = 0; i < entries.size(); i++){
            goals.add((double) goalCtrl.getList().getExerciseGoal().getGoal());
            zeros.add((double) 0);
        }
        
        double[] goalArray = new double[goals.size()];
        for(int i = 0; i < goalArray.length; i++){
            goalArray[i] = goals.get(i);
        }
        
        double[] zeroArray = new double[zeros.size()];
        for(int i = 0; i < zeroArray.length; i++){
            zeroArray[i] = zeros.get(i);
        }
        
        double[][] data = {zeroArray, goalArray};

        return data;
        
    }
    
    CategoryDataset createDatasetBar() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        ExerciseEntryCtrl ctrl = new ExerciseEntryCtrl(currentUser);
        ArrayList<ExerciseEntry> entries = ctrl.getList(currentUser).getList();
        
        for(int i = 0; i < entries.size(); i++){
            dataset.addValue(entries.get(i).getTime(), entries.get(i).getTitle(), entries.get(i).getDate());
        }
        
        return dataset;
    }
    
}
