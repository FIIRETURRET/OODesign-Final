import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Warrior extends Fighter{
	
	public Warrior(int newRadius, int newx, int newy) {
		description = "A Warrior";
		health = 50;
		speed = 2;
		radius = newRadius;
		x = newx;
		y = newy;
		location = new Point(x,y);
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
	
	public void update(Fighter target, ContainerBox box) {
		// Get the ball's bounds, offset by the radius of the ball
		int ballMinX = box.minX + radius;
		int ballMinY = box.minY + radius;
		int ballMaxX = box.maxX - radius;
		int ballMaxY = box.maxY - radius;
		
		location = new Point(x,y);
		Point targetPoint = target.getPoint();
		// Check if the ball moves over the bounds. If so, adjust the position and speed.
		if (x < ballMinX) {
		   x = ballMinX;     // Re-position the ball at the edge
		   
		} else if (x > ballMaxX) {
		   x = ballMaxX;
		}
		else if(x < targetPoint.x) {
			x += speed;
		}
		else if(x > targetPoint.x) {
			x -= speed;
		}
		else if(x == targetPoint.x) {
			x = targetPoint.x;
		}
		// May cross both x and y bounds
		if (y < ballMinY) {
			
		   y = ballMinY;
		} else if (y > ballMaxY) {
		   
		   y = ballMaxY;
		}
		else if(y < targetPoint.y) {
			y += speed;
		}
		else if(y > targetPoint.y) {
			y -= speed;
		}
		else if(y == targetPoint.y) {
			y = targetPoint.y;
		}
	}
	
	/** Draw itself using the given graphics context. */
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	}

	
}
