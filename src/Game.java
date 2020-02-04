import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class Game extends JFrame implements KeyListener, MouseMotionListener {
    boolean upPressed;
    Board board;
    int x,y;
    Point p;

    public Game(){


        setTitle("ASTEROIDS");

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board(this);
        add(board);
        addKeyListener(this);
        addMouseMotionListener(this);
        pack();

        board.setup();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args){

        new Game();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }

    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public int getX() {
        p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        return x;
    }

    @Override
    public int getY() {
        p = MouseInfo.getPointerInfo().getLocation();
        int y = p.y;
        return y;
    }

    public boolean isUpPressed() {
        return upPressed;
    }
}
