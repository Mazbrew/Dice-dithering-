import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Frame extends JFrame{
    public Frame(Panel panel){
        super();
        this.setLayout(null);
        this.getContentPane().setPreferredSize(new Dimension(panel.getSize().width,panel.getSize().height));
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-panel.getSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/2-panel.getSize().height/2);
        this.setUndecorated(false);
        this.pack();
        this.setTitle("Die dithering");
        this.setResizable(false);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
}
