import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class CoinToss extends JFrame {

    private static final long serialVersionUID = 1L;

    public CoinToss(String appTitle) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Toss a Coin 100 Times", //Chart Title
                "Result", // Category axis
                "Number of result", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int head=0;
        int tail=0;
        for(int i=0; i<100; i++) {
            int tossResult = (int) Math.floor(Math.random()*2);
            if (tossResult == 0) {
                head++;
            }else {
                tail++;
            }
        }
        // Population in 2005
        dataset.addValue(head, "Head", String.valueOf(head));
        dataset.addValue(tail, "tail", String.valueOf(tail));

        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            CoinToss example=new CoinToss("Coin Toss");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}