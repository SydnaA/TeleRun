/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telerun;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Sydna Agnehs
 */
public class MainUser {
    int x, y, dx, dy;
    boolean sm, re;
    Image img;
    ImageIcon img2, img1;
    
    public MainUser() {
        img1=new ImageIcon(this.getClass().getResource("sprite_still.png"));
        img2=new ImageIcon(this.getClass().getResource("walking.gif"));
        
        img=img1.getImage();
        x=200;
        y=300;
        sm=false;
        re=false;
    }
    public void move() {
        x=x+dx;
        y=y+dy;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Image getImage() {
        return img;
    }
    public boolean getSM() {
        return sm;
    }
    public boolean getRE() {
        return re;
    }
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT) {
            dx=1;
            
        }
        if(key==KeyEvent.VK_LEFT) {
            dx=-1;
        }
        if(key==KeyEvent.VK_UP) {
            dy=-1;
        }
        if(key==KeyEvent.VK_DOWN) {
            dy=1;
          // img=img2.getImage();
        }
        if(key==KeyEvent.VK_S) {
            sm=true;
        }
        if(key==KeyEvent.VK_ENTER) {
            re=true;
        }
    }
    public void keyReleased(KeyEvent e) {
          int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT) {
            dx=0;
        }
        if(key==KeyEvent.VK_LEFT) {
            dx=0;
        }
        if(key==KeyEvent.VK_UP) {
            dy=0;
        }
        if(key==KeyEvent.VK_DOWN) {
            dy=0;
           // img=img1.getImage();
        }
        if(key==KeyEvent.VK_S) {
            sm=false;
        }
        if(key==KeyEvent.VK_ENTER) {
            re=false;
        }
    }
            
}
