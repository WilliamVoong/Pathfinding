

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
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

        int value=e.getModifiersEx();
        int Mouse1Mask= MouseEvent.BUTTON1;
        int Mouse2Mask= MouseEvent.BUTTON3_DOWN_MASK;
            setBackground(Color.BLACK);
            setMarker(MARKER.OBSTACLE.getCharVal());


        if( (Mouse2Mask & value) == Mouse2Mask){
            setBackground(Color.WHITE);
            setMarker(MARKER.EMPTY.getCharVal());
        }
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
        int value=e.getModifiersEx();
        int Mouse1Mask= MouseEvent.BUTTON1_DOWN_MASK;
        int Mouse2Mask= MouseEvent.BUTTON3_DOWN_MASK;

        if( (Mouse1Mask & value) == Mouse1Mask){
            setBackground(Color.BLACK);
            setMarker(MARKER.OBSTACLE.getCharVal());
        }
        value=e.getModifiersEx();
        System.out.println(value);
        if( (Mouse2Mask & value) == Mouse2Mask){
            setBackground(Color.WHITE);
            setMarker(MARKER.EMPTY.getCharVal());
        }

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
            setBackground(Color.BLUE);
        }
        else if (marker == MARKER.PATH.getCharVal()){
            setBackground(Color.LIGHT_GRAY);
        }
        else if (marker == MARKER.OBSTACLE.getCharVal()){
            setBackground(Obstacle.color);
        }
        else if (marker == MARKER.GOAL.getCharVal()){
            setBackground(Goal.color);
        }
        else if (marker == MARKER.EMPTY.getCharVal()){
            setBackground(Color.WHITE);
        }
    }
}