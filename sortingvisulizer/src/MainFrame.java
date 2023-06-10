import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class MainFrame extends JFrame implements MyCanvas.VisualizerProvider, ButtonPanel.SortButtonListener, Visualizer.SortedListener {
    public static final long serialVersionUID = 10L;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    private static final int WIDTH = 1280, HEIGHT = 720;
    private JPanel mainPanel, buttonPanel;
    private MyCanvas canvas;
    private Visualizer visualizer;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(WIDTH, HEIGHT + 200));
        setMinimumSize(new Dimension(WIDTH, HEIGHT + 20));
        setPreferredSize(new Dimension(WIDTH, HEIGHT + 20));
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(ColorManager.BACKGROUND);
        setTitle("Azamat Salamatov's Algorithm Visualizer");

        initialize();
    }

    private void initialize(){
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(ColorManager.BACKGROUND);
        add(mainPanel);

        // add buttons panel
        buttonPanel = new ButtonPanel(this);
        buttonPanel.setBounds(0, 150, 250, HEIGHT);
        buttonPanel.setBackground(ColorManager.BACKGROUND);
        mainPanel.add(buttonPanel);


        //add canvas
        canvas = new MyCanvas(this);
        int cWidth = WIDTH - 250 - 10;
        int cHeight = HEIGHT - 80;
        canvas.setFocusable(false);
        canvas.setMaximumSize(new Dimension(cWidth, cHeight));
        canvas.setMinimumSize(new Dimension(cWidth, cHeight));
        canvas.setPreferredSize(new Dimension(cWidth, cHeight));
        canvas.setBounds(250, 60, cWidth, cHeight);
        mainPanel.add(canvas);
        pack();

        visualizer = new Visualizer(50, 20, this);

    }

    // draw the array
    public void onDrawArray(){
        if (visualizer != null)
            visualizer.drawArray();
    }

    public void sortButtonClicked(int id){
        switch (id) {
            case 0:
                visualizer.createRandomArray(canvas.getWidth(), canvas.getHeight());
                break;
            case 1:
                visualizer.bubbleSort();
                break;
        }
    }

    public BufferStrategy getBufferStrategy(){
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null){
            canvas.createBufferStrategy(2);
            bs = canvas.getBufferStrategy();
        }

        return bs;
    }

}