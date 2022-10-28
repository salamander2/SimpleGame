package simpleGame;

import java.awt.Color;
import hsa2.GraphicsConsole;

public class Bounce1 {

	public static void main(String[] args) {
		new Bounce1();
	}
	
	//constants (final static) --> use ALL CAPS
	final static int WINW = 800;
	final static int WINH = 600;
	
	GraphicsConsole gc = new GraphicsConsole(WINW, WINH);
		
	//ball variables
	int x = 100;
	int y = 100;
	int size = 40;
	int speedx = 3; //# of pixels moved
	int speedy = 3; //normally 3, but 35 makes cool patterns if gc.clear() is off.
	
	Bounce1() {
		setup(); //this only happens once
		
		//main game loop
		while(true) {
			//move ball
			x += speedx;
			y += speedy;
			
			//bounce and change colour (bright colours only)
			if (y > WINH-size) {
				gc.setColor(new Color(
						Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f)));
				speedy *= -1;
			}
			if (x > WINW-size) {
				gc.setColor(new Color(Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f)));
				speedx *= -1;
			}			
			if (x < 0) {
				gc.setColor(new Color(Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f)));
				speedx *= -1;
			}
			if (y < 0) {
				gc.setColor(new Color(Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f)));
				speedy *= -1;
			}
			
			//draw ball
			synchronized(gc) {
				gc.clear();
				gc.fillOval(x,y,size,size);
			}
			
			//you have to include sleep so graphics get updated
			gc.sleep(5);
		}		
	}
	
	void setup() {
		gc.setTitle("Bouncing ball");
		gc.setLocationRelativeTo(null);
		gc.setAntiAlias(true);
		gc.setBackgroundColor(Color.WHITE);
		gc.clear();
		gc.setColor(Color.RED);
		gc.setResizable(false);
	}
	

}
