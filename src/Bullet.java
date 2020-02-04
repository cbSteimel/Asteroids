import java.awt.*;

public class Bullet {

    int x, y, diameter = 10;
    int speed, dx, dy = 10
            ;
    boolean remove;

    public Bullet(Player player){
        x = player.getxP();
        y =player.getyP();

        dx=(int)player.getDir1();
        dy=(int)player.getDir2();
        //for(int me=0;(dx<-10||dx>10)&&(dy<-10||dy>10);me++){
        //      dx*=2;
        //    dy*=2;
        //}
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
        g.fillOval(x, y, diameter, diameter);
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


