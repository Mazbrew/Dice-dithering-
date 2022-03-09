import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Panel extends JPanel implements MouseInputListener{
    private int size;
    private int dieFace=1;
    private double tile=0;

    public Panel(int size){
        this.setFocusable(true);
        this.addMouseListener(this);
        this.size = size;
        this.setBounds(0,0,size,size);
        this.setVisible(true);
        
        tile=size/7;
    }

    public void paint(Graphics g){
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, size, size);
        paintDie(g);
        g.drawString("iterator", 0, 0);
        
    }

    public void paintDie(Graphics g){
        
        g.setColor(new Color(0,0,0));    

        g.setColor(new Color(0,0,0));
        //Integer.toString(dieFace
        if((dieFace & 1)>0){
            g.fillRect((int)(3*tile),(int)(3*tile),(int)tile,(int)tile);
        }

        if((dieFace>>1)>0){
            g.fillRect((int)(5*tile),(int)(1*tile),(int)tile,(int)tile);
            g.fillRect((int)(1*tile),(int)(5*tile),(int)tile,(int)tile);
        }

        if((dieFace>>2)>0){
            g.fillRect((int)(1*tile),(int)(1*tile),(int)tile,(int)tile);
            g.fillRect((int)(5*tile),(int)(5*tile),(int)tile,(int)tile);
        }

        if((dieFace & 6)==6){
            g.fillRect((int)(5*tile),(int)(3*tile),(int)tile,(int)tile);
            g.fillRect((int)(1*tile),(int)(3*tile),(int)tile,(int)tile);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        dieFace++;
        if(dieFace>6){
            dieFace=1;
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
