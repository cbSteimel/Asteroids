import javax.management.monitor.GaugeMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {
    Player player;
    Long timeDelay;
    Timer timer;
    int x, y,num1,num2;
    Game game;
    Asteroids asteroids = new Asteroids();
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    Asteroids[] asteroid=new Asteroids[5];
    //Asteroids[] asteroid=new Asteroids[num1];


    public Board(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(1024, 700));
        setBackground(Color.BLACK);

        timer = new Timer(1000 / 100, this);
        timer.start();


    }


    public void setup() {
        player = new Player(this);
        timeDelay = System.currentTimeMillis();
        num1=5;

        for(int i = 0; i>=num1;i++){
            asteroid[i]=new Asteroids(this);
        }
    }

    public void checkCollisions() {

    }

    public void actionPerformed(ActionEvent e) {
        long currentTime = System.currentTimeMillis();
        x = game.getX();
        y = game.getY();
        // if((currentTime-timeDelay)>=){
        player.Move(x, y);
        //   timeDelay = System.currentTimeMillis();
        //}
        for(int i = 0; i>=num1;i++){
            asteroid[i].move();
        }
        if (game.isUpPressed() && (currentTime - timeDelay) >= 250&&player.getR1()>=7) {
            bullets.add(new Bullet(player));

            timeDelay = System.currentTimeMillis();
        }

        for (Bullet bullet : bullets) {
            bullet.move();
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        long currentTime = System.currentTimeMillis();
        super.paintComponent(g);
        player.paint(g);
        for(int i = 0; i>=num1;i++){
            asteroid[i].paint(g);
        }
        for (Bullet bullet : bullets) {
            bullet.paint(g);
        }

    }


    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g) {
        int stringLen = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
        int start = width / 2 - stringLen / 2;
        g.drawString(s, start + XPos, YPos);
    }


}

