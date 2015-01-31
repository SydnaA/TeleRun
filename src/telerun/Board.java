/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telerun;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Sydna Agnehs
 */
public class Board extends JPanel implements ActionListener {
    MainUser user1;
    public Image img, obj_1, obj_2;
    Timer time;
    int x;
    boolean game=true;
    boolean slow=false;
    int score;
    int obj_1_x, obj_1_y, delay, power, asdasd, dsa, obj_2_y, obj_2_x, obj_3_x, obj_3_y, obj_4_x, obj_4_y;
    public Board() {
        user1=new MainUser();
        this.addKeyListener(new actL());
        this.setFocusable(true);
        ImageIcon img1=new ImageIcon(this.getClass().getResource("background.png"));
        ImageIcon img2=new ImageIcon(this.getClass().getResource("New_body_A.png"));
        
        obj_2=img2.getImage();
        obj_1=img2.getImage();
        img=img1.getImage();
        
        time=new Timer(5, this);
        time.start();
        score=0;
        obj_1_y=0;
        delay=0;
        power=5000;
        obj_1_x=ranX();
        obj_2_y=ranY();
        obj_2_x=0;
        asdasd=0;
    }
    public void actionPerformed(ActionEvent e) {
        collision();
        checkonScreen();
        user1.move();
        score++;
        
       // System.out.println(score);
        delay++;
        if(delay==2) {
            delay=0;
            obj_1_y++;
        }
        //System.out.println(power+"  "+user1.getSM());
    
        incrementionCube();
        slowMotion();
        //System.out.println(user1.getSM());
        repaint();
        if(game==false) {
        if(user1.getRE()==true)
            restart();
        }
        //System.out.println(user1.getRE());
    }
    
    public void incrementionCube() {
          if(user1.getSM()==true&&power>4) {
        }
        else
        {
            obj_2_x++;
            if(score>=1000) {
                dsa=(int)(score/1000);

                    if(score/1000>=5)
                        dsa=4;

                    for(int x=0;x<dsa;x++) {
                        obj_1_y++;
                        }
            }
        }
    }
    
    
    
    
    public void restart() {
        
        score=0;
        obj_1_y=0;
        delay=0;
        power=5000;
        obj_1_x=200;
        game=true;
        slow=false;
        user1=new MainUser();
        //time.setDelay(5);
        
        
    }    
    
    
    public void sideStuff() {
        
    }   
    
    public void checkonScreen() {
        if(obj_1_y>600) {
            obj_1_x=ranX();
            obj_1_y=0;
        }  
        if(obj_2_x>400) {
            obj_2_y=ranY();
            obj_2_x=0;
        }
    }
    
    public void slowMotion() {
        if(user1.getSM()==false) {
            
         if(power<=4999)
         power=power+2;
            
        }
        else
        {
            if(power>4)
        power=power-5;
        }
    }
    
    public int getScore() {
        if(game==true)
            asdasd=score;
        return asdasd;
    }
    
    public void collision() {
        if((obj_1_x+6>=user1.getX())&&((obj_1_x<=(user1.getX()+20))))
            if((obj_1_y+6>=user1.getY())&&((obj_1_y<=(user1.getY()+53))))
             game=false;  
        
        if(user1.getY()+53>=600||user1.getY()<=0||user1.getX()+20>=400||user1.getX()<=0)
            game=false;

        if((user1.getX()>=obj_2_x)&&(user1.getX()<=obj_2_x+6))
           if((user1.getY()>=obj_2_y)&&(user1.getY()+53<=obj_2_y+6))
               game=false;
        
        //System.out.println(obj_1_x+"  "+obj_1_y+"       "+(user1.getX()+20)+"  "+user1.getY());
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        int scores=getScore();
        if(game==true) {
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(img, 0, 0, null);
        g2d.drawImage(obj_1, obj_1_x, obj_1_y, null);
        g2d.drawImage(obj_2, obj_2_x, obj_2_y, null);
        g2d.drawImage(user1.getImage(), user1.getX(), user1.getY(), null);
        }
        else
        {
        
        String msg = "Score: " + scores;
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics met = this.getFontMetrics(small);
        g.setColor(Color.BLUE);
        g.setFont(small);
        g.drawString(msg, ((400 - met.stringWidth(msg))/2), (600/2)-20);
        
        }
    }
    
    public int ranX() {
        
        int a=(int)(400*Math.random()+1);
        return a;
    }
    
    public int ranY() {
        
        int a=(int)(600*Math.random()+1);
        return a;
    }
    
    
    private class actL extends KeyAdapter{
        public void keyReleased(KeyEvent e) {
            user1.keyReleased(e);
                   
            
        }
        public void keyPressed(KeyEvent e) {
            user1.keyPressed(e);
        }
    }
}
