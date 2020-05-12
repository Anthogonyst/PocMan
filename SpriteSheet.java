import java.awt.image.BufferedImage;

public class SpriteSheet {
    
    private BufferedImage sheet;

    public SpriteSheet(bufferedImage sheet){
        this.sheet = sheet;
    }

    
    /** class for cropping spritesheet
     * @param x
     * @param y
     * @param w width
     * @param h height
     * @return bufferedImage
     */
    public bufferedImage crop(int x, int y, int w, int h){
        return sheet.getSubimage(x, y, w, h);
    }
}
