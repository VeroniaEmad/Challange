/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Challange;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingRectangles extends JPanel implements Runnable{

   public ArrayList<Rectangle>Rectangles=new ArrayList<Rectangle>(5);
   public Tank BlueTank=new Tank("D:\\CsC\\csc2\\OOP\\Challange\\T.png");
    public MovingRectangles()
    {
        
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        this.addKeyListener(new keylist());
        
    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("Test");
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
                BlueTank.fireBullet2();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket2.pos2.x, BlueTank.Rocket2.pos2.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Rectangle OneRect: Rectangles)
        
        {
            g.setColor(OneRect.CurrentColor);
            g.fillRect(OneRect.x,OneRect.y, 50, 50);
            if (BlueTank.Rocket.pos.distance(OneRect.x, OneRect.y)<=50)
            {
                System.out.println("Hit Occurs" + OneRect.CurrentColor.toString());
                Rectangles.remove(OneRect);
                break;
                
            }
            
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Rectangle OneRect: Rectangles)
        {
            OneRect.move(this.getWidth());
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
