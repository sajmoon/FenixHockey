package team25;

import hockey.api.*;

public abstract class BasePlayer extends Player {
  // The middle of the opponents goal, on the goal line
  protected static final Position GOAL_POSITION = new Position(2600, 0);

  Position SHOOTING_POSITION = new Position(1000, 0);
  Position DEFENDING_POSITION = new Position(-1000, 0);
  Position DEFENDING_MIDDLE_POSITION = new Position(-700, 0);
  Position ATTACKING_MIDDLE_POSITION = new Position(700, 0);

  // Left handed?
  public boolean isLeftHanded() { return false; }

  // Initiate
  public void init() {
  }

  // Face off
  public void faceOff() {
  }

  // Penalty shot
  public void penaltyShot() {
  }

  // Player intelligence goes here
  public void step() {
  }

  public boolean moveTowards(int x, int y) {
    int dist = (int)Util.dist((double)Math.abs(getX() - x), (double)Math.abs(getY() - y));
    int speed = MAX_SPEED;
    if (dist < 400) {
      turn(getPuck(), MAX_TURN_SPEED);
      skate(20);
    } else if (dist < 1000) {
      speed -= 1000 - dist;
      skate(x, y, speed - 1000 - dist);
    }
    return true;
  }

  public boolean moveTowards(IObject obj) {
    return moveTowards(obj.getX(), obj.getY());
  }


    public void moveToDefendingArea() {
      moveTowards(DEFENDING_POSITION);
    }

    public void moveToShootingArea() {
      moveTowards(SHOOTING_POSITION);
    }

    public void moveToAttackingMiddleArea() {
      moveTowards(ATTACKING_MIDDLE_POSITION);
    }
            
    public boolean puckInForwardArea(IPuck puck) {
      if (puck.getX() > 867) {
        return true;
      } 
      return false;
    }

    public boolean puckInMiddleArea(IPuck puck) {
      if (puck.getX() > -867 && puck.getX() < 867) {
        return true;
      }
      return false;
    }

   public boolean puckInDefenderArea(IPuck puck) {
      if (puck.getX() < -867) {
        return true;
      }
      return false;
    }


    public void setDebugMessage() {
      String s = "";
      if (puckInForwardArea(getPuck())) {
        s = s + "Puck in forward area ";
      }

      if (puckInMiddleArea(getPuck())) {
        s = s + "Puck in middle area ";
      }

      if (puckInDefenderArea(getPuck())) {
        s = s + "Puck in defender area ";
      }

      if (getPuck().isHeld()) {
        s = s + "Held";
      }

      setMessage(s);
    }
}
