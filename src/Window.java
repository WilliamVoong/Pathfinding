import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    public static int WIDTH=1500;
    public static int HEIGHT=1200;
    public static int SIZE=15;
    Timer t= new Timer(100, this);

    Window(){
        super();

        setSize(WIDTH,HEIGHT);
        setMinimumSize(getSize());
        setVisible(true);
        getContentPane().setLayout( new BoxLayout(getContentPane(),  BoxLayout.X_AXIS));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        System.out.println("hej");

    }

    public void draw(){

        t.start();
    }
}
