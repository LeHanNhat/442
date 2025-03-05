package lab1q5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void testAddPoint() {
		int x =0;
		int y =5;
		Point p = new Point(x, y);
		int x1=1;
		int y1=4;
		
		assertEquals( new Point(1,9).toString() ,p.add(new Point(x1,y1)).toString());
	}
	@Test
	void testSubPoint() {
		int x =0;
		int y =5;
		Point p = new Point(x, y);
		int x1=1;
		int y1=4;
		
		assertEquals( new Point(-1,1).toString() ,p.sub(new Point(x1,y1)).toString());
	}
}
