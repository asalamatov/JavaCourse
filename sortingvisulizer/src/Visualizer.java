import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Visualizer {
    private static final int PADDING = 20;
    private static final int MAX_BAR_HEIGHT = 350, MIN_BAR_HEIGHT = 30;
    private Integer[] array;
    private int capacity, speed;
    private Bar[] bars;
    private boolean hasArray;

    private Color originalColor, swappingColor, comparingColor;

    // drawing
    private BufferStrategy bs;
    private Graphics g;

    private SortedListener listener;

    public Visualizer(int capacity, int fps, SortedListener listener){
        this.capacity = capacity;
        this.speed = (int) (1000.0/fps);
        this.listener = listener;

        originalColor = ColorManager.BAR_WHITE;
        swappingColor = ColorManager.BAR_RED;
        comparingColor = Color.YELLOW;

        bs = listener.getBufferStrategy();

        hasArray = false;
    }

    public void createRandomArray(int canvasWidth, int canvasHeight){
        array = new Integer[capacity];
        bars = new Bar[capacity];
        hasArray = true;

        //initial position
        double x = PADDING;
        int y = canvasHeight - PADDING;

        //width of all bars
        double width = (double) (canvasWidth - PADDING*2)/capacity;

        //get graphics
        g = bs.getDrawGraphics();
        //clear the screen
        g.setColor(ColorManager.CANVAS_BACKGROUND);
        g.fillRect(0,0,canvasWidth, canvasHeight);

        Random rand = new Random();
        int value;
        Bar bar;
        for (int i = 0; i< array.length; i++){
            value =rand.nextInt(MAX_BAR_HEIGHT) + MIN_BAR_HEIGHT;
            array[i] = value;

            bar = new Bar((int) x, y, (int) width, value, originalColor);
            bar.draw(g);
            bars[i] = bar;

            //move to the next bar
            x += width;
        }

        bs.show();
        g.dispose();
    }

    //for restore purposes
    public void drawArray(){
        if (!hasArray) return;
        g = bs.getDrawGraphics();
        for (int i = 0; i < bars.length; i++){
            bars[i].draw(g);
        }

        bs.show();
        g.dispose();
    }

    /* Bubble Sort */
    public void bubbleSort(){
        if (!isCreated()){
            return;
        }

        g = bs.getDrawGraphics();

        int count = 0;
        for (int i = array.length - 1; i>=0; i--){
            count = 0;
            for (int j = 0; j<i; j++){
                if (array[j] > array[j+1]){
                    swap(j, j+1);
                    count++;
                }
            }

            bars[i].draw(g);
            bs.show();

            if (count == 0){
                break;
            }
        }
        g.dispose();
    }

    //swap 2 elements given 2 indices
    private void swap(int i, int j){
        //swap the elements
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        //clear the bars
        bars[i].clear(g);
        bars[j].clear(g);

        //swap the drawings
        bars[j].setValue(bars[i].getValue());
        bars[i].setValue(temp);

        colorPair(i, j, swappingColor);
    }

    private void colorPair(int i, int j, Color color){
        Color color1 = bars[i].getColor(), color2 = bars[j].getColor();
        //drawing
        bars[i].setColor(color);
        bars[i].draw(g);

        bars[j].setColor(color);
        bars[j].draw(g);

        bs.show();

        //delay
        try {
            TimeUnit.MILLISECONDS.sleep(speed);
        } catch (Exception e) {}

        //put back to original color
        bars[i].setColor(color1);
        bars[i].draw(g);
        bars[j].setColor(color2);
        bars[j].draw(g);

        bs.show();
    }

    private boolean isCreated(){
        return hasArray;
    }

    public interface SortedListener{
        BufferStrategy getBufferStrategy();
    }
}
