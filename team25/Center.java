package team25;

import hockey.api.*;

public class Center extends BasePlayer {
  public void init() {
    setAimOnStick(true);
  }

  // Number of center player
  public int getNumber() { return 0; }

  // Name of center player
  public String getName() { return "Center"; }

  // Center player's intelligence
  public void step() {
    IPuck puck = getPuck();
    if (hasPuck()) {
      if (getX() < GOAL_POSITION.getX())
        shoot(GOAL_POSITION, MAX_SHOT_SPEED);
      else
        moveTowards(GOAL_POSITION.getX() - 400, 100);
    } else if (puck.isHeld() && !puck.getHolder().isOpponent()) {
      moveTowards(1500, 0);
    } else if (Util.dist(this, puck) < 600) {
      skate(puck, MAX_SPEED);
    } else {
      moveTowards(getPuck().getX() / 2, getPuck().getY());
    }
  }
}
