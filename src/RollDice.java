import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class RollDice extends JFrame {

    private static final long serialVersionUID = 1L;

    public RollDice(String appTitle) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Roll a Die 60 Times", //Chart Title
                "Result", // Category axis
                "Time", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Roll a die 60 times
        int result1=0;
        int result2=0;
        int result3=0;
        int result4=0;
        int result5=0;
        int result6=0;
        for(int i=0; i<60; i++) {
            int resultToss = (int) Math.floor(Math.random()*6);
            switch (resultToss) {
                case 0:
                    result1++;
                    break;
                case 1:
                    result2++;
                    break;
                case 2:
                    result3++;
                    break;
                case 3:
                    result4++;
                    break;
                case 4:
                    result5++;
                    break;
                default:
                    result6++;
            }
        }
        System.out.println("In 60 times of six-sided dice rolling, the results are as below.");
        System.out.println("Side 1 has " + result1 + " times.");
        System.out.println("Side 2 has " + result2 + " times.");
        System.out.println("Side 3 has " + result3 + " times.");
        System.out.println("Side 4 has " + result4 + " times.");
        System.out.println("Side 5 has " + result5 + " times.");
        System.out.println("Side 6 has " + result6 + " times.");

        dataset.addValue(result1, "1", "1");
        dataset.addValue(result2, "2", "2");
        dataset.addValue(result3, "3", "3");
        dataset.addValue(result4, "4", "4");
        dataset.addValue(result5, "5", "5");
        dataset.addValue(result6, "6", "6");


        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            RollDice example=new RollDice("Bar Chart Window");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}  