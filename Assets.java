import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class Assets {
    private static final int width = 30, height = 30;
	
	public static SpriteSheet sheet = new SpriteSheet();
    
	public static ImageIcon medPocMan1 = new ImageIcon(sheet.crop(79, 53, 30, 30));
	public static ImageIcon medPocMan2 = new ImageIcon(sheet.crop(111, 53, 27, 30));
	public static ImageIcon medPocMan3 = new ImageIcon(sheet.crop(141, 53, 22, 30));
	
	public static ImageIcon apple = new ImageIcon(sheet.crop(8, 12, 12, 12));
	public static ImageIcon bananas = new ImageIcon(sheet.crop(23, 11, 15, 15));
	public static ImageIcon donut = new ImageIcon(sheet.crop(39, 11, 15, 14));
	public static ImageIcon burger = new ImageIcon(sheet.crop(55, 12, 14, 12));
	public static ImageIcon cake = new ImageIcon(sheet.crop(55, 27, 14, 16));

	
	public static ImageIcon fruits[] = {apple, bananas, donut, burger, cake};
    
    public static BufferedImage pocman, ghost, pellet, superPellet, board;
    
    public static void init(){
        pocman = sheet.crop(-109, -53, width, height);
        ghost = sheet.crop(-166, -53, width, height);
        pellet = sheet.crop(-47, -47, 5, 5);
        superPellet = sheet.crop(-30, -120, 7, 7);
        board = sheet.crop(-312, -4, 183, 200);
    }

}