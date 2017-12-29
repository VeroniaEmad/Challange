/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Challange;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author ASUS
 */
public class Challange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        for (int i=0;i<100;i++)
        {  
        }
        
        JFrame jf=new JFrame();
        
        jf.setSize(600, 600);
                
        MovingRectangles mr=new MovingRectangles();
        mr.Rectangles.add(new Rectangle());
        mr.Rectangles.add(new Rectangle(100,100,40,Color.BLACK));
        mr.Rectangles.add(new Rectangle(160,160,35,Color.PINK));
        mr.Rectangles.add(new Rectangle(180,180,30,Color.MAGENTA));
        mr.Rectangles.add(new Rectangle(200,200,25,Color.CYAN));
        mr.Rectangles.add(new Rectangle(220,220,20,Color.RED));
        mr.Rectangles.add(new Rectangle(240,240,15,Color.YELLOW));
        mr.Rectangles.add(new Rectangle(260,260,10,Color.GREEN));
        mr.Rectangles.add(new Rectangle(280,280,5,Color.ORANGE));
        
        jf.add(mr,BorderLayout.CENTER);
        mr.setFocusable(true);
        Thread t1=new Thread(mr);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }


}
