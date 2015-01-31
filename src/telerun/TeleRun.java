/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telerun;

import javax.swing.JFrame;

/**
 *
 * @author Sydna Agnehs
 */
public class TeleRun {
    
    /**
     * @param args the command line arguments
     */
    public TeleRun() {
        JFrame frame=new JFrame();
        frame.add(new Board());
        frame.setTitle("TeleRun");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new TeleRun();
    }
}
