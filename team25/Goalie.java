package team25;

import hockey.api.GoalKeeper;
import hockey.api.Position;
import hockey.api.Util;

public class Goalie extends GoalKeeper {
    // Middle of our own goalcage, on the goal line
    protected static final Position GOAL_POSITION = new Position(-2600, 0);

    // Number of the goalie.
    public int getNumber() { return 1; }

    // Name of the goalie.
    public String getName() { return "Bengan"; }

    // Left handed goalie
    public boolean isLeftHanded() { return true; }

    // Initiate
    public void init() { }

    // Face off
    public void faceOff() { }

    // Called when the goalie is about to receive a penalty shot
    public void penaltyShot() { }

    // Intelligence of goalie.
    public void step() {
	    
      double ang = Util.datan2(getPuck(), GOAL_POSITION);

      ang = Util.clamp(-90,ang, 90);
      
      double heading = getTargetHeading();

      double newX = GOAL_POSITION.getX() + Math.cos(ang)*150;

      double newY = GOAL_POSITION.getY() + Math.sin(ang)*150;
      
      setMessage(Double.toString(newX) + " " + Double.toString(newY) + " " + Double.toString(ang));
      
      skate((int)newX, (int)newY, 50);
	    
      //Face the puck
      turn(getPuck(), MAX_TURN_SPEED);
    }

    private int distance(int x1, int y1, int x2, int y2) {
      int returnValue = Util.sqr(x1 - x2) + Util.sqr(y1 - y2);
      return returnValue;
    }
}
