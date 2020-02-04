import javax.swing.*;
import java.awt.*;
;

public class Player {
    int[] xP;
    int[] yP;
    double x1,y1,r1,nx1,ny1,nx2,ny2,nx3,ny3,nx4,ny4,dis,fnum1,fnum2,slope,dir1,dir2;
    int mx,my;
    Game game;
    Board board;


    public Player(Board board){


        xP = new int[] { (board.getWidth()/2), (board.getWidth()/2)+13,(board.getWidth()/2),(board.getWidth()/2)-13,(board.getWidth()/2),(board.getWidth()/2)-5};
        yP = new int[] { (board.getHeight()/2),(board.getHeight()/2)+8 ,(board.getHeight()/2)-15,(board.getHeight()/2)+8,(board.getHeight()/2)+8 ,(board.getHeight()/2)-5};

    }


    public void Move(int x,int y) {

        my=y;
        mx=x;
        //System.out.println(xP[1]+","+yP[1]+"\n"+xP[2]+","+yP[2]+"\n"+xP[3]+","+yP[3]);
        if(x!=xP[4]||y!=yP[4]){
            // System.out.println(x + "," + y);
            // System.out.println(xP[4] + "," + yP[4]);
            dir1 = (x - (double) (xP[4])) / 50.0;
            dir2 = (y - (double) (yP[4])) / 50.0;
            x1 = (x - (double) (xP[4])) / 10;
            y1 = (y - (double) (yP[4])) / 10;
            // System.out.println(x1 + "," + y1);
            r1 = Math.sqrt((Math.pow(x1, 2) + Math.pow(y1, 2)));
            System.out.println(r1);

            if((r1>=5)) {
                if (x1 != 0 || y1 != 0) {
                    nx1 = ((x1 / r1) * 25) + xP[4];
                    ny1 = ((y1 / r1) * 25) + yP[4];
                    nx2 = ((y1 / r1) *11) + xP[4];
                    ny2 = ((x1 / r1) * -11) + yP[4];
                    nx3 = ((y1 / r1) * -11) + xP[4];
                    ny3 = ((x1 / r1) * 11) + yP[4];
                    nx4 = ((x1 / r1) * 5) + xP[4];
                    ny4 = ((y1 / r1) * 5) + yP[4];
                } else {
                    nx1 += xP[4];
                    ny1 += yP[4];
                    nx2 += xP[4];
                    ny2 += yP[4];
                    nx3 += xP[4];
                    ny3 += yP[4];
                }
            }/*
       System.out.println(fnum1+ "," + fnum2);

       nx2=fnum2+xP[0];
       ny2=(((x1/y1)*-1)*fnum2)+yP[0];
       nx3=((fnum1-fnum2)*2)+xP[0];
       ny3=(((x1/y1)*-1)*((fnum1-fnum2)*2))+yP[0];
       System.out.println(nx1+ "," + ny1+"\n"+nx2+ "," + ny2+"\n"+nx3+ "," + ny3);*/

            // int dir = ((x-xP[1])/(y-yP[1])*10);
            xP[1] = (int)nx2;
            xP[2] = (int) nx1;
            xP[3] = (int)nx3;
            xP[0] =(int)nx4;
            yP[1] = (int)ny2;
            yP[2] = (int) ny1;
            yP[3] = (int)ny3;
            yP[0] = (int)ny4;
            if (xP[3] + dir1 >= 0 && yP[2] + dir2 >= 0&&r1>=1) {

                xP[1] += dir1;
                xP[2] += dir1;
                xP[3] += dir1;
                xP[0] += dir1;
                xP[4] += dir1;
                xP[5]+=dir1;
                yP[1] += dir2;
                yP[2] += dir2;
                yP[3] += dir2;
                yP[0] += dir2;
                yP[4] += dir2;
                yP[5]+=dir2;
            }
            else{ //if(xP[3] + dir1 >= 0 && yP[2] + dir2 >= 0){
                xP[1] -= dir1;
                xP[2] -= dir1;
                xP[3] -= dir1;
                xP[0] -= dir1;
                xP[4] -= dir1;
                xP[5]-=  dir1;
                yP[1] -= dir2;
                yP[2] -= dir2;
                yP[3] -= dir2;
                yP[0] -= dir2;
                yP[4] -= dir2;
                yP[5]-=dir2;
            }

            // System.out.println(xP[1] + "," + yP[1] + "\n" + xP[2] + "," + yP[2] + "\n" + xP[3] + "," + yP[3] + "\n" + dir1 + "\n");

        }
    }



//    public Rectangle getBounds(){
    //      return new Rectangle(x,y,WIDTH,HEIGHT);
    //}

    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillPolygon(xP, yP, 4);


    }

    public int getxP() {
        return xP[5];
    }

    public int getyP() {
        return yP[5];
    }

    public double getDir1() {
        dir1 = ((mx - (double) (xP[0]))/20);
        if(dir1==0){
            dir1=1;
        }
        return dir1;
    }

    public double getDir2() {
        dir2 = ((my - (double) (yP[0]))/20);
        if(dir2==0){
            dir2=1;
        }
        return dir2;
    }

    public double getR1() {
        return r1;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }
}
