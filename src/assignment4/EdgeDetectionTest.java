package assignment4;

import org.junit.Test;

/**
 * Tests the Edge detection with different images and thresholds..
 * 
 * @author Anton Gustafsson
 *
 */
public class EdgeDetectionTest {

	 @Test
	 public void testSearch1() {
		EdgeDetection ed = new EdgeDetection("valve.PNG", 100);
	 }
	
	// @Test
	// public void testSearch2() {
	// EdgeDetection ed = new EdgeDetection("bricks.jpg", 130);
	// }
	//
	// @Test
	// public void testSearch3() {
	// EdgeDetection ed = new EdgeDetection("filledCircle.png", 80);
	// }
	//
	// @Test
	// public void testSearch4() {
	// EdgeDetection ed = new EdgeDetection("valve.png", 100);
	// }
	//
	// @Test
	// public void testSearch5() {
	// EdgeDetection ed = new EdgeDetection("ernst_pic1.jpg", 100);
	// }
}
