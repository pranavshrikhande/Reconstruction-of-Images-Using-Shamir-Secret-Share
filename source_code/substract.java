import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class substract {

	public static void main(String[] args) throws Exception {
		
		//BufferedImage img = null;
		File f = null;
		f= new File("C:\\Users\\Pranav\\Desktop\\question_3\\pranav_1.jpg");
		
		File f2= null;
		f2= new File("C:\\Users\\Pranav\\Desktop\\question_3\\pranav.jpg");
		
		
       
        BufferedImage image1 = ImageIO.read(f);
        BufferedImage image2 = ImageIO.read(f2);
        BufferedImage image3 = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
        int color;
        for(int x = 0; x < image1.getWidth(); x++)
            for(int y = 0; y < image1.getHeight(); y++) {
                color = Math.abs(image2.getRGB(x, y) - image1.getRGB(x, y));                
                image3.setRGB(x, y, color);
            }
        ImageIO.write(image3, "jpg",  new File("C:\\Users\\Pranav\\Desktop\\question_3\\pixel.jpg"));

	
}
}