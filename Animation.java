import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Animation {//class for updating animation frames

    private int speed, index;
    private long lastTime, timer;
    private ImageIcon[] frames;

    public Animation(int speed, ImageIcon[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
    }
    
    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 0;
        }
    }
    
    /*public BufferedImage getCurrentFrame(){
        return frames[index];
    }*/
    
}