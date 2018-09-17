import java.awt.Color;
import java.awt.Graphics;

public class Archer extends Fighter{
	
	public Archer(int newRadius, int newx, int newy) {
		description = "An Archer";
		health = 25;
		speed = 25;
		radius = newRadius;
		x = newx;
		y = newy;
		localSearchSpace = 50;
	}
	
	// Find the closest Archer
	@Override
	public void targetFighter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		x +=1;
	}
	
	/** Draw itself using the given graphics context. */
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	}

	
}
