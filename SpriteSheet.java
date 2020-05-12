import java.awt.image.BufferedImage;

public class SpriteSheet {
    
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
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
