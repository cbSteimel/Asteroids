import java.awt.*;

public class Asteroids {
    int x, y, diameter = 50;
    int speed, dx, dy = 10,rNum1,rNum2;
    boolean remove;

    public Asteroids(){

    }
    public Asteroids(Board board) {
        rNum1 = (int) ((Math.random()) * (4.0) + 1.0);

        if (rNum1 == 1) {
            y = -50;
            x = (int) ((Math.random()) * (board.getWidth()));

            if (x <= board.getWidth() / 2) {
                rNum2 = (int) ((Math.random()) * (2.0) + 1.0);

                if (rNum2 == 1) {
                    dx = (int) ((Math.random()) * (10) + 1.0);
                    dy = 1;
                }

                else {
                    dy = (int) ((Math.random()) * (10) + 1.0);
                    dx = 1;
                }
            }

            else {
                rNum2 = (int) ((Math.random()) * (2.0) + 1.0);
                if (rNum2 == 1) {
                    dx = -(int) ((Math.random()) * (10) + 1.0);
                    dy = 1;
                }

                else {
                    dy = (int) ((Math.random()) * (10) + 1.0);
                    dx = -1;
                }
            }
        }

        if (rNum1 == 2) {
            x = -50;
            y = (int) ((Math.random()) * (board.getHeight()));
            if (y <= board.getWidth() / 2) {
                rNum2 = (int) ((Math.random()) * (2.0) + 1.0);
                if (rNum2 == 1) {
                    dx = (int) ((Math.random()) * (10) + 1.0);
                    dy = 1;
                } else {
                    dy = (int) ((Math.random()) * (10) + 1.0);
                    dx = 1;
                }
            } else {
                rNum2 = (int) ((Math.random()) * (2.0) + 1.0);
                if (rNum2 == 1) {
                    dx = (int) ((Math.random()) * (10) + 1.0);
                    dy = -1;
                } else {
                    dy = -(int) ((Math.random()) * (10) + 1.0);
                    dx = 1;
                }
            }
        }

        if (rNum1 == 3) {
            x = board.getWidth() + 50;
            y = (int) ((Math.random()) * (board.getHeight()));
            if (y <= board.getHeight() / 2) {
                rNum2 = (int) ((Math.random()) * (2.0) + 1.0);
                if (rNum2 == 1) {
                    dx = -(int) ((Math.random()) * (10) + 1.0);
                    dy = 1;
                } else {
                    dy = (int) ((Math.random()) * (10) + 1.0);
                    dx = -1;
                }
            }
            else{
                rNum2=(int)((Math.random())*(2.0) + 1.0);
                if(rNum2==1){
                    dx=-(int)((Math.random())*(10) + 1.0);
                    dy=-1;
                }
                else{
                    dy=-(int)((Math.random())*(10) + 1.0);
                    dx=-1;
                }
            }
        }

        if (rNum1 == 4) {
                y = board.getHeight()+50;
                x = (int) ((Math.random()) * (board.getWidth()));
                if (x <= board.getWidth() / 2) {
                    rNum2 = (int) ((Math.random()) * (2.0) + 1.0);
                    if (rNum2 == 1) {
                        dx = (int) ((Math.random()) * (10) + 1.0);
                        dy = -1;
                    } else {
                        dy = -(int) ((Math.random()) * (10) + 1.0);
                        dx = 1;
                    }
                }
                else{
                    rNum2=(int)((Math.random())*(2.0) + 1.0);
                    if(rNum2==1){
                        dx=-(int)((Math.random())*(10) + 1.0);
                        dy=-1;
                    }
                    else{
                        dy=-(int)((Math.random())*(10) + 1.0);
                        dx=-1;
                    }
                }
            }
        }



    public void move(){
        y+=(dy*2);
        x+=(dx*2);
    }
    public void moveEnemy(){
        y+=2;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,diameter,diameter);
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawOval(x, y, diameter, diameter);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public boolean getRemove() {
        return remove;
    }

    public void setRemove() {
        remove = true;
    }
}

