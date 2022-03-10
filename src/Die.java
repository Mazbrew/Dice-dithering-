import java.util.Random;

public class Die {
    private int dieFace=1;

    public Die(){
        
    }

    public void setdieFace(){
        Random rnd = new Random();
        dieFace=rnd.nextInt(6)+1;
    }

    public int getdieFace(){
        return dieFace;
    }
}
