package team25;

import hockey.api.*;

public class Forward extends BasePlayer {
  public void init() {
    setAimOnStick(true);
  }

  // Number of forward
  public int getNumber() { return 15; }

  // Name of forward
  public String getName() {
    if (getIndex() == 1) {
      return "Boooob";
    } else {
     return "Halvberg"; 
    }
  }

  // Intelligence of forward
  public void step() {
    IPuck puck = getPuck();
    if (hasPuck()) {
      IPlayer center = getPlayer(5);
      IPlayer prioBack = getPlayer(1);
      IPlayer back1 = getPlayer(1);
      IPlayer back2 = getPlayer(2);

      //if (getX() < center.getX() && getX() < 1000)
      if (getX() > 2600 ){
        if (getY() > 0) {
          prioBack = back1;
        } else {
          prioBack = back2;
        }
        
        if (back1.getX() > 867) {
          shoot(prioBack, MAX_SHOT_SPEED / 2);
        } else if (center.getX() > 867) {
          shoot(center, MAX_SHOT_SPEED / 2); // pass center player
        }
      }
      else if (getX() > GOAL_POSITION.getX()) {
        skate(GOAL_POSITION.getX() - 400, 50, MAX_SPEED);
      } else {
        shoot(GOAL_POSITION, MAX_SHOT_SPEED);
      }
    }
    else {
      if (puck.isHeld()) {
        IPlayer holder = puck.getHolder();
        if (holder.isOpponent()) {

        } else {
          //Vi har den
        }
        /* skate(getPuck(), MAX_SPEED); // get the puck */
      } else {
        // Not held
        if (getX() > 867) {
          if (!puckInForwardArea(puck)) {
            moveToAttackingMiddleArea();
            return;
          }
        }

        if (puckInAssignedAttackArea(puck)) {
          // Den är på våran sida.
          skate(puck, MAX_SPEED);
        } else {
          // inte vårt problem
        }
      }
      skate(puck, MAX_SPEED);
    }
  }
}
