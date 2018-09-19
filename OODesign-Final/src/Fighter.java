import java.awt.Graphics;
import java.awt.Point;

public abstract class Fighter {
	
	int health;
	String description = "Unkown fighter";
	int speed;
	int radius;
	int x;
	int y;
	int localSearchSpace;
	Point location = new Point(x,y);
	
	public String getDescription() {
		return description;
	}
	
	public void setLocation(int x, int y) {
		location = new Point(x,y);
	}
	
	public Point getPoint() {
		return location;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public abstract void targetFighter();
	public abstract void move();
	public abstract void attack();
	public abstract void update(Fighter fighter, ContainerBox box);
	public abstract void draw(Graphics g);

}
