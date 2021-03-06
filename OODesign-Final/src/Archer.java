import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Fighter{
	
	private int randomNum;

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
		// Update current target information
		this.target = target;
		this.targetPoint = target.getPoint();
		
		location = new Point(x,y);
		targetPoint = target.getPoint();
		// Get the ball's bounds, offset by the radius of the ball
		int ballMinX = box.minX + radius;
		int ballMinY = box.minY + radius;
		int ballMaxX = box.maxX - radius;
		int ballMaxY = box.maxY - radius;
		
		if (health > 0) {
		
			//Movement
			// Check if the ball moves over the bounds. If so, adjust the position and speed.
			if (x < ballMinX) {
			   x = ballMinX;     // Re-position the ball at the edge
			   
			} else if (x > ballMaxX) {
			   x = ballMaxX;
			}
			// If the ball is to the left of the target, move left
			else if(x < targetPoint.x) {
				x -= speed;
			}
			// If the ball is to the right of the target, move right
			else if(x > targetPoint.x) {
				x += speed;
			}
			// If the ball is on the same spot as the target, move a random direction
			else if(x == targetPoint.x) {
				randomNum = ThreadLocalRandom.current().nextInt(0,2);
				if (randomNum == 0) {
					x += speed;
				}
				else {
					x -= speed;
				}
			}
			else if(x == targetPoint.x && y == targetPoint.y) {
				randomNum = ThreadLocalRandom.current().nextInt(0,4);
				if (randomNum == 0) {
					x += speed+1*2;
					y += speed+1*2;
				}
				else if(randomNum == 1){
					x -= speed+1*2;
					y -= speed+1*2;
				}
				else if (randomNum == 2) {
					x += speed+1*2;
					y -= speed+1*2;
				}
				else {
					x -= speed+1*2;
					y += speed+1*2;
				}
			}
			// May cross both x and y bounds
			if (y < ballMinY) {
				
			   y = ballMinY;
			} else if (y > ballMaxY) {
			   
			   y = ballMaxY;
			}
			// If the ball is under the target, move down
			else if(y < targetPoint.y) {
				y -= speed;
			}
			// if the ball is above the target, move up
			else if(y > targetPoint.y) {
				y += speed;
			}
			else if(y == targetPoint.y) {
				randomNum = ThreadLocalRandom.current().nextInt(0,2);
				if (randomNum == 0) {
					y += speed;
				}
				else {
					y -= speed;
				}
			}
			else if(x == targetPoint.x && y == targetPoint.y) {
				randomNum = ThreadLocalRandom.current().nextInt(0,4);
				if (randomNum == 0) {
					x += speed+1*2;
					y += speed+1*2;
				}
				else if(randomNum == 1){
					x -= speed+1*2;
					y -= speed+1*2;
				}
				else if (randomNum == 2) {
					x += speed+1*2;
					y -= speed+1*2;
				}
				else {
					x -= speed+1*2;
					y += speed+1*2;
				}
			}
		}
		
		location = new Point(x,y);
		
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
