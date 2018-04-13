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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Zach
 */
public class CalorieGraphView {
    
    User currentUser;
    
    public CalorieGraphView(User user, int type){
        
        this.currentUser = currentUser;
        SwingUtilities.invokeLater(new Runnable() {
            
            public void run() {
                JFrame frame = new JFrame("Charts");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                XYDataset ds = null;
                try {
                    ds = createDataset();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                JFreeChart chart = ChartFactory.createXYLineChart("Calories Over Time",
                        "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                        false);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });

    }

    private XYDataset createDataset() throws IOException, FileNotFoundException, ClassNotFoundException {

        DefaultXYDataset ds = new DefaultXYDataset();
        CalorieEntryCtrl ctrl = new CalorieEntryCtrl(currentUser);
        ArrayList<CalorieEntry> entries = ctrl.getList(currentUser).getList();
        
        double[] calData = null;
        double[] counters = null;
        
        for(int i = 0; i < entries.size(); i++){
            calData[i] = (double) entries.get(i).getCalories();
            counters[i] = (double) i;
        }
        
        double[][] data = {counters, calData};
        ds.addSeries("Main", data);

        return ds;
    }
}
