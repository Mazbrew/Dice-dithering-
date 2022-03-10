import java.util.Random;

public class Die {
    private int dieFace=1;

    public Die(int x,int y) throws Exception{
        ImageRead img = new ImageRead();
        int color = img.getPixelVal(x, y);
        double greyscale = ((double)(color & 0xff)+(double)((color & 0xff00) >> 8)+(double)((color & 0xff0000) >> 16))/3;
        System.out.println(greyscale);
        dieFace= (int)Math.ceil(((255-greyscale)/255)*6);
       
    }

    public void setdieFace(){
        Random rnd = new Random();
        dieFace=rnd.nextInt(6)+1;
    }

    public int getdieFace(){
        return dieFace;
    }
}
