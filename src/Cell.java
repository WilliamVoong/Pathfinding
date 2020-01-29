

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;

public class Cell extends JPanel implements MouseListener {
    private char marker;
    Cell(){
        super();
        addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        setBackground(Color.BLACK);
        setMarker(MARKER.OBSTACLE.getCharVal());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(marker);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("ExitSquared");
    }

    public char getMarker() {
        return marker;
    }
    public void setMarkerDelay(char marker){
        this.marker=marker;
        Timer t=new Timer(10000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateColor();
            }

        });
        t.start();

    }
    public void setMarker(char marker){
        this.marker=marker;
        UpdateColor();
    }

    public void UpdateColor(){

        if(marker == MARKER.PLAYER.getCharVal()){
            setBackground(Player.color);
        }
        else if (marker == MARKER.PATH.getCharVal()){
            setBackground(Player.color);
        }
        else if (marker == MARKER.OBSTACLE.getCharVal()){
            setBackground(Obstacle.color);
        }
        else if (marker == MARKER.GOAL.getCharVal()){
            setBackground(Goal.color);
        }
    }
}