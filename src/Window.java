import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int WIDTH=1200;
    public static int HEIGHT=1200;
    public static int SIZE=15;

    Window(){
        super();
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        getContentPane().setLayout( new BoxLayout(getContentPane(),  BoxLayout.X_AXIS));
    }


}
