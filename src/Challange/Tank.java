/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Challange;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public Bullet2 Rocket2=new Bullet2();
    public int speed;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="D:\\CsC\\csc2\\OOP\\Challange\\fire.png";
        Rocket2.imgPath="D:\\CsC\\csc2\\OOP\\Challange\\fire.png";
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x-20;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
    public void fireBullet2() {
        Rocket2.pos2.x=this.pos.x+20;
        Rocket2.pos2.y=this.pos.y;
        Thread t2=new Thread (Rocket2);
        t2.start();
    }
}
