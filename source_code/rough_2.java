import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

import javax.imageio.ImageIO;


//	import shamir_1.SecretShare_1;

//import shamir_1.SecretShare_1;

public class rough_2 {
	final static shamir_1.SecretShare_1[] shares_1=null;

	public static void main(String[] args) {

		long cpuTime = System.nanoTime();				// to plot time
	    long wallClockTime = System.currentTimeMillis();
		
		BufferedImage img = null;
		File f = null;

		//read image
		try{
			//f= new File("./img/mountain.bmp");
			f = new File("./img/output.jpg");
			img = ImageIO.read(f);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width = img.getWidth();
		int height = img.getHeight();

		//  int[] myArray = new int[width * height *3];

		int count = 0;

		int[] myArray = new int[width * height *3];
		//int[] myArray_red = new int[width * height *3];

		for(int i=0; i<height ; i++)
		{
			for(int j=0; j<width ; j++)
			{

				Color c = new Color(img.getRGB(j, i));


				// myArray_red[i] = c.getRed();

				int  red = c.getRed();
				int blue = c.getBlue();
				int green = c.getGreen();

				myArray[count++] = red;
				myArray[count++] = green;
				myArray[count++] = blue;

			}
		}


		shamir_1 scheme = new shamir_1(3, 5);

		int[][] x = new int[5][myArray.length];

		for(int i=0; i< myArray.length;i++) {


			final BigInteger secret_1 = BigInteger.valueOf(myArray[i]);
			final shamir_1.SecretShare_1[] shares_1 = scheme.split(secret_1);

			for(int j=0;j<5;j++)
			{

				x[j][i] = shares_1[j].getShare_1().intValue(); 

			}
			//final BigInteger prime_1 = scheme.getPrime();
			//final shamir_1 scheme2 = new shamir_1(3,5);
			//final BigInteger prime2 = BigInteger.valueOf(prime_1.intValue());

			//final BigInteger result_1 = scheme2.combine(shares_1, prime2);
			//	System.out.println(shares_1[0].getShare_1());
		}

		//    	System.out.println(shares_1.intValue());



		//for(int i=0; i< myArray.length;i++)
		//	{

		//  }

		System.out.println(x[1][0]);
		System.out.println(x[1][1]);


		// Image file dimensions

		// Create buffered image object
		BufferedImage img_1 = null;
		img_1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// file object
		File f_1 = null;

		for(int k = 0; k <= 4; k++ )
{			int[] data = x[k];
			int count_1=0;
			for (int y1 = 0; y1 < height; y1++)
			{
				for (int x1 = 0; x1 < width; x1++)
				{
					//int a = data[count_1];//						//(int)(Math.random()*256); //generating
					int r = data[count_1++]; //values
					int g =  data[count_1++]; //less than
					int b =  data[count_1++]; //256
					Color c = new Color(r, g, b);
					//int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
					img_1.setRGB(x1, y1, c.getRGB());
				}
				// write image
				try
				{
					f_1 = new File("./img/out_shares"+ k + ".jpg");
					ImageIO.write(img_1, "jpg", f_1);
				}
				catch(IOException e)
				{
					System.out.println("Error: " + e);
				}
			}
}
		
/////////////// Read Image Code ****************** Five images from read_0 to read_4////////		        


		// for image_0

		BufferedImage img_read_0 = null;
		File f_read_0 = null;
		//read image
		try{

			f_read_0 = new File("./img/out_shares0.jpg");
			img_read_0 = ImageIO.read(f_read_0);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width_0 = img_read_0.getWidth();
		int height_0 = img_read_0.getHeight();


		int count_read_0 = 0;

		int[] myimage_0 = new int[width * height *3];

		for(int i=0; i<height_0 ; i++)
		{
			for(int j=0; j<width_0 ; j++)
			{

				Color c = new Color(img_read_0.getRGB(j, i));

				int  red_0 = c.getRed();
				int blue_0 = c.getGreen();
				int green_0 = c.getBlue();

				myimage_0[count_read_0++] = red_0;
				myimage_0[count_read_0++] = green_0;//myArray[count++] = green;
				myimage_0[count_read_0++] = blue_0;//myArray[count++] = blue;

			}
		}


// for image_1

		BufferedImage img_read_1 = null;
		File f_read_1 = null;
		//read image
		try{

			f_read_1 = new File("./img/out_shares1.jpg");
			img_read_1 = ImageIO.read(f_read_1);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width_1 = img_read_1.getWidth();
		int height_1 = img_read_1.getHeight();


		int count_read_1 = 0;

		int[] myimage_1 = new int[width_1 * height_1 *3];

		for(int i=0; i<height_1 ; i++)
		{
			for(int j=0; j<width_1 ; j++)
			{

				Color c = new Color(img_read_1.getRGB(j, i));

				int  red_1 = c.getRed();
				int blue_1 = c.getGreen();
				int green_1= c.getBlue();

				myimage_1[count_read_1++] = red_1;
				myimage_1[count_read_1++] = green_1;//myArray[count++] = green;
				myimage_1[count_read_1++] = blue_1;//myArray[count++] = blue;

			}
		}


		//image_2

		BufferedImage img_read_2 = null;
		File f_read_2 = null;
		//read image
		try{

			f_read_2 = new File("./img/out_shares2.jpg");
			img_read_2 = ImageIO.read(f_read_2);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width_2 = img_read_2.getWidth();
		int height_2 = img_read_2.getHeight();


		int count_read_2 = 0;

		int[] myimage_2 = new int[width_2 * height_2 *3];

		for(int i=0; i<height_2 ; i++)
		{
			for(int j=0; j<width_2 ; j++)
			{

				Color c = new Color(img_read_2.getRGB(j, i));

				int  red_2 = c.getRed();
				int blue_2 = c.getGreen();
				int green_2= c.getBlue();

				myimage_2[count_read_2++] = red_2;
				myimage_2[count_read_2++] = green_2;//myArray[count++] = green;
				myimage_2[count_read_2++] = blue_2;//myArray[count++] = blue;

			}
		}


		//image_3

		BufferedImage img_read_3 = null;
		File f_read_3 = null;
		//read image
		try{

			f_read_3 = new File("./img/out_shares3.jpg");
			img_read_3 = ImageIO.read(f_read_3);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width_3 = img_read_3.getWidth();
		int height_3 = img_read_3.getHeight();


		int count_read_3 = 0;

		int[] myimage_3 = new int[width_3 * height_3 *3];

		for(int i=0; i<height_3 ; i++)
		{
			for(int j=0; j<width_3 ; j++)
			{

				Color c = new Color(img_read_3.getRGB(j, i));

				int  red_3 = c.getRed();
				int blue_3 = c.getGreen();
				int green_3= c.getBlue();

				myimage_3[count_read_3++] = red_3;
				myimage_3[count_read_3++] = green_3;//myArray[count++] = green;
				myimage_3[count_read_3++] = blue_3;//myArray[count++] = blue;

			}
		}


		//image_4

		BufferedImage img_read_4 = null;
		File f_read_4 = null;
		//read image
		try{

			f_read_4 = new File("./img/out_shares4.jpg");
			img_read_4 = ImageIO.read(f_read_4);
		}catch(IOException e){
			System.out.println(e);
		}

		//get width and height
		int width_4 = img_read_4.getWidth();
		int height_4 = img_read_4.getHeight();


		int count_read_4 = 0;

		int[] myimage_4 = new int[width_4 * height_4 *3];

		for(int i=0; i<height_4 ; i++)
		{
			for(int j=0; j<width_4 ; j++)
			{

				Color c = new Color(img_read_4.getRGB(j, i));

				int  red_4 = c.getRed();
				int blue_4 = c.getGreen();
				int green_4= c.getBlue();

				myimage_4[count_read_4++] = red_4;
				myimage_4[count_read_4++] = green_4;//myArray[count++] = green;
				myimage_4[count_read_4++] = blue_4;//myArray[count++] = blue;

			}
		}
		
		
		int[]  myARray  = new int[myimage_4.length];
		//////////////// begin from here///////////
		for(int i=0; i< myimage_4.length;i++) {


			
			final BigInteger prime_1 = scheme.getPrime();
			final shamir_1 scheme2 = new shamir_1(3,5);
			final BigInteger prime2 = BigInteger.valueOf(prime_1.intValue());
			
			int arr1 = myimage_0[i];
			int arr2 = myimage_1[i];
			int arr3 = myimage_2[i];
			int arr4 = myimage_3[i];
			int arr5 = myimage_4[i];
			
			shamir_1.SecretShare_1 sh1 = scheme2.new SecretShare_1(0, BigInteger.valueOf(arr1));
			shamir_1.SecretShare_1 sh2 = scheme2.new SecretShare_1(1, BigInteger.valueOf(arr2));
			shamir_1.SecretShare_1 sh3 = scheme2.new SecretShare_1(2, BigInteger.valueOf(arr3));
			shamir_1.SecretShare_1 sh4 = scheme2.new SecretShare_1(3, BigInteger.valueOf(arr4));
			shamir_1.SecretShare_1 sh5 = scheme2.new SecretShare_1(3, BigInteger.valueOf(arr5));
			shamir_1.SecretShare_1 sharearray[] = {sh1, sh2, sh3, sh4, sh5}; 
			final BigInteger result_2 = scheme.combine(sharearray,prime2);
			myARray[i] = result_2.intValue();
		}

		
		
		BufferedImage img_2 = null;
		img_2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// file object
		File f_2 = null;
		int count_1 = 0;
		for (int y1 = 0; y1 < height; y1++)
		{
			for (int x1 = 0; x1 < width; x1++)
			{
				//int a = myArray[count_1];//						//(int)(Math.random()*256); //generating
				int r = myArray[count_1++]; //values
				int g =  myArray[count_1++]; //less than
				int b =  myArray[count_1++]; //256

				//int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel
				Color c = new Color(r, g, b);
				img_2.setRGB(x1, y1, c.getRGB());
			}
			// write image
			try
			{
				f_2 = new File("./img/out_shares_final.jpg");
				ImageIO.write(img_2, "jpg", f_2);
			}
			catch(IOException e)
			{
				System.out.println("Error: " + e);
			}
		}

		long processed = System.nanoTime() - cpuTime;
	       
	     long clockTime = System.currentTimeMillis() - wallClockTime;
	       
	       
	       
	       System.out.println("total CPU time in nanoseconds" + processed);
	       
	       System.out.println("total Wall clock time is" + clockTime);
		
		
	}


}


