import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

// holds the crop image of spritesheet
public class Assets {
	public static SpriteSheet sheet = new SpriteSheet();
    
	public static ImageIcon mediumPocMan = new ImageIcon(sheet.crop(111, 53, 27, 30));
	
    private static final int width = 30, height = 30;
    
    public static BufferedImage pocman, ghost, pellet, superPellet, fruit, board;
    
    public static void init(){
        pocman = sheet.crop(-109, -53, width, height);
        ghost = sheet.crop(-166, -53, width, height);
        fruit = sheet.crop(-8,-12,12,12);
        pellet = sheet.crop(-47, -47, 5, 5);
        superPellet = sheet.crop(-30, -120, 7, 7);
        board = sheet.crop(-312, -4, 183, 200);
    }

}