import java.awt.Color;
import java.util.Scanner;

public class ImageProcess {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = "";
		int scaleFactor = 1;
		ImageUtils image = new ImageUtils();
		// Loading the original image
		Color[][] original = image.loadImage("src/LennaCV.png");
		
		System.out.println("Do you have a good screen resolution?"
				+ "\n[1] Yes"
				+ "\n[2] No");
		input = in.next();
		
		if (Integer.parseInt(input) == 1) {
			System.out.println();
			System.out.println("Alright, displaying the picture as you desired!");
		} else {
			System.out.println();
			System.out.println("Alright, adjusting the picture as you desired!");
		}
		
		// Adding the original image tab to the window
		image.addImage(original, "Original");
		
		// Changing the blue feather to a green feather
		Color[][] greenFeather = greenFeather(original);
		image.addImage(greenFeather, "Green Feather");
		
		// Changing the image to a demon perspective
		Color[][] demon = demonColor(original);
		image.addImage(demon, "Demon Perspective");
		
		
		// Adding an inverted color image
		Color[][] inverted = invert(original);
		image.addImage(inverted, "Inverted");
		
		// Adding a black and white image
		Color[][] blackWhite = blackWhite(original);
		image.addImage(blackWhite, "Black and White");
		
		// Adding a rainbow perspective on the original image
		Color[][] lgbt = lgbt(original);
		image.addImage(lgbt, "Rainbow");
		
		// Flipping the image horizontally
		Color[][] hFlip = hFlip(original);
		image.addImage(hFlip, "Horizontal Flip");
		
		// Flipping the image vertically
		Color[][] vFlip = vFlip(original);
		image.addImage(vFlip, "Vertical Flip");
		
		// Displaying the image on the window
		image.display();
	}
	
	// Inverting the colors of the original image
	public static Color[][] invert(Color[][] image) {
		Color[][] temp = ImageUtils.cloneArray(image);
		for (int c = 0; c < temp.length; c++) {
			for (int r = 0; r < temp[c].length; r++) {
				Color pixel = temp[c][r];
				temp[c][r] = new Color(256 - (pixel.getRed()), (256 - pixel.getGreen()),
						(256 - pixel.getBlue()));
			}
		}
		return temp;
	}
	
	// Changing the original image to a black and white image
	public static Color[][] blackWhite(Color[][] image){
		Color[][] temp = ImageUtils.cloneArray(image);
		for (int c = 0; c < temp.length; c++) {
			for (int r = 0; r < temp[c].length; r++) {
				Color pixel = temp[r][c];
				int black = pixel.getBlue() + pixel.getRed() + pixel.getGreen();
				temp[r][c] = new Color(black / 3, black / 3
						, black / 3);
				}
			}
		return temp;
		}
	
	// Add a rainbow perspective over the original image
	public static Color[][] lgbt(Color[][] image) {
		Color[][] temp = ImageUtils.cloneArray(image);
		for (int c = 0; c < temp.length; c++) {
			if (c <= (temp.length/7)) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 212)/2, (pixel.getGreen() + 6)/2,
							(pixel.getBlue() + 6)/2);
				}
			} else if (c > (temp.length/7) && c <= (2 * temp.length)/7) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 238)/2, 
							(pixel.getGreen() + 156)/2, (pixel.getBlue() + 0)/2);
				}
			} else if (c > (2 * temp.length)/7 && c <= (3 * temp.length)/7) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 227)/2, 
							(pixel.getGreen() + 255)/2, (pixel.getBlue() + 0)/2);
				}
			} else if (c > (3 * temp.length)/7 && c <= (4 * temp.length)/7) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 6)/2, 
							(pixel.getGreen() + 191)/2, (pixel.getBlue() + 0)/2);
				}
			}else if (c > (4 * temp.length)/7 && c <= (5 * temp.length)/7) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 100)/2, 
							(pixel.getGreen() + 256)/2, (pixel.getBlue() + 100)/2);
				}
			}else if (c > (5 * temp.length)/7 && c <= (6 * temp.length)/7) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 45)/2, 
							(pixel.getGreen() + 69)/2, (pixel.getBlue() + 45)/2);
				}
			}else {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					temp[c][r] = new Color((pixel.getRed() + 0)/2, 
							(pixel.getGreen() + 26)/2, (pixel.getBlue() + 152)/2);
				}
			}
			
		}
		
		return temp;
	}
	
	// Flipping the original image horizontally
	public static Color[][] hFlip(Color[][] image) {
		Color [][] temp = ImageUtils.cloneArray(image);
		Color [][] flippedH = new Color[temp.length][temp[0].length];
		for (int c = 0; c < temp.length; c++) {
			for (int r = 0; r < temp[c].length; r++) {
				flippedH[c][r] = temp[c][(temp[c].length - 1) - r];
			}
		}
		
		return flippedH;
		
	}
	
	// Flipping the original image vertically
	public static Color[][] vFlip(Color[][] image) {
		Color[][] temp = ImageUtils.cloneArray(image);
		Color[][] flippedV = new Color[temp.length][temp[0].length];
		for (int c = 0; c < temp.length; c++) {
			for (int r = 0; r < temp[c].length; r++) {
				flippedV[c][r] = temp[(temp.length - 1) - c][r];
			}
		}
		
		return flippedV;
	}
	
	//Changing the blue feather to a green feather image
	public static Color[][] greenFeather (Color[][] image){
		Color[][] temp = ImageUtils.cloneArray(image);
		for (int c = 0; c < temp.length; c++) {
			for (int r = 0; r < temp[c].length; r++) {
				Color pixel = temp[c][r];
				int green = pixel.getGreen();
				if (pixel.getBlue() > 100) {
					green = pixel.getBlue();
					if(green < 250) green = green + 25;
				}
				temp[c][r] = new Color(pixel.getRed(), green, pixel.getBlue());
			}
			}
		return temp;
		}
	
	//Changing the original image to a demon perspective image
		public static Color[][] demonColor (Color[][] image){
			Color[][] temp = ImageUtils.cloneArray(image);
			for (int c = 0; c < temp.length; c++) {
				for (int r = 0; r < temp[c].length; r++) {
					Color pixel = temp[c][r];
					int green = pixel.getGreen();
					if (pixel.getBlue() > 100) {
						green = pixel.getBlue();
						if(green < 250) green = 25;
					}
					temp[c][r] = new Color(pixel.getRed(), green, pixel.getBlue());
				}
				}
			return temp;
			}
	
	}
	
