import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
    
    public static BufferedImage sheet;

    public SpriteSheet(){
        try{
        	sheet = ImageIO.read(this.getClass().getResource("pacSheet.png"));;
        } catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
    }

    
    /** class for cropping spritesheet
     * @param x
     * @param y
     * @param w width
     * @param h height
     * @return bufferedImage
     */
    public BufferedImage crop(int x, int y, int w, int h){
        return sheet.getSubimage(x, y, w, h);
    }
}
