package team25;

import hockey.api.GoalKeeper;
import hockey.api.Position;

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
	    
      int x = GOAL_POSITION.getX();
      int y = GOAL_POSITION.getY();

      int dX = x - getPuck().getX();
      int dY = y - getPuck().getY();

      int ang = getPuck().getHeading();

      
      skate(GOAL_POSITION.getX(), GOAL_POSITION.getY(), 200);
	    
      //Face the puck
      turn(getPuck(), MAX_TURN_SPEED);
    }
}
