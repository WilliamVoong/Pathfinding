import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int WIDTH=1500;
    public static int HEIGHT=1200;
    public static int SIZE=15;

    Window(){
        super();

        setSize(WIDTH,HEIGHT);
        setMinimumSize(getSize());
        setVisible(true);
        getContentPane().setLayout( new BoxLayout(getContentPane(),  BoxLayout.X_AXIS));
    }


}
