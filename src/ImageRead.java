import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageRead{
    BufferedImage img;
    public ImageRead() throws Exception{
        img = ImageIO.read(new File("gen5.tif"));
    }

    public int getWidth(){
        return img.getWidth();
    }

    public int getheight(){
        return img.getHeight();
    }

    public int getPixelVal(int x,int y){
        return img.getRGB(x,y);
    }
}
