import java.awt.image.BufferedImage;

// holds the crop image of spritesheet
public class Assets {
    
    private static final int width = 30, height = 30;

    public static BufferedImage pocman, ghost, pellet, superPellet, fruit, board;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/pacSheet.png"));

        pocman = sheet.crop(-109, -53, width, height);
        ghost = sheet.crop(-166, -53, width, height);
        fruit = sheet.crop(-8,-12,12,12);
        pellet = sheet.crop(-47, -47, 5, 5);
        superPellet = sheet.crop(-30, -120, 7, 7);
        board = sheet.crop(-312, -4, 183, 200);
    }

}