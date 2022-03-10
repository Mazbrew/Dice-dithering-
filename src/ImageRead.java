import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageRead{
    BufferedImage img = ImageIO.read(new File("suki.png"));
    public ImageRead() throws Exception{
        

        for(int i=0;i<img.getHeight();i++){
            for(int j=0;j<img.getWidth();j++){

            }
        }
    }

    public int getPixelVal(int x,int y){
        return img.getRGB(x,y);
    }
}
