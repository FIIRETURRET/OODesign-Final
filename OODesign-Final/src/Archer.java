import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Archer extends Fighter{
	
	public Archer(int newRadius, int newx, int newy) {
		description = "An Archer";
		type = "archer";
		health = 25;
		speed = 1;
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
	public void attack(Fighter fighter) {
		// TODO Auto-generated method stub
		
	}
	
	public void takeDamage(int damage) {
		health = health - damage;
	}
	
	public void update(Fighter target, ContainerBox box) {
		location = new Point(x,y);
		Point targetPoint = target.getPoint();
		// Get the ball's bounds, offset by the radius of the ball
		int ballMinX = box.minX + radius;
		int ballMinY = box.minY + radius;
		int ballMaxX = box.maxX - radius;
		int ballMaxY = box.maxY - radius;
		
		if (health > 0) {
		
			//Movemnet
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
				x += speed;
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
				y += speed;
			}
			else if(y == targetPoint.y) {
				y = targetPoint.y;
			}
		}
		
	}
	
	public Point getPoint() {
		return location;
	}
	
	/** Draw itself using the given graphics context. */
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	}

	
}
