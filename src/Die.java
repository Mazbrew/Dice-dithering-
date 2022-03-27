public class Die {
    private int dieFace=1;

    public Die(int x,int y, int color) throws Exception{
        double greyscale=0;


        if((color>>24)==0x00){
            dieFace=0;
        }else{
            greyscale= ((double)(color & 0xff)+(double)((color & 0xff00) >> 8)+(double)((color & 0xff0000) >> 16))/3;
            if(dieFace==0){
                dieFace=1;
            }
            dieFace= (int)Math.ceil(((255-greyscale)/255)*12); 
        }
    }

    public void setdieFace(){
        if(++dieFace>12){
            dieFace=1;
        }
    }

    public void setdieFace(int color){
        double greyscale=0;

        if((color>>24)==0x00){
            dieFace=0;
        }else{
            greyscale= ((double)(color & 0xff)+(double)((color & 0xff00) >> 8)+(double)((color & 0xff0000) >> 16))/3;
            if(dieFace==0){
                dieFace=1;
            }
            dieFace= (int)Math.ceil(((255-greyscale)/255)*12); 
        }
    }

    public int getdieFace(){
        return dieFace;
    }
}
