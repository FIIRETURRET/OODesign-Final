import java.awt.Color;
import java.awt.Graphics;

public class Warrior extends Fighter{
	
	public Warrior(int newRadius, int newx, int newy) {
		description = "A Warrior";
		health = 50;
		speed = 20;
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
		g.setColor(Color.blue);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	}

	
}
