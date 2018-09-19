import java.awt.Point;

public class General {
	
	Fighter[] fighterList;
	
	public General(Fighter[] newfighterlist) {
		fighterList = newfighterlist;
	}
	
	public Fighter findClosestFighter(Fighter fighter) {
		// Get position of current fighter
		Point fighterPos = fighter.getPoint();
		// Set the first point rediculously far away
		Point enemyPoint = new Point(10000,10000);
		Fighter closestEnemy = null;
		
		for (int x = 0; x < fighterList.length; x++) {
			if (fighterList[x] == fighter) {
				// If our fighter in our list of fighters is the one we are dealing with, skip over it
			}
			else {
				if (findDistanceBetweenPoints(fighter.getPoint(), fighterList[x].getPoint()) < findDistanceBetweenPoints(fighter.getPoint(), enemyPoint)){
					// if our new enemy is closer than our old enemy update the saved point and closestEnemy
					enemyPoint = fighterList[x].getPoint();
					closestEnemy = fighterList[x];
				}
			}
		}
		return closestEnemy;
	}
	
	public static Point subtract(Point p1, Point p2) {
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}
	
	public double findDistanceBetweenPoints(Point p1, Point p2) {
		return Math.sqrt((p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p2.x) * (p2.x - p2.x));
	}
	
	public void update() {
		for (int x=0; x<fighterList.length; x++) {
			findClosestFighter(fighterList[x]);
		}
	}

}
