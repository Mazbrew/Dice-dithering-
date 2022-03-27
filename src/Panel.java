import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Panel extends JPanel implements MouseInputListener{
    private int size;
    
    private double dot=0;

    public Die dieMatrix[][];
    public int dieMatrixSize;
    public int offset;

    private int spriteOffset;

    private ImageRead img = new ImageRead();


    public Panel(int size,int dieMatrixSize) throws Exception{
        this.size = size;
        if(this.size==0){
            this.size=20*dieMatrixSize;
        }

        this.dieMatrixSize=dieMatrixSize;
        dieMatrix= new Die[dieMatrixSize][dieMatrixSize];
        
        for(int i=0;i<dieMatrixSize;i++){
            for(int j=0;j<dieMatrixSize;j++){
                dieMatrix[j][i]= new Die(j,i,img.getPixelVal(j, i));
            }
        }

        this.setFocusable(true);
        this.addMouseListener(this);
        this.setBounds(0,0,this.size,this.size);
        this.setVisible(true);
        
        offset=this.size/dieMatrixSize;
        dot=(this.size/7)/dieMatrixSize;
    }

    public void paint(Graphics g){
        g.setColor(new Color(255,255,255));
        g.fillRect(0, 0, size, size);
        paintDieMatrix(g);   
    }

    public void paintDieMatrix(Graphics g){
        g.setColor(new Color(0,0,0));    

        for(int i=0;i<dieMatrixSize;i++){
            for(int j=0;j<dieMatrixSize;j++){
                //Integer.toString(dieFace
                if(dieMatrix[j][i].getdieFace() <= 6){
                    g.setColor(new Color(255,255,255));
                    g.fillRect((int)j*offset, (int)i*offset, offset, offset);

                    int diceVal = dieMatrix[j][i].getdieFace();

                    g.setColor(new Color(0,0,0));   
                    if((diceVal & 1)>0){
                        g.fillRect((int)(j*offset+3*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                    }

                    if((diceVal>>1)>0){
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+1*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+5*dot),(int)dot,(int)dot);
                    }

                    if((diceVal>>2)>0){
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+1*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+5*dot),(int)dot,(int)dot);
                    }

                    if((diceVal & 6)==6){
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                    }
                }else if(dieMatrix[j][i].getdieFace() > 6){
                    g.setColor(new Color(0,0,0));
                    g.fillRect((int)j*offset, (int)i*offset, offset, offset);

                    int diceValInv= 12-(dieMatrix[j][i].getdieFace()-1);

                    g.setColor(new Color(255,255,255));   
                    if((diceValInv & 1)>0){
                        g.fillRect((int)(j*offset+3*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                    }

                    if((diceValInv>>1)>0){
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+1*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+5*dot),(int)dot,(int)dot);
                    }

                    if((diceValInv>>2)>0){
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+1*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+5*dot),(int)dot,(int)dot);
                    }

                    if((diceValInv & 6)==6){
                        g.fillRect((int)(j*offset+5*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                        g.fillRect((int)(j*offset+1*dot),(int)(i*offset+3*dot),(int)dot,(int)dot);
                    }
                }
            }
        }   
    }

    public int getDieMatrixSize(){
        return dieMatrixSize;
    }


    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        // for(int i=0;i<dieMatrixSize;i++){
        //     for(int j=0;j<dieMatrixSize;j++){
        //         dieMatrix[j][i].setdieFace();
        //     }
        // }
        // repaint();
        spriteOffset++;

        int xOffset =(spriteOffset*32)%img.getWidth(),
        yOffset=32*((spriteOffset*32)/img.getWidth());

        System.out.println(xOffset+" "+yOffset);

        for(int i=0;i<dieMatrixSize;i++){
            for(int j=0;j<dieMatrixSize;j++){
                dieMatrix[j][i].setdieFace(img.getPixelVal(xOffset+j, yOffset+i));
            }
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
