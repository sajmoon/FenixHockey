package team25;

import hockey.api.*;

public class Defender extends BasePlayer {
    // Number of defender
    public int getNumber() { return getIndex() == 1 ? 1 : 2; }
    
    Position SHOOTING_POSITION = new Position(1000, 0);
    Position DEFENDING_POSITION = new Position(-1000, 0);
    Position DEFENDING_MIDDLE_POSITION = new Position(-700, 0);
    Position ATTACKING_MIDDLE_POSITION = new Position(700, 0);

    // Name of defender
    public String getName() { 
      if (getIndex() == 1) {
        return "Birgitta";
      } else {
       return "Gööörgy"; 
      }
    }

    // Make left defender left handed, right defender right handed.
    public boolean isLeftHanded() { return getIndex() == 1; }

    // Initiate
    public void init() {
      setAimOnStick(false);
      SHOOTING_POSITION = new Position(1000, normalY());
      DEFENDING_POSITION = new Position(-1000, normalY());
      Position DEFENDING_MIDDLE_POSITION = new Position(-700, normalY());
      Position ATTACKING_MIDDLE_POSITION = new Position(700, normalY());
    }

    private int normalY() {
      return (getIndex() == 1) ? -700 : 700;
    }

    // Defender intelligence
    public void step() {
      setDebugMessage();
      if (hasPuck()) {
        IPlayer center = getPlayer(5);
        if (center.getX() > getX())
          shoot(getPlayer(5), MAX_SHOT_SPEED);
        else
          shoot(GOAL_POSITION, MAX_SHOT_SPEED);
        return;
      }

      IPuck puck = getPuck();
      if (puck.isHeld()) {
        IPlayer holder = puck.getHolder();
        if (holder.isOpponent()) {
          // Dom har den
          if (puckInDefenderArea(puck)) {
            skate(puck.getHolder(), MAX_SPEED);
          }
        } else {
          // Vi håller den.
          if (puckInForwardArea(puck)) {
            moveToShootingArea();
          } else if (puckInMiddleArea(puck)) {
            moveToAttackingMiddleArea();
          } else {
            /* skate(puck.getX(), normalY(), MAX_SPEED); */
          }
        }
      } else {
        if (puckInAssignedDefenderArea(puck)) {
          skate(puck, MAX_SPEED);
        } else if(puckInForwardArea(puck)) {
          moveToShootingArea();
        } else if (puckInMiddleArea(puck)) {
          moveToDefendingArea();
        }
      }
    }

    private void moveToDefendingArea() {
      skate(DEFENDING_POSITION, MAX_SPEED);
    }

    private void moveToShootingArea() {
      skate(SHOOTING_POSITION, MAX_SPEED);
    }

    private void moveToAttackingMiddleArea() {
      skate(ATTACKING_MIDDLE_POSITION, MAX_SPEED);
    }
            
    private boolean puckInForwardArea(IPuck puck) {
      if (puck.getX() > 867) {
        return true;
      } 
      return false;
    }

    private boolean puckInMiddleArea(IPuck puck) {
      if (puck.getX() > -867 && puck.getX() < 867) {
        return true;
      }
      return false;
    }

    private boolean puckInDefenderArea(IPuck puck) {
      if (puck.getX() < -867) {
        return true;
      }
      return false;
    }

    private boolean puckInAssignedDefenderArea(IPuck puck) {
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


    private void setDebugMessage() {
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
