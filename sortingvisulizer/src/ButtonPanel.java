import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonPanel extends JPanel {
    public static final long serialVersionUID = 1L;
    private static final int BUTTON_WIDTH = 200, BUTTON_HEIGHT = 80;
    private JLabel[] buttons;
    private int number = 6;
    private SortButtonListener listener;

    public ButtonPanel(SortButtonListener listener){
        super();
        this.listener = listener;

        buttons = new JLabel[number];
        for (int i = 0; i<buttons.length; i++){
            buttons[i] = new JLabel();
        }

        initButtons(buttons[0], "create_button", 0);
        initButtons(buttons[1], "bubble_button", 1);
        initButtons(buttons[2], "selection_button", 2);
        initButtons(buttons[3], "insertion_button", 3);
        initButtons(buttons[4], "quick_button", 4);
        initButtons(buttons[5], "merge_button", 5);

        //add buttons to the panel
        setLayout(null);
        for (int i = 0; i< buttons.length; i++){
            buttons[i].setBounds(20, 20 + (BUTTON_HEIGHT + 5) * i, BUTTON_WIDTH, BUTTON_HEIGHT);
            add(buttons[i]);
        }
    }

    private void initButtons(JLabel button, String name, int id){
        button.setIcon(new ImageIcon(String.format("buttons/%s.png", name)));
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}


            @Override
            public void mousePressed(MouseEvent e) {
                button.setIcon(new ImageIcon(String.format("buttons/%s_pressed.png", name)));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // do the work
                button.setIcon(new ImageIcon(String.format("buttons/%s_entered.png", name)));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(new ImageIcon(String.format("buttons/%s_entered.png", name)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                listener.sortButtonClicked(id);
                button.setIcon(new ImageIcon(String.format("buttons/%s.png", name)));
            }
        });
    }

    public interface SortButtonListener{
        void sortButtonClicked(int id);
    }

}
