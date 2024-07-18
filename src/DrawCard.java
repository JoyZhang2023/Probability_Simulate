import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawCard extends JFrame {

    private static final long serialVersionUID = 1L;

    public DrawCard(String appTitle) {
        super(appTitle);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Draw 20 cards", //Chart Title
                "Red or Black", // X axis
                "Times", // Y axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Draw Cards
        List<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2" , "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Create a deck of cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        int redCount = 0;
        int blackCount = 0;

        // Drawing 20 cards
        for (int i=0; i<20; i++) {
            String card = deck.get(i);
            if (card.contains("Hearts") || card.contains("Diamonds")) {
                redCount++;
            } else {
                blackCount++;
            }
        }

        System.out.println("Drawing 20 cards");
        System.out.println("The number of red card drawn is " + redCount + " .");
        System.out.println("The number of black card drawn is " + blackCount + " .");

        dataset.addValue(redCount, "Red", String.valueOf(redCount));
        dataset.addValue(blackCount, "Black", String.valueOf(blackCount));


        return dataset;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(()->{
            DrawCard example=new DrawCard("Bar Chart Window");
            example.setSize(400, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
