package polarizedladder;

import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;

public abstract class GameHeuristics {

	public String open = "open";
	public Hashtable<Point, String> openPoints;
	public Hashtable<Point, String> closedPoints;
	public Iterator<Point> it;
	
    public GameHeuristics(){
    	
    	 openPoints = new Hashtable<Point, String>();
    	 closedPoints = new Hashtable<Point, String>();
    	 openPoints = initializeOpenPoints(openPoints);
    	 it = openPoints.keySet().iterator();
    	 
    }
	
	public Point winPatterns[][] = { 			
			{new Point(0,0), new Point(1,0), new Point (1,1), new Point (2,1) , new Point (2,2)},			//  right ladder patterns
			{new Point(-1,0), new Point(0,0), new Point (0,1), new Point (1,1) , new Point (1,2)},
			{new Point (-1,-1), new Point (0,-1), new Point(0,0), new Point(1,0), new Point (1,1)},
			{new Point (-2,-1), new Point (-1,-1), new Point (-1,0), new Point(0,0), new Point(0,1)},
			{new Point (-2,-2), new Point (-1,-2), new Point (-1,-1), new Point(0,-1), new Point(0,0)},
			{new Point(0,0), new Point(-1,0), new Point (-1,1), new Point (-2,1) , new Point (-2,2)},		//	left ladder patterns
			{new Point(1,0), new Point(0,0), new Point (0,1), new Point (-1,1) , new Point (-1,2)},
			{new Point (1,-1), new Point (0,-1), new Point(0,0), new Point(-1,0), new Point (-1,1)},
			{new Point (2,-1), new Point (1,-1), new Point (1,0), new Point(0,0), new Point(0,1)},
			{new Point (2,-2),  new Point (1,-2), new Point (1,-1), new Point(0,-1), new Point(0,0)},
	};

	

    Hashtable<Point, String> initializeOpenPoints(Hashtable<Point, String> openPoints){
		openPoints = new Hashtable<Point, String>();
		int center = 7;
		int finalPoint = 13;
		Point p;
		for(int i = 1; i <= center; i++){
			for(int j = 1; j <= 7; j++){
				p = new Point(j, i);
				openPoints.put(p, open);
				if(i==j){

					break;//inner loop
				}
			}
		}

       for(int i = center+1 ; i <= finalPoint; i++){
			for(int j = center-1; j >= 1; j--){
				p = new Point(j, i);
				addPoint(p);
			}
		}
		
		return openPoints;
	}  

	void addPoint(Point p){

		openPoints.put(p, open);
	}

	void addFinalPoint(Point p){

		openPoints.put(p, open);
	}
	

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public Hashtable<Point, String> getOpenPoints() {
		return openPoints;
	}

	public void setOpenPoints(Hashtable<Point, String> openPoints) {
		this.openPoints = openPoints;
	}

	public Hashtable<Point, String> getClosedPoints() {
		return closedPoints;
	}

	public void setClosedPoints(Hashtable<Point, String> closedPoints) {
		this.closedPoints = closedPoints;
	}

	public Point[][] getWinPatterns() {
		return winPatterns;
	}

	public void setWinPatterns(Point[][] winPatterns) {
		this.winPatterns = winPatterns;
	}
	
	
}
