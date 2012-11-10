package team25;

import hockey.api.Position;
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

  public boolean isBehindOwnGoal() {
    return getX() < 400;
  }

  protected Position posTowardsGoal() {
    return new Position(GOAL_POSITION.getX() - 400, GOAL_POSITION.getY());
  }


    public void moveToDefendingArea() {
      skate(DEFENDING_POSITION, MAX_SPEED);
    }

    public void moveToShootingArea() {
      skate(SHOOTING_POSITION, MAX_SPEED);
    }

    public void moveToAttackingMiddleArea() {
      skate(ATTACKING_MIDDLE_POSITION, MAX_SPEED);
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

    public boolean puckInAssignedDefenderArea(IPuck puck) {
      if (puckInDefenderArea(puck)) {
        if (getIndex() == 1) {
          if (puck.getY() < 0 ) {
            return true;
          }
        } else {
          if (puck.getY() > 0) {
            return true;
          }
        }
      }
      return false;
    }

    public boolean puckInAssignedAttackArea(IPuck puck) {
      if (puckInAttackArea(puck)) {
        if (getIndex() == 1) {
          if (puck.getY() < 0 ) {
            return true;
          }
        } else {
          if (puck.getY() > 0) {
            return true;
          }
        }
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
