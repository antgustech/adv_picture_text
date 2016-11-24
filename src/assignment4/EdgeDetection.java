package assignment4;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

import assignment2.MorphImage;

public class EdgeDetection {

	public static void main(String[] args) {
		new EdgeDetection();
	}

	public EdgeDetection() {
		String url0 = "valve.png";
		detect(url0);
	}

	/**
	 * Detects edges.
	 * @param url - filepath to the iamge.
	 */
	private void detect(String url) {
		BufferedImage orgImage = readImage(url);
		int width = orgImage.getWidth();
		int height = orgImage.getHeight();
		BufferedImage resImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
		WritableRaster inraster = orgImage.getRaster();
		WritableRaster outraster = resImage.getRaster();

		
		System.out.println("size: " + width + "X" + height);
		// Loop through every pixel, ignores the edges as these will throw out of
		//bounds.
		for (int i = 1; i < width-2; i++) {
			for (int j = 1; j < height-2; j++) {

				// Compute filter result, loops over in a
				// box pattern.
				int sum = 0;
				for (int x = -1; x <= 1; x++) {
					for (int y = -1; y <= 1; y++) {
						
						int sum1 = i+y;
						int sum2 = j+x;
					
						int p = inraster.getSample(sum1, sum2, 0);
						sum = sum + p;
					}
				}
				int q = (int) Math.round(sum / 9.0);
				
				if(q<150){
					q = 0;
				}else{
					q = 255;
				}
				outraster.setSample(i, j, 0, q);
			}
		}
		writeImage(resImage, "png", "EdgeDetection " + url);
	}

	/**
	 * Uses a URL to read an image into a file.
	 * 
	 * @param URL - the filepath of the image.
	 * @return BufferedImage - a BufferedImage object of an image.
	 */
	private BufferedImage readImage(String URL) {
		BufferedImage img = null;

		URL defaultImage = MorphImage.class.getResource(URL);
		try {
			File file = new File(defaultImage.toURI());
			img = ImageIO.read(file);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return img;
	}

	/**
	 * Creates a new image file from the given BufferedImage.
	 * 
	 * @param img - BufferedImage that will get written.
	 * @param fileExt - file extension to the new file.
	 * @param title - name and filepath to the new file.
	 */
	private void writeImage(BufferedImage img, String fileExt, String title) {
		try {
			ImageIO.write(img, fileExt, new File(title));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Morphed image: " + title);
	}

}