/**
 * AD 315 Assignment
 */

//import require classes and packages
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Main extends JPanel{
    //initialize coordinates
    int[] cord = {65, 20, 40, 80};
    int marg = 60;

    protected void paintComponent(Graphics grf){
        //create instance of the Graphics to use its methods
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D)grf;

        //Sets the value of a single preference for the rendering algorithms.
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // get width and height
        int width = getWidth();
        int height = getHeight();

        // draw graph
        graph.draw(new Line2D.Double(marg, marg, marg, height-marg));
        graph.draw(new Line2D.Double(marg, height-marg, width-marg, height-marg));

        //find value of x and scale to plot points
        double x = (double)(width-2*marg)/(cord.length-1);
        double scale = (double)(height-2*marg)/getMax();

        //set color for points
        graph.setPaint(Color.RED);

        // set points to the graph
        for(int i=0; i<cord.length; i++){
            double x1 = marg+i*x;
            double y1 = height-marg-scale*cord[i];
            graph.fill(new Ellipse2D.Double(x1-2, y1-2, 4, 4));
        }
    }

    //create getMax() method to find maximum value
    private int getMax(){
        int max = -Integer.MAX_VALUE;
        for(int i=0; i<cord.length; i++){
            if(cord[i]>max)
                max = cord[i];

        }
        return max;
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("AD 315 Assignment");
        //create an instance of JFrame class
        JFrame frame = new JFrame();
        // set size, layout and location for frame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main());
        frame.setSize(400, 400);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        //TODO: call each method and change plot


    }

    public static void coinToss() {
        int head = 0;
        int tail = 0;
        for(int i=0; i<100; i++) {
            int tossResult = (int) Math.floor(Math.random()*2);
            if (tossResult == 0) {
                head++;
            }else {
                tail++;
            }
        }
        System.out.println("In 100 times of coin toss, the number of head is " + head+ " and the number of tail is "+ tail + ".");
    }

    public static void rollDice() {
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
    }

    public static void drawCard() {
        int red = 0;
        int black = 0;
        for(int i=0; i<20; i++) {
            int tossResult = (int) Math.floor(Math.random()*2);
            if (tossResult == 0) {
                red++;
            }else {
                black++;
            }
        }
        System.out.println("Drawing cards");
    }

    public static void twoCoins() {
        int bothHead = 0 ;

    }

}